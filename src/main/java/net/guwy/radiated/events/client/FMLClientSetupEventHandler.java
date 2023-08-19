package net.guwy.radiated.events.client;

import net.guwy.radiated.content.blocks.machines.rtg.RTGScreen;
import net.guwy.radiated.content.blocks.machines.turbine.TurbineScreen;
import net.guwy.radiated.index.RDTFluids;
import net.guwy.radiated.index.RDTMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class FMLClientSetupEventHandler {
    public static void init(FMLClientSetupEvent event){
        RegisterMenuTypes(event);
        SetBlockTransparency(event);
    }

    private static void RegisterMenuTypes(FMLClientSetupEvent event){
        MenuScreens.register(RDTMenuTypes.TURBINE_MENU.get(), TurbineScreen::new);
        MenuScreens.register(RDTMenuTypes.RTG_MENU.get(), RTGScreen::new);
    }

    private static void SetBlockTransparency(FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(RDTFluids.FLOWING_UF6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RDTFluids.SOURCE_UF6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RDTFluids.SOURCE_STEAM_LOW_PRESSURE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RDTFluids.FLOWING_STEAM_LOW_PRESSURE.get(), RenderType.translucent());
    }
}
