package net.guwy.radiated.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.guwy.radiated.Radiated;
import net.guwy.radiated.compat.jei.recipe_categories.RTGRecipeCategory;
import net.guwy.radiated.index.ModRecipes;
import net.guwy.radiated.index.RDTMachines;
import net.guwy.radiated.recipes.RTGDecayRecipe;
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

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Radiated.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                RTGRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<RTGDecayRecipe> recipesRTG = rm.getAllRecipesFor(RTGDecayRecipe.Type.INSTANCE);
        registration.addRecipes(RTG_DECAY_TYPE, recipesRTG);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(RDTMachines.RTG.get()), RTG_DECAY_TYPE);
        IModPlugin.super.registerRecipeCatalysts(registration);
    }
}
