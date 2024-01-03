package net.guwy.radiated.mechanics.radiation;

import net.guwy.radiated.utils.ItemTagUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public interface IRadiationResistance {
    double resistanceVal();



    String TAG_DUCT_TAPE = "duct_tape";

    static List<Component> DuctTapeTooltip(ItemStack pStack, List<Component> pTooltipComponents, int index){
        List<Component> newTooltipComponents = new ArrayList<Component>();

        int ductTapeAmount = getDuctTapeAmount(pStack);
        if(ductTapeAmount > 0 || getMaxApplicableDuctTape(pStack) > 0){

            int currentMaxApplicableDuctTape = getMaxApplicableDuctTape(pStack);

            if(currentMaxApplicableDuctTape > ductTapeAmount) {
                newTooltipComponents.add(Component.translatable("tooltip.radiated.armor.patching.1").withStyle(ChatFormatting.GRAY));
                newTooltipComponents.add(Component.translatable("tooltip.radiated.armor.patching.2").withStyle(ChatFormatting.GRAY));
            }

            newTooltipComponents.add(Component.literal(Component.translatable("tooltip.radiated.armor.patching.3").getString() + "[" + ductTapeAmount + "/" + currentMaxApplicableDuctTape + "]"));

            // Formatting with if there's any other tooltip in mind
            if(pTooltipComponents.size() > index){
                if(pTooltipComponents.get(index).getString() != ""){
                    newTooltipComponents.add(Component.literal(""));
                }
            }
        }

        return newTooltipComponents;
    }

    static int getDuctTapeAmount(ItemStack itemStack){
        return ItemTagUtils.getInt(itemStack, TAG_DUCT_TAPE);
    }

    static void addDuctTape(ItemStack itemStack, int add){
        int x = ItemTagUtils.getInt(itemStack, TAG_DUCT_TAPE);
        ItemTagUtils.putInt(itemStack, TAG_DUCT_TAPE, x + add);
    }

    static int getMaxApplicableDuctTape(ItemStack itemStack){
        double damagePercent = ((double) itemStack.getDamageValue() / itemStack.getMaxDamage());
        return (int) Math.ceil(damagePercent * 4);
    }
}
