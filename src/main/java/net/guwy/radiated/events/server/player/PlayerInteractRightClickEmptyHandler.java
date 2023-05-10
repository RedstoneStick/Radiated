package net.guwy.radiated.events.server.player;

import net.guwy.radiated.content.network_packages.VisorWipeC2SPacket;
import net.guwy.radiated.index.ModNetworking;
import net.guwy.radiated.mechanics.gasmask.IVisorItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class PlayerInteractRightClickEmptyHandler {
    public static void init(PlayerInteractEvent.RightClickEmpty event){
        Player player = event.getEntity();
        Level level = player.getLevel();

        ModNetworking.sendToServer(new VisorWipeC2SPacket());
    }



}
