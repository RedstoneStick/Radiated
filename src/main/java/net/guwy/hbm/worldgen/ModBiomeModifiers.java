package net.guwy.hbm.worldgen;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.worldgen.util.QuickFeatureRegistry;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    /*
    public static final ResourceKey<BiomeModifier> ADD_BLACK_OPAL_ORE = registerKey("add_black_opal_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_BLACK_OPAL_ORE = registerKey("add_nether_black_opal_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_BLACK_OPAL_ORE = registerKey("add_end_black_opal_ore");

    public static final ResourceKey<BiomeModifier> ADD_BLACK_OPAL_GEODE = registerKey("add_black_opal_geode");
     */


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        /*
        context.register(ADD_BLACK_OPAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLACK_OPAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_BLACK_OPAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_BLACK_OPAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_BLACK_OPAL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_BLACK_OPAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));


        context.register(ADD_BLACK_OPAL_GEODE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLACK_OPAL_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));
         */


        QuickFeatureRegistry.Getters.getNameList().forEach(name -> {
            context.register(QuickFeatureRegistry.Getters.getBiomeModifierKey(name),
                    new BiomeModifiers.AddFeaturesBiomeModifier(
                            biomes.getOrThrow(QuickFeatureRegistry.Getters.getBiomeTag(name)),
                            HolderSet.direct(placedFeatures.getOrThrow(QuickFeatureRegistry.Getters.getPlacementKey(name))),
                            GenerationStep.Decoration.UNDERGROUND_ORES
                    ));
        });
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, name));
    }
}
