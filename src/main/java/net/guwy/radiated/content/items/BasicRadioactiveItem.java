package net.guwy.radiated.content.items;

import net.guwy.radiated.mechanics.radiation.IRadiatedItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BasicRadioactiveItem extends Item implements IRadiatedItem {
    double radiationVal;

    public BasicRadioactiveItem(Properties pProperties, double radiationVal) {
        super(pProperties);
        this.radiationVal = radiationVal;
    }

    @Override
    public double radiationVal(ItemStack itemStack) {
        return radiationVal;
    }
}
