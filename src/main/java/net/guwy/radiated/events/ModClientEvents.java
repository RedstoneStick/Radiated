package net.guwy.radiated.events;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.blocks.machines.rtg.RTGScreen;
import net.guwy.radiated.content.blocks.machines.turbine.TurbineScreen;
import net.guwy.radiated.content.particles.VomitBloodParticle;
import net.guwy.radiated.content.particles.VomitParticle;
import net.guwy.radiated.events.client.FMLClientSetupEventHandler;
import net.guwy.radiated.events.client.RegisterGuiOverlaysEventHandler;
import net.guwy.radiated.events.client.RegisterParticleFactoriesEventHandler;
import net.guwy.radiated.events.client.TooltipEvent;
import net.guwy.radiated.events.server.player.PlayerInteractRightClickEmptyHandler;
import net.guwy.radiated.index.NTMParticles;
import net.guwy.radiated.index.RDTFluids;
import net.guwy.radiated.index.RDTMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModClientEvents {
    @Mod.EventBusSubscriber(modid = Radiated.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {


        @SubscribeEvent
        public static void tooltipEvent(ItemTooltipEvent event) {
            TooltipEvent.HazardSystemTooltips(event);
        }
    }



    @Mod.EventBusSubscriber(modid = Radiated.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents{

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
            RegisterGuiOverlaysEventHandler.init(event);
        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            RegisterParticleFactoriesEventHandler.init(event);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            FMLClientSetupEventHandler.init(event);
        }
    }
}
