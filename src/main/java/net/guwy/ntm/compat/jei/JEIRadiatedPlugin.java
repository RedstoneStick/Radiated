package net.guwy.ntm.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.guwy.ntm.NTM;
import net.guwy.ntm.compat.jei.recipe_categories.RTGRecipeCategory;
import net.guwy.ntm.compat.jei.recipe_categories.UsageRecipeCategory;
import net.guwy.ntm.index.NTMMachines;
import net.guwy.ntm.recipes.RTGDecayRecipe;
import net.guwy.ntm.recipes.UsageRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIRadiatedPlugin implements IModPlugin {
    public static RecipeType<RTGDecayRecipe> RTG_DECAY_TYPE =
            new RecipeType<>(RTGRecipeCategory.UID, RTGDecayRecipe.class);
    public static RecipeType<UsageRecipe> USAGE_RECIPE_TYPE =
            new RecipeType<>(UsageRecipeCategory.UID, UsageRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(NTM.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                UsageRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                RTGRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<UsageRecipe> recipesUsage = rm.getAllRecipesFor(UsageRecipe.Type.INSTANCE);
        registration.addRecipes(USAGE_RECIPE_TYPE, recipesUsage);

        List<RTGDecayRecipe> recipesRTG = rm.getAllRecipesFor(RTGDecayRecipe.Type.INSTANCE);
        registration.addRecipes(RTG_DECAY_TYPE, recipesRTG);


    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(NTMMachines.RTG.get()), RTG_DECAY_TYPE);
        IModPlugin.super.registerRecipeCatalysts(registration);
    }
}
