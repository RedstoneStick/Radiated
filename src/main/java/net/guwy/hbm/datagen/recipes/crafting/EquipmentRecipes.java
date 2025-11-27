package net.guwy.hbm.datagen.recipes.crafting;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.index.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class EquipmentRecipes extends RecipeProvider implements IConditionBuilder {
    private static void init() {
        makeSword(NTMWeapons.REDSTONE_SWORD, Tags.Items.STORAGE_BLOCKS_REDSTONE);
        makeSword(NTMWeapons.STEEL_SWORD, ModTags.Items.INGOTS_STEEL);
        makeSword(NTMWeapons.TITANIUM_SWORD, ModTags.Items.INGOTS_TITANIUM);
        makeSword(NTMWeapons.COBALT_SWORD, ModTags.Items.INGOTS_COBALT);

        makeShovel(NTMTools.STEEL_SHOVEL, ModTags.Items.INGOTS_STEEL);
        makePickaxe(NTMTools.STEEL_PICKAXE, ModTags.Items.INGOTS_STEEL);
        makeAxe(NTMTools.STEEL_AXE, ModTags.Items.INGOTS_STEEL);
        makeHoe(NTMTools.STEEL_HOE, ModTags.Items.INGOTS_STEEL);
        makeShovel(NTMTools.TITANIUM_SHOVEL, ModTags.Items.INGOTS_TITANIUM);
        makePickaxe(NTMTools.TITANIUM_PICKAXE, ModTags.Items.INGOTS_TITANIUM);
        makeAxe(NTMTools.TITANIUM_AXE, ModTags.Items.INGOTS_TITANIUM);
        makeHoe(NTMTools.TITANIUM_HOE, ModTags.Items.INGOTS_TITANIUM);
        makeShovel(NTMTools.COBALT_SHOVEL, ModTags.Items.INGOTS_COBALT);
        makePickaxe(NTMTools.COBALT_PICKAXE, ModTags.Items.INGOTS_COBALT);
        makeAxe(NTMTools.COBALT_AXE, ModTags.Items.INGOTS_COBALT);
        makeHoe(NTMTools.COBALT_HOE, ModTags.Items.INGOTS_COBALT);

        makeHelmet(NTMArmors.STEEL_HELMET, ModTags.Items.INGOTS_STEEL);
        makeChestplate(NTMArmors.STEEL_PLATE, ModTags.Items.INGOTS_STEEL);
        makeLeggings(NTMArmors.STEEL_LEGS, ModTags.Items.INGOTS_STEEL);
        makeBoots(NTMArmors.STEEL_BOOTS, ModTags.Items.INGOTS_STEEL);
        makeHelmet(NTMArmors.TITANIUM_HELMET, ModTags.Items.INGOTS_TITANIUM);
        makeChestplate(NTMArmors.TITANIUM_PLATE, ModTags.Items.INGOTS_TITANIUM);
        makeLeggings(NTMArmors.TITANIUM_LEGS, ModTags.Items.INGOTS_TITANIUM);
        makeBoots(NTMArmors.TITANIUM_BOOTS, ModTags.Items.INGOTS_TITANIUM);
    }

    public EquipmentRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static void registerRecipes(RecipeOutput recipeOutput) {
        init();

        swordMap.forEach((resultItem, ingredientTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultItem)
                    .pattern("A")
                    .pattern("A")
                    .pattern("B")
                    .define('A', ingredientTag)
                    .define('B', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(resultItem), has(ingredientTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/equipment/sword/" + getItemName(resultItem)));
        });
        shovelMap.forEach((resultItem, ingredientTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, resultItem)
                    .pattern("A")
                    .pattern("B")
                    .pattern("B")
                    .define('A', ingredientTag)
                    .define('B', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(resultItem), has(ingredientTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/equipment/shovel/" + getItemName(resultItem)));
        });
        pickaxeMap.forEach((resultItem, ingredientTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, resultItem)
                    .pattern("AAA")
                    .pattern(" B ")
                    .pattern(" B ")
                    .define('A', ingredientTag)
                    .define('B', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(resultItem), has(ingredientTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/equipment/pickaxe/" + getItemName(resultItem)));
        });
        axeMap.forEach((resultItem, ingredientTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, resultItem)
                    .pattern("AA")
                    .pattern("AB")
                    .pattern(" B")
                    .define('A', ingredientTag)
                    .define('B', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(resultItem), has(ingredientTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/equipment/axe/" + getItemName(resultItem)));
        });
        hoeMap.forEach((resultItem, ingredientTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, resultItem)
                    .pattern("AA")
                    .pattern(" B")
                    .pattern(" B")
                    .define('A', ingredientTag)
                    .define('B', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(resultItem), has(ingredientTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/equipment/hoe/" + getItemName(resultItem)));
        });
        helmetMap.forEach((resultItem, ingredientTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultItem)
                    .pattern("AAA")
                    .pattern("A A")
                    .define('A', ingredientTag)
                    .unlockedBy(getHasName(resultItem), has(ingredientTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/equipment/armor/" + getItemName(resultItem)));
        });
        chestplateMap.forEach((resultItem, ingredientTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultItem)
                    .pattern("A A")
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', ingredientTag)
                    .unlockedBy(getHasName(resultItem), has(ingredientTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/equipment/armor/" + getItemName(resultItem)));
        });
        leggingsMap.forEach((resultItem, ingredientTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultItem)
                    .pattern("AAA")
                    .pattern("A A")
                    .pattern("A A")
                    .define('A', ingredientTag)
                    .unlockedBy(getHasName(resultItem), has(ingredientTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/equipment/armor/" + getItemName(resultItem)));
        });
        bootsMap.forEach((resultItem, ingredientTag) -> {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, resultItem)
                    .pattern("A A")
                    .pattern("A A")
                    .define('A', ingredientTag)
                    .unlockedBy(getHasName(resultItem), has(ingredientTag))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "crafting/equipment/armor/" + getItemName(resultItem)));
        });
    }

    private static HashMap<ItemLike, TagKey<Item>> swordMap = new HashMap<>();
    private static HashMap<ItemLike, TagKey<Item>> shovelMap = new HashMap<>();
    private static HashMap<ItemLike, TagKey<Item>> pickaxeMap = new HashMap<>();
    private static HashMap<ItemLike, TagKey<Item>> axeMap = new HashMap<>();
    private static HashMap<ItemLike, TagKey<Item>> hoeMap = new HashMap<>();
    private static HashMap<ItemLike, TagKey<Item>> helmetMap = new HashMap<>();
    private static HashMap<ItemLike, TagKey<Item>> chestplateMap = new HashMap<>();
    private static HashMap<ItemLike, TagKey<Item>> leggingsMap = new HashMap<>();
    private static HashMap<ItemLike, TagKey<Item>> bootsMap = new HashMap<>();

    private static void makeSword(ItemLike outputItem, TagKey<Item> ingredientItemTag) {
        swordMap.put(outputItem, ingredientItemTag);
    }
    private static void makeShovel(ItemLike outputItem, TagKey<Item> ingredientItemTag) {
        shovelMap.put(outputItem, ingredientItemTag);
    }
    private static void makePickaxe(ItemLike outputItem, TagKey<Item> ingredientItemTag) {
        pickaxeMap.put(outputItem, ingredientItemTag);
    }
    private static void makeAxe(ItemLike outputItem, TagKey<Item> ingredientItemTag) {
        axeMap.put(outputItem, ingredientItemTag);
    }
    private static void makeHoe(ItemLike outputItem, TagKey<Item> ingredientItemTag) {
        hoeMap.put(outputItem, ingredientItemTag);
    }
    private static void makeHelmet(ItemLike outputItem, TagKey<Item> ingredientItemTag) {
        helmetMap.put(outputItem, ingredientItemTag);
    }
    private static void makeChestplate(ItemLike outputItem, TagKey<Item> ingredientItemTag) {
        chestplateMap.put(outputItem, ingredientItemTag);
    }
    private static void makeLeggings(ItemLike outputItem, TagKey<Item> ingredientItemTag) {
        leggingsMap.put(outputItem, ingredientItemTag);
    }
    private static void makeBoots(ItemLike outputItem, TagKey<Item> ingredientItemTag) {
        bootsMap.put(outputItem, ingredientItemTag);
    }
}
