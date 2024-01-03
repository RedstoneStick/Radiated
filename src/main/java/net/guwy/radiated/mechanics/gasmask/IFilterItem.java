package net.guwy.radiated.mechanics.gasmask;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public interface IFilterItem {

    /** List of filterable hazards,
     * Use an empty list instead of a null for no filtration */
    List<AirborneHazardTypes> GetFiltrableHazards();



    // Tooltip to .addAll
    default List<Component> FilterItemTooltip(ItemStack pStack){
        List<Component> pTooltipComponents = new ArrayList<Component>();

        // Protection Tooltip
        if(!Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.generic"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift"));

            // Show filtration capabilities
            if(this.GetFiltrableHazards().contains(AirborneHazardTypes.AIRBORNE_PARTICLES)){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.airborne_particles"));
            }
            if(this.GetFiltrableHazards().contains(AirborneHazardTypes.PARTICULATES)){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.particulates"));
            }
            if(this.GetFiltrableHazards().contains(AirborneHazardTypes.CHEMICAL_GAS)){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.chemical_gas"));
            }
            if(this.GetFiltrableHazards().contains(AirborneHazardTypes.BACTERIA_AEROSOL)){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.bacteria_aerosols"));
            }
            if(this.GetFiltrableHazards().contains(AirborneHazardTypes.CARBON_MONOXIDE)){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.carbon_monoxide"));
            }
            if(this.GetFiltrableHazards().contains(AirborneHazardTypes.NERVE_AGENT)){
                pTooltipComponents.add(Component.translatable("tooltip.radiated.filter.shift.nerve_agent"));
            }

            // Return a debug message if no filtering can be done
            if(this.GetFiltrableHazards().isEmpty()){
                pTooltipComponents.add(Component.translatable("debug.radiated.filter.no_filtration_value"));
            }
        }

        //pTooltipComponents.add(Component.literal(""));  // Formatting

        return pTooltipComponents;
    }
}
