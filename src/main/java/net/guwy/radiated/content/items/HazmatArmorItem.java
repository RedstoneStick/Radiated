package net.guwy.radiated.content.items;

import net.guwy.radiated.mechanics.gasmask.VisorItem;
import net.guwy.radiated.mechanics.radiation.RadiationResistanceModifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class HazmatArmorItem extends ArmorItem implements RadiationResistanceModifier, VisorItem {
    double radResistance;
    public HazmatArmorItem(double radResistance, ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
        this.radResistance = radResistance;
    }

    @Override
    public double resistanceVal() {
        return radResistance;
    }
}
