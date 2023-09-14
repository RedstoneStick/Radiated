package net.guwy.radiated.events;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.events.server.AttachCapabilitiesHandler;
import net.guwy.radiated.events.server.CapabilityCarryOverDeathHandler;
import net.guwy.radiated.events.server.PlayerTickEventOrganizer;
import net.guwy.radiated.events.server.RegisterCapabilitiesHandler;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

/** This one is called both on client and server */
public class ModServerEvents {
    @Mod.EventBusSubscriber(modid = Radiated.MOD_ID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            if(event.side == LogicalSide.SERVER) {
                if(event.phase == TickEvent.Phase.END){
                    PlayerTickEventOrganizer.init(event);
                }
            }
        }

        @SubscribeEvent
        public static void onAttachCapabilitiesEntity(AttachCapabilitiesEvent<Entity> event) {
            AttachCapabilitiesHandler.initEntity(event);
        }

        @SubscribeEvent
        public static void onPlayerCloned(PlayerEvent.Clone event) {
            CapabilityCarryOverDeathHandler.init(event);
        }

        @SubscribeEvent
        public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
            RegisterCapabilitiesHandler.init(event);
        }
    }

    @Mod.EventBusSubscriber(modid = Radiated.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
    }
}
