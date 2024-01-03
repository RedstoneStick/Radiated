package net.guwy.ntm.mechanics.hazard_items;

import net.minecraft.world.item.ItemStack;

public interface IHydroreactiveItem {
    default boolean isHydroreactive(ItemStack itemStack){
        return true;
    }
}
