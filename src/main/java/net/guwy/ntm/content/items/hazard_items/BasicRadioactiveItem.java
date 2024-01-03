package net.guwy.ntm.content.items.hazard_items;

import net.guwy.ntm.mechanics.hazard_items.IRadiatedItem;
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
