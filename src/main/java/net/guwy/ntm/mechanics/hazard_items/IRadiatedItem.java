package net.guwy.ntm.mechanics.hazard_items;

import net.minecraft.world.item.ItemStack;

public interface IRadiatedItem {
    double radiationVal(ItemStack itemStack);
}
