package net.guwy.radiated.content.blocks.machines.turbine;

import net.guwy.radiated.content.network_packages.TurbineSyncS2CPacket;
import net.guwy.radiated.index.ModNetworking;
import net.guwy.radiated.index.RDTBlockEntities;
import net.guwy.radiated.index.RDTResources;
import net.guwy.radiated.utils.ModEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.atomic.AtomicBoolean;

public class TurbineBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            AtomicBoolean valid = new AtomicBoolean(false);
            stack.getCapability(ForgeCapabilities.ENERGY).ifPresent(energyStorage -> {
                valid.set(true);
            });
            return valid.get();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 200;

    public TurbineBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(RDTBlockEntities.TURBINE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> TurbineBlockEntity.this.progress;
                    case 1 -> TurbineBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pValue) {
                    case 0 -> TurbineBlockEntity.this.progress = pValue;
                    case 1 -> TurbineBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public static void onUse(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        TurbineBlockEntity blockEntity = (TurbineBlockEntity) pLevel.getBlockEntity(pPos);
        ModNetworking.sendToClients(new TurbineSyncS2CPacket(blockEntity.getEnergyStorage().getEnergyStored(), pPos));
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("block.radiated.turbine");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new TurbineMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER){
            return lazyItemHandler.cast();
        }
        if(cap == ForgeCapabilities.ENERGY){
            return lazyEnergyStorage.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyStorage = LazyOptional.of(() -> ENERGY_STORAGE);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyStorage.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("inventory", this.itemHandler.serializeNBT());
        pTag.putInt("energy", this.ENERGY_STORAGE.getEnergyStored());
        pTag.putInt("progress", this.progress);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        this.ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));
        this.progress = pTag.getInt("progress");
    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i=0; i < itemHandler.getSlots(); i++){
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    public static  void tick(Level level, BlockPos blockPos, BlockState state, TurbineBlockEntity pEntity) {
        if(level.isClientSide()){
            return;
        }

        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for(int i=0; i < pEntity.itemHandler.getSlots(); i++){
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        boolean hasCorrectItemInSlot = inventory.getItem(0).getItem().equals(RDTResources.THORIUM_FUEL_BILLET.get());

        boolean tempBool = hasCorrectItemInSlot && inventory.getItem(0).getCount() == 1;

        pEntity.ENERGY_STORAGE.setEnergy(Math.min(pEntity.CAPACITY, pEntity.ENERGY_STORAGE.getEnergyStored() + 100));
        setChanged(level, blockPos, state);

        inventory.getItem(0).getCapability(ForgeCapabilities.ENERGY).ifPresent(itemEnergy -> {
            int chargeVal = itemEnergy.receiveEnergy(pEntity.ENERGY_STORAGE.getEnergyStored(), false);
            pEntity.ENERGY_STORAGE.extractEnergy(chargeVal, false);
            setChanged(level, blockPos, state);
        });



    }



    private final int CAPACITY = 1000000;
    private final ModEnergyStorage ENERGY_STORAGE = new ModEnergyStorage(CAPACITY, 0, CAPACITY) {
        @Override
        public void onEnergyChanged() {
            setChanged();
            ModNetworking.sendToClients(new TurbineSyncS2CPacket(this.energy, getBlockPos()));
        }
    };

    private LazyOptional<IEnergyStorage> lazyEnergyStorage = LazyOptional.empty();
    private static final int MAX_ENERGY_DRAIN = 50000;

    public IEnergyStorage getEnergyStorage() {
        return ENERGY_STORAGE;
    }

    public void setEnergyLevel(int energy) {
        this.ENERGY_STORAGE.setEnergy(energy);
    }
}
