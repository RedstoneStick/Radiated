package net.guwy.hbm.items.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Optional;

public class BasicTooltipBlockItem extends BlockItem {
    Component[] tooltip;

    public BasicTooltipBlockItem(Block block, Properties properties, Component... tooltip) {
        super(block, properties);
        this.tooltip = tooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.addAll(List.of(tooltip));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
