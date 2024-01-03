package net.guwy.ntm.content.network_packages;

import net.guwy.ntm.utils.MenuWithPlayerInv;
import net.guwy.ntm.utils.ModEnergyStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class EnergySyncS2CPacket {
    private final int energy;
    private final BlockPos pos;

    public EnergySyncS2CPacket(int energy, BlockPos pos) {
        this.energy = energy;
        this.pos = pos;
    }

    public EnergySyncS2CPacket(FriendlyByteBuf buf) {
        this.energy = buf.readInt();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(energy);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            BlockEntity blockEntity = Minecraft.getInstance().level.getBlockEntity(pos);

            blockEntity.getCapability(ForgeCapabilities.ENERGY).ifPresent(handler -> {
                ModEnergyStorage energyStorage = (ModEnergyStorage) handler;
                energyStorage.setEnergy(energy);

                if(Minecraft.getInstance().player.containerMenu instanceof MenuWithPlayerInv menu &&
                        menu.getBlockEntity().getBlockPos().equals(pos)){
                    energyStorage.setEnergy(energy);
                }
            });
        });
        return true;
    }
}
