package net.guwy.ntm.mechanics.hazard_items;

import net.minecraft.world.item.ItemStack;

public interface IBlindingItem {
    default boolean isBlinding(ItemStack itemStack){
        return true;
    }
}
