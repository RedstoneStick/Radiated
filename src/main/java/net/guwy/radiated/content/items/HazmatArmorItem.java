package net.guwy.radiated.content.items;

import net.guwy.radiated.mechanics.gasmask.IVisorItem;
import net.guwy.radiated.mechanics.radiation.RadiationResistanceModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HazmatArmorItem extends ArmorItem implements RadiationResistanceModifier, IVisorItem {
    double radResistance;
    public HazmatArmorItem(double radResistance, ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
        this.radResistance = radResistance;
    }

    @Override
    public double resistanceVal() {
        return radResistance;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        double totalVisorGunk = IVisorItem.getOuterGunkSum(pStack);
        double visorWater = IVisorItem.getOuterWater(pStack);

        if(visorWater > 0){
            pTooltipComponents.add(Component.translatable("tooltip.radiated.visor.outer.water"));
        } else if (totalVisorGunk > 0.2){
            pTooltipComponents.add(Component.translatable("tooltip.radiated.visor.outer.gunk"));
        }

        if(visorWater > 0 || totalVisorGunk > 0.2){
            pTooltipComponents.add(Component.translatable("tooltip.radiated.visor.outer.wipe"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
