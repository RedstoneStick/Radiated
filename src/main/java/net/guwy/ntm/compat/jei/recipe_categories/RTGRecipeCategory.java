package net.guwy.ntm.compat.jei.recipe_categories;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.guwy.ntm.NTM;
import net.guwy.ntm.compat.jei.JEIRadiatedPlugin;
import net.guwy.ntm.index.NTMMachines;
import net.guwy.ntm.recipes.RTGDecayRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class RTGRecipeCategory implements IRecipeCategory<RTGDecayRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(NTM.MOD_ID, "rtg_decay");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(NTM.MOD_ID, "textures/jei/jei_this_to_that.png");

    private final IDrawable background;
    private final IDrawable icon;

    public RTGRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 112, 36);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(NTMMachines.RTG.get()));
    }


    @Override
    public RecipeType getRecipeType() {
        return JEIRadiatedPlugin.RTG_DECAY_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("text.ntm.jei.rtg");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RTGDecayRecipe recipe, IFocusGroup focuses) {
        //builder.addSlot(RecipeIngredientRole.CATALYST, 47, 10).addItemStack(new ItemStack(RDTMachines.RTG.get()));

        builder.addSlot(RecipeIngredientRole.INPUT, 16, 10).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 10).addItemStack(recipe.getResultItem());

    }

}
