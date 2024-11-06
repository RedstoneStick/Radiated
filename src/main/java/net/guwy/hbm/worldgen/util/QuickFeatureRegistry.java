package net.guwy.hbm.worldgen.util;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.worldgen.ModOrePlacement;
import net.guwy.hbm.worldgen.ore.overworld.OGOverworldOreGen;
import net.guwy.hbm.worldgen.ore.overworld.OverworldCommonOreGen;
import net.guwy.hbm.worldgen.ore.overworld.OverworldRareOreGen;
import net.guwy.hbm.worldgen.ore.overworld.OverworldSpecialOreGen;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Crudely simplifies the registry of ore generation while keeping most of the customizability
 */
public class QuickFeatureRegistry {

    private static void init() {
        /*
        An init calling another init. Now you could call that oresInit.
        Now that's sum bullshit right there.
        Lorem ipsum dolor sit amet, NO!
        Hi!
         */
        // OGOverworldOreGen.init();
        OverworldCommonOreGen.init();
        OverworldRareOreGen.init();
        OverworldSpecialOreGen.init();
    }



    private static List<String> nameList = new ArrayList<>();
    private static HashMap<String, ConfiguredFeature<?, ?>> configuredFeatureMap = new HashMap<>();
    private static HashMap<String, List<PlacementModifier>> placementModifiersMap = new HashMap<>();
    private static HashMap<String, TagKey<Biome>> bioeTagMap = new HashMap<>();


    public static void register(String name, ConfiguredFeature<?, ?> configuredFeature, List<PlacementModifier> placementModifiers, TagKey<Biome> biomeTag) {
        nameList.add(name);
        configuredFeatureMap.put(name, configuredFeature);
        placementModifiersMap.put(name, placementModifiers);
        bioeTagMap.put(name, biomeTag);
    }
    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(String name, F feature, FC featureConfiguration, List<PlacementModifier> placementModifiers, TagKey<Biome> biomeTag) {
        register(name, new ConfiguredFeature<>(feature, featureConfiguration), placementModifiers, biomeTag);
    }


    public static void registerOre(String name, OreConfiguration oreConfiguration, List<PlacementModifier> placementModifiers, TagKey<Biome> biomeTag) {
        register(name, Feature.ORE, oreConfiguration, placementModifiers, biomeTag);
    }
    public static void registerCommonOre(String name,
                                 int veinCount, HeightRangePlacement heightRangePlacement,
                                 int veinSize, float discardChanceOnAirExposure,
                                 List<OreConfiguration.TargetBlockState> configuration,
                                 TagKey<Biome> biomeTag) {
        registerOre(
                name,
                new OreConfiguration(
                        configuration,
                        veinSize,
                        discardChanceOnAirExposure
                ),
                ModOrePlacement.commonOrePlacement(veinCount, heightRangePlacement),
                biomeTag
        );
    }
    public static void registerRareOre(String name,
                                          int onceEvery, HeightRangePlacement heightRangePlacement,
                                          int veinSize, float discardChanceOnAirExposure,
                                          List<OreConfiguration.TargetBlockState> configuration,
                                          TagKey<Biome> biomeTag) {
        registerOre(
                name,
                new OreConfiguration(
                        configuration,
                        veinSize,
                        discardChanceOnAirExposure
                ),
                ModOrePlacement.rareOrePlacement(onceEvery, heightRangePlacement),
                biomeTag
        );
    }



    public class Getters {
        public static List<String> getNameList() {
            if (nameList.isEmpty()) init();
            return nameList;
        }

        public static ResourceKey<ConfiguredFeature<?, ?>> getConfigurationKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, name));
        }
        public static ConfiguredFeature<?, ?> getConfiguredFeature(String name) {
            return configuredFeatureMap.get(name);
        }

        public static ResourceKey<PlacedFeature> getPlacementKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, name));
        }
        public static List<PlacementModifier> getPlacementModifiers(String name) {
            return placementModifiersMap.get(name);
        }

        public static ResourceKey<BiomeModifier> getBiomeModifierKey(String name) {
            return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, name));
        }
        public static TagKey<Biome> getBiomeTag(String name) {
            return bioeTagMap.get(name);
        }
    }
}
