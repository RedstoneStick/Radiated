package net.guwy.radiated.content.network_packages;

import net.guwy.radiated.content.blocks.machines.rtg.RTGBlockEntity;
import net.guwy.radiated.content.blocks.machines.rtg.RTGMenu;
import net.guwy.radiated.mechanics.gasmask.IVisorItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class VisorWipeC2SPacket {

    public VisorWipeC2SPacket() {
    }

    public VisorWipeC2SPacket(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!

            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            IVisorItem.WipeVisor(player);
        });
        return true;
    }
}
