package net.guwy.radiated.world.feature;

import net.guwy.radiated.Radiated;
import net.guwy.sticky_foundations.StickyFoundations;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Radiated.MOD_ID);



    public static final RegistryObject<PlacedFeature> BERYLLIUM_ORE_PLACED = PLACED_FEATURES.register("beryllium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BERYLLIUM_ORE.getHolder().get(),
                    commonOrePlacement(14, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-66), VerticalAnchor.absolute(40)))));



    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
