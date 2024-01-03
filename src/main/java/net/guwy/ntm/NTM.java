package net.guwy.ntm;

import com.mojang.logging.LogUtils;
import net.guwy.ntm.index.*;
import net.guwy.ntm.world.feature.ModConfiguredFeatures;
import net.guwy.ntm.world.feature.ModPlacedFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(NTM.MOD_ID)
public class NTM {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "ntm";

    // Is mod loaded variables
    private static boolean createLoaded = false;

    public NTM() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        NTMTools.register(eventBus);
        NTMMachines.register(eventBus);
        //RDTItems.register(eventBus);
        //RDTRTGPellets.register(eventBus);
        NTMArmors.register(eventBus);
        NTMResourcesAndParts.register(eventBus);

        NTMEffects.register(eventBus);
        NTMParticles.register(eventBus);
        NTMSounds.register(eventBus);

        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        NTMMenuTypes.register(eventBus);
        NTMBlockEntities.register(eventBus);

        NTMFluids.register(eventBus);
        NTMFluidTypes.register(eventBus);
        NTMFluidBlocknBuckets.register(eventBus);

        NTMRecipes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Is mod loaded checks
        createLoaded = ModList.get().isLoaded("create");
    }

    private void commonSetup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            NTMNetworking.register();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    // Is mod loaded returnals
    public static boolean isCreateLoaded()
    {
        return createLoaded;
    }
}
