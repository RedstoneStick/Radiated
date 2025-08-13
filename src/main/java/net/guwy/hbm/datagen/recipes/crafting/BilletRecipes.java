package net.guwy.hbm.datagen.recipes.crafting;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.index.ModTags;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class BilletRecipes extends RecipeProvider implements IConditionBuilder {
    private static void init() {
        makeBillet(NTMResourcesNParts.BILLET_COBALT, ModTags.Items.INGOTS_COBALT, ModTags.Items.NUGGETS_COBALT);
    }

    public BilletRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static void registerRecipes(RecipeOutput recipeOutput) {
        init();

        ingotToBilletMap.forEach((billetItem, ingotTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, billetItem, 3)
                    .pattern("AA")
                    .define('A', ingotTag)
                    .unlockedBy(getHasName(billetItem), has(ingotTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/making_billet/from_ingot/" + getItemName(billetItem)));
        });
        nuggetToBilletMap.forEach((billetItem, nuggetTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, billetItem)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', nuggetTag)
                    .unlockedBy(getHasName(billetItem), has(nuggetTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/making_billet/from_nugget/" + getItemName(billetItem)));
        });
    }

    private static HashMap<ItemLike, TagKey<Item>> ingotToBilletMap = new HashMap<>();
    private static HashMap<ItemLike, TagKey<Item>> nuggetToBilletMap = new HashMap<>();

    private static void makeBillet(ItemLike billetItem, TagKey<Item> ingotTag) {
        ingotToBilletMap.put(billetItem, ingotTag);
    }
    private static void makeBillet(ItemLike billetItem, TagKey<Item> ingotTag, TagKey<Item> nuggetTag) {
        ingotToBilletMap.put(billetItem, ingotTag);
        nuggetToBilletMap.put(billetItem, nuggetTag);
    }
}
