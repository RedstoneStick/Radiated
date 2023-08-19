package net.guwy.radiated.mechanics.hazard_items;

import net.guwy.radiated.mechanics.radiation.GetRadiationResistance;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public interface IAsbestosItem {
    double asbestosVal(ItemStack itemStack);
}
