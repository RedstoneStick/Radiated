package net.guwy.radiated.mechanics.radiation;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

public class GetRadiationResistance {
    /** values are the half of what hbm offers and generally uses a more linear approach **/

    public static double getVal(Player player){
        double totalResistance = 0;

        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            Item item = player.getItemBySlot(equipmentSlot).getItem();
            totalResistance += getItemVal(item);
        }

        List<MobEffectInstance> list = player.getActiveEffects().stream().toList();
        for(MobEffectInstance effectInstance : list){
            totalResistance += getEffectVal(effectInstance);
        }

        totalResistance = Math.max(0, Math.min(totalResistance, 0.99));

        return totalResistance;
    }



    public static double getItemVal(Item item){
        double val = 0;

        if(item instanceof RadiationResistanceModifier modifier){
            val = modifier.resistanceVal();
        }

        else if(item instanceof ArmorItem armorItem){
            EquipmentSlot slot = armorItem.getSlot();
            switch (slot){
                case HEAD -> val = 0.002;
                case CHEST -> val = 0.005;
                case LEGS -> val = 0.003;
                case FEET -> val = 0.001;
            }
        }
        return val;
    }



    public static double getEffectVal(MobEffectInstance effectInstance){
        if(effectInstance.getEffect() instanceof  RadiationResistanceModifier modifier){
            return modifier.resistanceVal();
        }   else {
            return 0;
        }
    }

    public static void tooltipHandler(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();

        double resistanceVal = GetRadiationResistance.getItemVal(item);
        if(resistanceVal != 0){
            Component tooltip;

            tooltip = Component.translatable("tooltip.radiated.radiation.resistance", Double.toString(resistanceVal * 100))
                    .withStyle(ChatFormatting.YELLOW);
            event.getToolTip().add(tooltip);
        }
    }
}
