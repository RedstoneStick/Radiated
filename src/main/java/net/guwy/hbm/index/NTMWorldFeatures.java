package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.worldgen.features.WithinAreaOreConfiguration;
import net.guwy.hbm.worldgen.features.WithinAreaOreFeature;
import net.guwy.hbm.worldgen.features.WithinSeededRandomAreaOreConfiguration;
import net.guwy.hbm.worldgen.features.WithinSeededRandomAreaOreFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NTMWorldFeatures {
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(
            BuiltInRegistries.FEATURE, NTMMain.MODID);



    public static final DeferredHolder<Feature<?>, WithinAreaOreFeature> WITHIN_AREA_ORE =
            REGISTER.register("within_area_ore", () -> new WithinAreaOreFeature(WithinAreaOreConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, WithinSeededRandomAreaOreFeature> WITHIN_SEEDED_RANDOM_AREA_ORE =
            REGISTER.register("within_seeded_random_area_ore", () -> new WithinSeededRandomAreaOreFeature(WithinSeededRandomAreaOreConfiguration.CODEC));



    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
