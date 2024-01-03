package net.guwy.ntm.mechanics.hazard_items;

import net.minecraft.world.item.ItemStack;

public interface IFlammableExplosiveItem {
    default boolean isFlammableExplosive(ItemStack itemStack){
        return true;
    }
}
