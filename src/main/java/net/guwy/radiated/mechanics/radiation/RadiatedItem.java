package net.guwy.radiated.mechanics.radiation;

import net.minecraft.world.item.ItemStack;

public interface RadiatedItem {
    double radiationVal(ItemStack itemStack);
}
