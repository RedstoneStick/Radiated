package net.guwy.radiated.content.items.hazard_items;

import net.guwy.radiated.mechanics.hazard_items.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BasicHazardItem extends Item implements IRadiatedItem, IBlindingItem, IFlammableExplosiveItem, IHydroreactiveItem, IPyrophoricHotItem, IAsbestosItem, ICoalDustItem {
    double radiationVal;
    int coalDustVal, asbestosVal;
    boolean isBlinding, isFlammableExplosive, isHydroreactive, isPyrophoricHot;

    public BasicHazardItem(Properties pProperties, double radiationVal, int coalDustVal, int asbestosVal, boolean isPyrophoricHot, boolean isHydroreactive, boolean isBlinding, boolean isFlammableExplosive) {
        super(pProperties);
        this.radiationVal = radiationVal;
        this.coalDustVal = coalDustVal;
        this.asbestosVal = asbestosVal;
        this.isPyrophoricHot = isPyrophoricHot;
        this.isHydroreactive = isHydroreactive;
        this.isBlinding = isBlinding;
        this.isFlammableExplosive = isFlammableExplosive;
    }

    @Override
    public double radiationVal(ItemStack itemStack) {
        return radiationVal;
    }

    @Override
    public int asbestosVal(ItemStack itemStack) {
        return asbestosVal;
    }

    @Override
    public int coalDustVal(ItemStack itemStack) {
        return coalDustVal;
    }

    @Override
    public boolean isPyrophoricHot(ItemStack itemStack) {
        return isPyrophoricHot;
    }

    @Override
    public boolean isHydroreactive(ItemStack itemStack) {
        return isHydroreactive;
    }

    @Override
    public boolean isBlinding(ItemStack itemStack) {
        return isBlinding;
    }

    @Override
    public boolean isFlammableExplosive(ItemStack itemStack) {
        return isFlammableExplosive;
    }
}
