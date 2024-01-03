package net.guwy.ntm.mechanics.hazard_items;

import net.minecraft.world.item.ItemStack;

public interface IPyrophoricHotItem {
    default boolean isPyrophoricHot(ItemStack itemStack){
        return true;
    }
}
