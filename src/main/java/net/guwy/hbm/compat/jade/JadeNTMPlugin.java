package net.guwy.hbm.compat.jade;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.blocks.machines.brick_furnace.BrickFurnaceBlockEntity;
import net.guwy.hbm.blocks.machines.brick_furnace.BrickFurnaceEntityBlock;
import net.guwy.hbm.index.NTMMachines;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import org.apache.commons.lang3.mutable.MutableObject;
import snownee.jade.addon.universal.ItemStorageProvider;
import snownee.jade.api.*;
import snownee.jade.api.callback.JadeBeforeRenderCallback;
import snownee.jade.api.callback.JadeBeforeTooltipCollectCallback;
import snownee.jade.api.theme.Theme;
import snownee.jade.api.ui.IBoxElement;
import snownee.jade.api.ui.TooltipRect;

@WailaPlugin
public class JadeNTMPlugin implements IWailaPlugin {
    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(BrickFurnaceComponentProvider.INSTANCE, BrickFurnaceBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        // Disabling default tooltips
        registration.registerBlockComponent(CustomItemStorageDisplayComponentProvider.INSTANCE, BrickFurnaceEntityBlock.class);

        registration.registerBlockComponent(BrickFurnaceComponentProvider.INSTANCE, BrickFurnaceEntityBlock.class);
    }
}
