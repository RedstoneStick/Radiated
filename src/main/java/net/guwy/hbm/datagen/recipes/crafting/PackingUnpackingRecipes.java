package net.guwy.hbm.datagen.recipes.crafting;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.datagen.ModRecipeProvider;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PackingUnpackingRecipes extends RecipeProvider implements IConditionBuilder {
    private static void init() {
        pack9(NTMResourcesNParts.RAW_URANIUM, NTMOresNBlocks.BLOCK_RAW_URANIUM);
        pack9(NTMResourcesNParts.RAW_THORIUM, NTMOresNBlocks.BLOCK_RAW_THORIUM);
        pack9(NTMResourcesNParts.RAW_TITANIUM, NTMOresNBlocks.BLOCK_RAW_TITANIUM);
        pack9(NTMResourcesNParts.RAW_TUNGSTEN, NTMOresNBlocks.BLOCK_RAW_TUNGSTEN);
        pack9(NTMResourcesNParts.RAW_ALUMINIUM, NTMOresNBlocks.BLOCK_RAW_ALUMINIUM);
        pack9(NTMResourcesNParts.RAW_BERYLLIUM, NTMOresNBlocks.BLOCK_RAW_BERYLLIUM);
        pack9(NTMResourcesNParts.RAW_LEAD, NTMOresNBlocks.BLOCK_RAW_LEAD);
        pack9(NTMResourcesNParts.RAW_AUSTRALIUM, NTMOresNBlocks.BLOCK_RAW_AUSTRALIUM);
        pack9(NTMResourcesNParts.RAW_COBALT, NTMOresNBlocks.BLOCK_RAW_COBALT);

        pack9(NTMResourcesNParts.SULFUR, NTMOresNBlocks.BLOCK_SULFUR);
        pack9(NTMResourcesNParts.NITER, NTMOresNBlocks.BLOCK_NITER);
        pack9(NTMResourcesNParts.FLUORITE, NTMOresNBlocks.BLOCK_FLUORITE);
        pack9(NTMResourcesNParts.FRAGMENT_COLTAN, NTMOresNBlocks.BLOCK_COLTAN);
        pack9(NTMResourcesNParts.INGOT_ASBESTOS, NTMOresNBlocks.BLOCK_ASBESTOS);
    }

    public PackingUnpackingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static void registerRecipes(RecipeOutput recipeOutput) {
        init();

        pack9Map.forEach((unpackedItem, packedItem) -> {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, unpackedItem, 9)
                    .requires(packedItem)
                    .unlockedBy(getHasName(packedItem), has(packedItem))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/packing_unpacking/9packed/" + getItemName(packedItem) + "_to_" + getItemName(unpackedItem)));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, packedItem)
                    .pattern("AAA")
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', unpackedItem)
                    .unlockedBy(getHasName(unpackedItem), has(unpackedItem))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/packing_unpacking/9packed/" + getItemName(unpackedItem) + "_to_" + getItemName(packedItem)));
        });

        pack4Map.forEach((unpackedItem, packedItem) -> {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, unpackedItem, 4)
                    .requires(packedItem)
                    .unlockedBy(getHasName(packedItem), has(packedItem))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/packing_unpacking/4packed/" + getItemName(packedItem) + "_to_" + getItemName(unpackedItem)));
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, packedItem)
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', unpackedItem)
                    .unlockedBy(getHasName(unpackedItem), has(unpackedItem))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/packing_unpacking/4packed/" + getItemName(unpackedItem) + "_to_" + getItemName(packedItem)));
        });
    }


    private static HashMap<ItemLike, ItemLike> pack9Map = new HashMap<>();
    private static HashMap<ItemLike, ItemLike> pack4Map = new HashMap<>();

    private static void pack9(ItemLike unpackedItem, ItemLike packedItem) {
        pack9Map.put(unpackedItem, packedItem);
    }
    private static void pack4(ItemLike unpackedItem, ItemLike packedItem) {
        pack4Map.put(unpackedItem, packedItem);
    }
}
