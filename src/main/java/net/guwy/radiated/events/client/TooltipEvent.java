package net.guwy.radiated.events.client;

import net.guwy.radiated.mechanics.hazard_items.HazardItemTooltips;
import net.guwy.radiated.mechanics.radiation.GetRadiationResistance;
import net.guwy.radiated.mechanics.radiation.GetRadiationVal;
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

        // Asbestos Tooltip
        HazardItemTooltips.AsbestosTooltip(event);

        // Coal Dust Tooltip
        HazardItemTooltips.CoalDustTooltip(event);

        // Digamma Radiation Tooltip

        // Pyrophoric/Hot Item Tooltip
        HazardItemTooltips.PyrophoricHotTooltip(event);

        // Hydroreactive Item Tooltip
        HazardItemTooltips.HydroreactiveTooltip(event);

        // Flammable/Explosive Item Tooltip
        HazardItemTooltips.FlammableExplosiveTooltip(event);

        // Blinding Item Tooltip
        HazardItemTooltips.BlindingTooltip(event);
    }
}
