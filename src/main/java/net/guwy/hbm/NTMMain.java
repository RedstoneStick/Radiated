package net.guwy.hbm;

import com.mojang.logging.LogUtils;
import net.guwy.hbm.index.NTMCreativeModTabs;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.guwy.hbm.index.NTMWorldFeatures;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(NTMMain.MODID)
public class NTMMain {
    public static final String MODID = "hbm";
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public NTMMain(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        NTMCreativeModTabs.register(modEventBus);

        NTMResourcesNParts.register(modEventBus);
        NTMOresNBlocks.register(modEventBus);

        NTMWorldFeatures.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(RegisterCreativeMenuContents::register);

        // Config registries
        //GeneralConfig.loadFromConfig(config);
        //WorldConfig.loadFromConfig(config);
        //MachineConfig.loadFromConfig(config);
        //BombConfig.loadFromConfig(config);
        //modContainer.registerConfig(ModConfig.Type.COMMON, RadiationConfigE.SPEC, "hbm-common.toml");
        //PotionConfig.loadFromConfig(config);
        //ToolConfig.loadFromConfig(config);
        //WeaponConfig.loadFromConfig(config);
        //MobConfig.loadFromConfig(config);
        //StructureConfig.loadFromConfig(config);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
