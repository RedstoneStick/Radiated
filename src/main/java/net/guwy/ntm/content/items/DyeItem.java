package net.guwy.ntm.content.items;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DyeItem extends Item implements ItemColor {
    int color;

    public DyeItem(Properties pProperties, int color) {
        super(pProperties);
        this.color = color;
    }

    @Override
    public int getColor(ItemStack pStack, int pTintIndex) {
        if(pTintIndex == 1){
            return this.color;
        } else {
            return -1;
        }
    }
}
