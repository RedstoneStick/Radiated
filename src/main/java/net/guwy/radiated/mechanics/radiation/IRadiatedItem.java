package net.guwy.radiated.mechanics.radiation;

import net.minecraft.world.item.ItemStack;

public interface IRadiatedItem {
    double radiationVal(ItemStack itemStack);
}
