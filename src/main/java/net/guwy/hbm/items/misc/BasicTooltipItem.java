package net.guwy.hbm.items.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class BasicTooltipItem extends Item {
    Component[] tooltip;

    public BasicTooltipItem(Properties properties, Component... tooltip) {
        super(properties);
        this.tooltip = tooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.addAll(List.of(tooltip));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
