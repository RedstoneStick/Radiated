package net.guwy.ntm.mechanics.radiation;

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

        // Resistance for worn armor
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            ItemStack itemStack = player.getItemBySlot(equipmentSlot);
            totalResistance += getItemVal(itemStack);
        }

        // Resistance for applied effects
        List<MobEffectInstance> list = player.getActiveEffects().stream().toList();
        for(MobEffectInstance effectInstance : list){
            totalResistance += getEffectVal(effectInstance);
        }

        // Resistance cap
        totalResistance = Math.max(0, Math.min(totalResistance, 0.99));

        return totalResistance;
    }



    public static double getItemVal(ItemStack itemStack){
        double val = 0;
        Item item = itemStack.getItem();

        // Resistance for armors that implement the custom interface
        if(item instanceof IRadiationResistance modifier){
            val = modifier.resistanceVal();

            // Part used to lower resistance depending on durability + recovers some depending on duct tape
            double durabilityPercent = 1 - ((double) itemStack.getDamageValue() / itemStack.getMaxDamage());
            durabilityPercent += 0.25 * IRadiationResistance.getDuctTapeAmount(itemStack);
            durabilityPercent = Math.min(durabilityPercent, 1);


            val = val * durabilityPercent;
        }

        // Default Resistance values
        else if(item instanceof ArmorItem armorItem){
            EquipmentSlot slot = armorItem.getSlot();
            switch (slot){
                case HEAD -> val = 0.002;
                case CHEST -> val = 0.005;
                case LEGS -> val = 0.003;
                case FEET -> val = 0.001;
                default -> val = 0;
            }
        }

        return val;
    }



    public static double getEffectVal(MobEffectInstance effectInstance){
        if(effectInstance.getEffect() instanceof  IRadiationResistance modifier){
            return modifier.resistanceVal();
        }   else {
            return 0;
        }
    }

    public static void tooltipHandler(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();

        double resistanceVal = Math.round(GetRadiationResistance.getItemVal(itemStack) * 10000) / 100.0;
        if(resistanceVal != 0){
            Component tooltip;

            tooltip = Component.translatable("tooltip.ntm.radiation.resistance", resistanceVal)
                    .withStyle(ChatFormatting.YELLOW);
            event.getToolTip().add(tooltip);
        }
    }
}
