package net.guwy.radiated.content.items;

import net.guwy.radiated.mechanics.gasmask.IGasmaskItem;
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

public class HazmatArmorItem extends ArmorItem implements IRadiationResistance, IGasmaskItem {
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

        // Armor patching with duct tape tooltips
        pTooltipComponents.addAll(1, IRadiationResistance.DuctTapeTooltip(pStack, pTooltipComponents, 1));

        ArmorItem armorItem = (ArmorItem) pStack.getItem();
        // Helmet specific tooltips
        if(armorItem.getSlot() == EquipmentSlot.HEAD){

            // Filter Tooltips
            pTooltipComponents.addAll(1, IGasmaskItem.FilterTooltip(pStack, pTooltipComponents, 1));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
