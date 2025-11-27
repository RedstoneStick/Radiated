package net.guwy.hbm.util;

import net.guwy.hbm.index.ModTags;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

import java.util.List;

public class AshUtil {
    public enum EnumAshType {
        COAL(NTMResourcesNParts.POWDER_ASH_COAL),
        WOOD(NTMResourcesNParts.POWDER_ASH_WOOD),
        MISC(NTMResourcesNParts.POWDER_ASH_MISC),
        FLY(NTMResourcesNParts.POWDER_ASH_FLY),
        SOOT(NTMResourcesNParts.POWDER_ASH_SOOT),
        FULLERENE(NTMResourcesNParts.POWDER_ASH_FULLERENE);

        final Item item;
        EnumAshType(ItemLike item) {
            this.item = item.asItem();
        }

        public Item getItem() {
            return this.item;
        }
    }

    public static EnumAshType getAshFromFuel(ItemStack stack) {
        // If something is named COKE but not tagged COKE  I will assume it's not COKE
        if (stack.is(ModTags.Items.COKE)) return EnumAshType.COAL;
        if (stack.is(ItemTags.COALS)) return EnumAshType.COAL;
        if (stack.is(ModTags.Items.LIGNITE)) return EnumAshType.COAL;

        // I wood :P
        if (stack.is(ItemTags.LOGS)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.PLANKS)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.WOODEN_SLABS)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.WOODEN_STAIRS)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.WOODEN_FENCES)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.FENCE_GATES)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.WOODEN_DOORS)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.WOODEN_TRAPDOORS)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.WOODEN_PRESSURE_PLATES)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.WOODEN_BUTTONS)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.SIGNS)) return EnumAshType.WOOD;
        if (stack.is(ItemTags.HANGING_SIGNS)) return EnumAshType.WOOD;

        return EnumAshType.MISC;
    }
}
