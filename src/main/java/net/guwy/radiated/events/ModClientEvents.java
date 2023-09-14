package net.guwy.radiated.events;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.events.client.FMLClientSetupEventHandler;
import net.guwy.radiated.events.client.RegisterGuiOverlaysEventHandler;
import net.guwy.radiated.events.client.RegisterParticleFactoriesEventHandler;
import net.guwy.radiated.events.client.TooltipEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
