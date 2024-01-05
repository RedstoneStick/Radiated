package net.guwy.ntm.content.items;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MultiColorItem extends Item implements ItemColor {
    int[] color;

    /** @param color "-1" for default color anything else for color */
    public MultiColorItem(Properties pProperties, int... color) {
        super(pProperties);
        this.color = color;
    }

    @Override
    public int getColor(ItemStack pStack, int pTintIndex) {
        return this.color[pTintIndex];
    }
}
