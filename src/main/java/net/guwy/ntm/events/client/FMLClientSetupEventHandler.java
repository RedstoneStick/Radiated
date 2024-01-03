package net.guwy.ntm.events.client;

import net.guwy.ntm.content.blocks.machines.rtg.RTGScreen;
import net.guwy.ntm.content.blocks.machines.turbine.TurbineScreen;
import net.guwy.ntm.index.NTMFluids;
import net.guwy.ntm.index.NTMMenuTypes;
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
        MenuScreens.register(NTMMenuTypes.TURBINE_MENU.get(), TurbineScreen::new);
        MenuScreens.register(NTMMenuTypes.RTG_MENU.get(), RTGScreen::new);
    }

    private static void SetBlockTransparency(FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(NTMFluids.FLOWING_UF6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(NTMFluids.SOURCE_UF6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(NTMFluids.SOURCE_STEAM_LOW_PRESSURE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(NTMFluids.FLOWING_STEAM_LOW_PRESSURE.get(), RenderType.translucent());
    }
}
