package net.guwy.radiated.events.client;

import net.guwy.radiated.mechanics.radiation.GetRadiationResistance;
import net.guwy.radiated.mechanics.radiation.GetRadiationVal;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class TooltipEvent {
    public static void HazardSystemTooltips(ItemTooltipEvent event){
        //if(event.getItemStack().is(ModTags.Items.PLANKS)){
        //    event.getToolTip().add(Component.literal("hello").withStyle(ChatFormatting.AQUA));
        //}

        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();


        // Radiation Tooltip
        GetRadiationVal.tooltipHandler(event);

        // Radiation Resistance Tooltip
        GetRadiationResistance.tooltipHandler(event);
    }
}
