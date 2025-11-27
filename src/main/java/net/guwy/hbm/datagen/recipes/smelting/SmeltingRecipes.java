package net.guwy.hbm.datagen.recipes.smelting;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class SmeltingRecipes extends RecipeProvider implements IConditionBuilder {
    public SmeltingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private static void init() {
        //smeltInto(ModTags.Items.ORES_COBALT, NTMResourcesNParts.INGOT_COBALT);
        smeltInto(NTMOresNBlocks.ORE_COBALT, NTMResourcesNParts.INGOT_COBALT);
        blastInto(NTMOresNBlocks.ORE_COBALT, NTMResourcesNParts.INGOT_COBALT);
        smeltInto(NTMOresNBlocks.DEEPSLATE_ORE_COBALT, NTMResourcesNParts.INGOT_COBALT);
        blastInto(NTMOresNBlocks.DEEPSLATE_ORE_COBALT, NTMResourcesNParts.INGOT_COBALT);
        smeltInto(NTMResourcesNParts.RAW_COBALT, NTMResourcesNParts.INGOT_COBALT);
        blastInto(NTMResourcesNParts.RAW_COBALT, NTMResourcesNParts.INGOT_COBALT);

        smeltInto(NTMOresNBlocks.ORE_TITANIUM, NTMResourcesNParts.INGOT_TITANIUM);
        blastInto(NTMOresNBlocks.ORE_TITANIUM, NTMResourcesNParts.INGOT_TITANIUM);
        smeltInto(NTMOresNBlocks.DEEPSLATE_ORE_TITANIUM, NTMResourcesNParts.INGOT_TITANIUM);
        blastInto(NTMOresNBlocks.DEEPSLATE_ORE_TITANIUM, NTMResourcesNParts.INGOT_TITANIUM);
        smeltInto(NTMResourcesNParts.RAW_TITANIUM, NTMResourcesNParts.INGOT_TITANIUM);
        blastInto(NTMResourcesNParts.RAW_TITANIUM, NTMResourcesNParts.INGOT_TITANIUM);

        smeltInto(NTMResourcesNParts.FIRECLAY_BALL, NTMResourcesNParts.INGOT_FIREBRICK);
    }



    public static void registerRecipes(RecipeOutput recipeOutput) {
        init();

        smeltingMap.forEach((unsmeltedItem, smeltingResultItem) -> {
            smeltingRecipe(recipeOutput, unsmeltedItem, RecipeCategory.MISC, smeltingResultItem, 1, 200, smeltingResultItem.asItem().getDescription().getString());
        });
        smeltingTagMap.forEach((unsmeltedItem, smeltingResultItem) -> {
            smeltingRecipe(recipeOutput, unsmeltedItem, RecipeCategory.MISC, smeltingResultItem, 1, 200, smeltingResultItem.asItem().getDescription().getString());
        });

        blastingMap.forEach((unsmeltedItem, smeltingResultItem) -> {
            blastingRecipe(recipeOutput, unsmeltedItem, RecipeCategory.MISC, smeltingResultItem, 1, 100, smeltingResultItem.asItem().getDescription().getString());
        });
        blastingTagMap.forEach((unsmeltedItem, smeltingResultItem) -> {
            blastingRecipe(recipeOutput, unsmeltedItem, RecipeCategory.MISC, smeltingResultItem, 1, 100, smeltingResultItem.asItem().getDescription().getString());
        });

        smokingMap.forEach((unsmeltedItem, smeltingResultItem) -> {
            smokingRecipe(recipeOutput, unsmeltedItem, RecipeCategory.MISC, smeltingResultItem, 1, 100, smeltingResultItem.asItem().getDescription().getString());
        });
        smokingTagMap.forEach((unsmeltedItem, smeltingResultItem) -> {
            smokingRecipe(recipeOutput, unsmeltedItem, RecipeCategory.MISC, smeltingResultItem, 1, 100, smeltingResultItem.asItem().getDescription().getString());
        });
    }

    private static HashMap<ItemLike, ItemLike> smeltingMap = new HashMap<>();
    private static HashMap<ItemLike, ItemLike> blastingMap = new HashMap<>();
    private static HashMap<ItemLike, ItemLike> smokingMap = new HashMap<>();
    private static HashMap<TagKey<Item>, ItemLike> smeltingTagMap = new HashMap<>();
    private static HashMap<TagKey<Item>, ItemLike> blastingTagMap = new HashMap<>();
    private static HashMap<TagKey<Item>, ItemLike> smokingTagMap = new HashMap<>();

    private static void smeltInto(ItemLike unsmeltedItem, ItemLike smeltingResultItem) {
        smeltingMap.put(unsmeltedItem, smeltingResultItem);
    }
    private static void smeltInto(TagKey<Item> unsmeltedItemTag, ItemLike smeltingResultItem) {
        smeltingTagMap.put(unsmeltedItemTag, smeltingResultItem);
    }
    private static void blastInto(ItemLike unsmeltedItem, ItemLike smeltingResultItem) {
        blastingMap.put(unsmeltedItem, smeltingResultItem);
    }
    private static void blastInto(TagKey<Item> unsmeltedItemTag, ItemLike smeltingResultItem) {
        blastingTagMap.put(unsmeltedItemTag, smeltingResultItem);
    }
    private static void smokeInto(ItemLike unsmeltedItem, ItemLike smeltingResultItem) {
        smokingMap.put(unsmeltedItem, smeltingResultItem);
    }
    private static void smokeInto(TagKey<Item> unsmeltedItemTag, ItemLike smeltingResultItem) {
        smokingTagMap.put(unsmeltedItemTag, smeltingResultItem);
    }



    protected static void smeltingRecipe(RecipeOutput recipeOutput, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult,
                                         float pExperience, int pCookingTime, String group) {
        cooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,
                pIngredient, pCategory, pResult, pExperience, pCookingTime, group, "_from_smelting", "smelting");
    }
    protected static void smeltingRecipe(RecipeOutput recipeOutput, TagKey<Item> pIngredientTag, RecipeCategory pCategory, ItemLike pResult,
                                         float pExperience, int pCookingTime, String group) {
        cooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,
                pIngredientTag, pCategory, pResult, pExperience, pCookingTime, group, "_from_smelting", "smelting");
    }

    protected static void blastingRecipe(RecipeOutput recipeOutput, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult,
                                         float pExperience, int pCookingTime, String group) {
        cooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new,
                pIngredient, pCategory, pResult, pExperience, pCookingTime, group, "_from_blasting", "blasting");
    }
    protected static void blastingRecipe(RecipeOutput recipeOutput, TagKey<Item> pIngredientTag, RecipeCategory pCategory, ItemLike pResult,
                                         float pExperience, int pCookingTime, String group) {
        cooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new,
                pIngredientTag, pCategory, pResult, pExperience, pCookingTime, group, "_from_blasting", "blasting");
    }

    protected static void smokingRecipe(RecipeOutput recipeOutput, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult,
                                         float pExperience, int pCookingTime, String group) {
        cooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new,
                pIngredient, pCategory, pResult, pExperience, pCookingTime, group, "_from_smoking", "smoking");
    }
    protected static void smokingRecipe(RecipeOutput recipeOutput, TagKey<Item> pIngredientTag, RecipeCategory pCategory, ItemLike pResult,
                                        float pExperience, int pCookingTime, String group) {
        cooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new,
                pIngredientTag, pCategory, pResult, pExperience, pCookingTime, group, "_from_smoking", "smoking");
    }

    protected static <T extends AbstractCookingRecipe> void cooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                    ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String group, String pRecipeName, String folder) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredient), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory)
                .group(group).unlockedBy(getHasName(pResult), has(pIngredient))
                .save(recipeOutput, NTMMain.MODID + ":" + folder + "/" + getItemName(pResult) + pRecipeName + "_" + getItemName(pIngredient));
    }
    protected static <T extends AbstractCookingRecipe> void cooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                    TagKey<Item> pIngredientTag, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String group, String pRecipeName, String folder) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredientTag), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory)
                .group(group).unlockedBy(getHasName(pResult), has(pIngredientTag))
                .save(recipeOutput, NTMMain.MODID + ":" + folder + "/" + getItemName(pResult) + pRecipeName + "_" + pIngredientTag);
    }
}
