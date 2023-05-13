package net.guwy.radiated.content.items;

import net.guwy.radiated.mechanics.gasmask.IVisorItem;
import net.guwy.radiated.mechanics.radiation.IRadiationResistance;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HazmatArmorItem extends ArmorItem implements IRadiationResistance, IVisorItem {
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
        // Visor Gunk Tooltips
        pTooltipComponents.addAll(IVisorItem.VisorGunkTooltip(pStack));

        // Armor patching with duct tape tooltips
        pTooltipComponents.addAll(IRadiationResistance.DuctTapeTooltip(pStack));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
