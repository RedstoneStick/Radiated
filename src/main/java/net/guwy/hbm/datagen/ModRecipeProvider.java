package net.guwy.hbm.datagen;

import net.guwy.hbm.datagen.recipes.crafting.BilletRecipes;
import net.guwy.hbm.datagen.recipes.crafting.EquipmentRecipes;
import net.guwy.hbm.datagen.recipes.crafting.PackingUnpackingRecipes;
import net.guwy.hbm.datagen.recipes.smelting.SmeltingRecipes;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        PackingUnpackingRecipes.registerRecipes(recipeOutput);
        BilletRecipes.registerRecipes(recipeOutput);
        SmeltingRecipes.registerRecipes(recipeOutput);
        EquipmentRecipes.registerRecipes(recipeOutput);
    }
}
