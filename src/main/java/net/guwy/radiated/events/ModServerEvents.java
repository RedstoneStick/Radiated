package net.guwy.radiated.events;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.blocks.machines.rtg.RTGScreen;
import net.guwy.radiated.content.blocks.machines.turbine.TurbineScreen;
import net.guwy.radiated.content.particles.VomitParticle;
import net.guwy.radiated.events.server.AttachCapabilitiesHandler;
import net.guwy.radiated.events.server.CapabilityCarryOverDeathHandler;
import net.guwy.radiated.events.server.PlayerTickEventOrganizer;
import net.guwy.radiated.events.server.RegisterCapabilitiesHandler;
import net.guwy.radiated.events.server.player.PlayerInteractRightClickEmptyHandler;
import net.guwy.radiated.index.NTMParticles;
import net.guwy.radiated.index.RDTFluids;
import net.guwy.radiated.index.RDTMenuTypes;
import net.guwy.radiated.mechanics.gasmask.IVisorItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegisterEvent;

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
