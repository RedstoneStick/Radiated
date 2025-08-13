package net.guwy.hbm.index;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

public class ModToolTiers {
    public static final Tier STEEL = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 7.5f, 2f, 10, () -> Ingredient.of(ModTags.Items.INGOTS_STEEL));
    public static final Tier TITANIUM = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 750, 9f, 2.5f, 15, () -> Ingredient.of(ModTags.Items.INGOTS_TITANIUM));
    public static final Tier COBALT = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 750, 9f, 2.5f, 60, () -> Ingredient.of(ModTags.Items.INGOTS_COBALT));
}
