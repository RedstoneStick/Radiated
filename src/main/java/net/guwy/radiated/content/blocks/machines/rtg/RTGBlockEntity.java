package net.guwy.radiated.content.blocks.machines.rtg;

import net.guwy.radiated.content.items.RTGPelletItem;
import net.guwy.radiated.content.network_packages.RTGSyncS2CPacket;
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

public class RTGBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(16){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            AtomicBoolean valid = new AtomicBoolean(false);
            if(slot == 0){
                stack.getCapability(ForgeCapabilities.ENERGY).ifPresent(energyStorage -> {
                    valid.set(true);
                });
            } else {
                valid.set(stack.getItem() instanceof RTGPelletItem);
            }

            return valid.get();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int heat = 0;
    public int MAX_HEAT = 600;
    public static final double ENERGY_MULTIPLIER = 25;

    public static int getMaxHeat(){
        return 2400;
    }

    public RTGBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(RDTBlockEntities.RTG.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> RTGBlockEntity.this.heat;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pValue) {
                    case 0 -> RTGBlockEntity.this.heat = pValue;
                }
            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }

    public static void onUse(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        RTGBlockEntity blockEntity = (RTGBlockEntity) pLevel.getBlockEntity(pPos);
        ModNetworking.sendToClients(new RTGSyncS2CPacket(blockEntity.getEnergyStorage().getEnergyStored(), pPos));
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.radiated.rtg");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new RTGMenu(pContainerId, pPlayerInventory, this, this.data);
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
        pTag.putInt("heat", this.heat);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        this.ENERGY_STORAGE.setEnergy(pTag.getInt("energy"));
        this.heat = pTag.getInt("heat");
    }

    public void drops(){
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i=0; i < itemHandler.getSlots(); i++){
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    public static  void tick(Level level, BlockPos blockPos, BlockState state, RTGBlockEntity pEntity) {
        if(level.isClientSide()){
            return;
        }
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for(int i=0; i < pEntity.itemHandler.getSlots(); i++){
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        RTGBlock.setConnections(state, level, pEntity.getBlockPos());
        HeatCheck(inventory, pEntity);

        int energyGen = (int) (pEntity.heat * pEntity.ENERGY_MULTIPLIER);

        pEntity.ENERGY_STORAGE.setEnergy(Math.min(pEntity.CAPACITY, pEntity.ENERGY_STORAGE.getEnergyStored() + energyGen));
        ModNetworking.sendToClients(new RTGSyncS2CPacket(pEntity.ENERGY_STORAGE.getEnergyStored(), pEntity.getBlockPos()));
        setChanged(level, blockPos, state);

        PushEnergyToSlot(inventory, pEntity, 0);
        PushEnergyInAllDirections(pEntity);



    }

    private static void HeatCheck(SimpleContainer container, RTGBlockEntity pEntity){
        int heat = 0;
        for(int i = 1; i <= 15; i++){
            ItemStack itemStack = container.getItem(i);
            if(itemStack.getItem() instanceof RTGPelletItem pelletItem){
                heat = heat + pelletItem.getHeatVal(itemStack);

                CompoundTag nbtTag = new CompoundTag();
                if(itemStack.getTag() != null){
                    long remainingLife = itemStack.getTag().getLong(RTGPelletItem.getKeyLifetime());
                    nbtTag.putLong(RTGPelletItem.getKeyLifetime(), Math.max(0, remainingLife - 1));
                    itemStack.setTag(nbtTag);

                    if(remainingLife <= 0){
                        itemStack.setCount(0);
                        pEntity.itemHandler.setStackInSlot(i, new ItemStack(RTGPelletItem.getDecayedItem(pelletItem)));
                    }
                } else {
                    nbtTag.putLong(RTGPelletItem.getKeyLifetime(), Math.max(0, RTGPelletItem.getMaxLifetime(pelletItem)));
                    itemStack.setTag(nbtTag);
                }
            }
        }
        pEntity.heat = Math.min(heat, getMaxHeat());
    }

    private static void PushEnergyToSlot(SimpleContainer inventory, RTGBlockEntity pEntity, int slotIndex){
        inventory.getItem(slotIndex).getCapability(ForgeCapabilities.ENERGY).ifPresent(itemEnergy -> {
            int chargeVal = itemEnergy.receiveEnergy(pEntity.ENERGY_STORAGE.getEnergyStored(), false);
            pEntity.ENERGY_STORAGE.extractEnergy(chargeVal, false);
            setChanged(pEntity.getLevel(), pEntity.getBlockPos(), pEntity.getBlockState());
        });
    }

    private static void PushEnergyInAllDirections(RTGBlockEntity pEntity){
        for(Direction direction : Direction.values()){
            PushEnergyInDirection(pEntity, direction);
        }
    }

    private static void PushEnergyInDirection(RTGBlockEntity pEntity, Direction direction){
        Level level = pEntity.getLevel();
        BlockPos pos = pEntity.getBlockPos();
        BlockEntity neighbor = level.getBlockEntity(pos.relative(direction));

        if(neighbor != null){
            neighbor.getCapability(ForgeCapabilities.ENERGY, direction.getOpposite()).ifPresent(nEnergy ->{
                int maxEnergyExtract = pEntity.ENERGY_STORAGE.extractEnergy(Integer.MAX_VALUE, true);
                int energySent = nEnergy.receiveEnergy(Math.min(pEntity.ENERGY_STORAGE.getEnergyStored(), maxEnergyExtract), false);
                pEntity.ENERGY_STORAGE.extractEnergy(energySent, false);
            });
        }
    }



    private final int CAPACITY = 100000;
    private final ModEnergyStorage ENERGY_STORAGE = new ModEnergyStorage(CAPACITY, 0, CAPACITY) {
        @Override
        public void onEnergyChanged() {
            setChanged();
            ModNetworking.sendToClients(new RTGSyncS2CPacket(this.energy, getBlockPos()));
        }
    };

    private LazyOptional<IEnergyStorage> lazyEnergyStorage = LazyOptional.empty();

    public IEnergyStorage getEnergyStorage() {
        return ENERGY_STORAGE;
    }

    public void setEnergyLevel(int energy) {
        this.ENERGY_STORAGE.setEnergy(energy);
    }
}
