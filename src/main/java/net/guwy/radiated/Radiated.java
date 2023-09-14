package net.guwy.radiated;

import com.mojang.logging.LogUtils;
import net.guwy.radiated.content.blocks.machines.rtg.RTGScreen;
import net.guwy.radiated.content.blocks.machines.turbine.TurbineScreen;
import net.guwy.radiated.index.*;
import net.guwy.radiated.world.feature.ModConfiguredFeatures;
import net.guwy.radiated.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Radiated.MOD_ID)
public class Radiated {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "radiated";

    public Radiated() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RDTTools.register(eventBus);
        RDTMachines.register(eventBus);
        //RDTItems.register(eventBus);
        //RDTRTGPellets.register(eventBus);
        RDTArmors.register(eventBus);
        NTMResourcesAndParts.register(eventBus);

        NTMEffects.register(eventBus);
        NTMParticles.register(eventBus);
        ModSounds.register(eventBus);

        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        RDTMenuTypes.register(eventBus);
        RDTBlockEntities.register(eventBus);

        RDTFluids.register(eventBus);
        RDTFluidTypes.register(eventBus);
        RDTFluidBlocknBuckets.register(eventBus);

        ModRecipes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ModNetworking.register();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
