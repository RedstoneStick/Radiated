package net.guwy.hbm.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.guwy.hbm.NTMMain;
import net.guwy.hbm.blocks.machines.brick_furnace.BrickFurnaceMenu;
import net.guwy.hbm.blocks.machines.brick_furnace.BrickFurnaceScreen;
import net.guwy.hbm.index.ModMenuTypes;
import net.guwy.hbm.index.NTMMachines;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEINTMPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(BrickFurnaceMenu.class, ModMenuTypes.BRICK_FURNACE_MENU.get(), RecipeTypes.SMELTING, 0, 4, 4, 36);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalysts(RecipeTypes.SMELTING, NTMMachines.BRICK_FURNACE);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(BrickFurnaceScreen.class, 85, 35, 24, 16, RecipeTypes.SMELTING);
    }
}
