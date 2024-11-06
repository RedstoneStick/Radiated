package net.guwy.hbm.worldgen.ore.overworld;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMWorldFeatures;
import net.guwy.hbm.worldgen.features.WithinAreaOreConfiguration;
import net.guwy.hbm.worldgen.ModOrePlacement;
import net.guwy.hbm.worldgen.features.WithinSeededRandomAreaOreConfiguration;
import net.guwy.hbm.worldgen.util.QuickFeatureRegistry;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class OGOverworldOreGen {
    public static void init() {
        registerRare("og_ore_oil", 128, 64, 32, 32, NTMOresNBlocks.ORE_OIL.get());

        register("og_ore_uranium", 6, 5, 5, 20, NTMOresNBlocks.ORE_URANIUM.get());
        register("og_ore_thorium", 7, 5, 5, 25, NTMOresNBlocks.ORE_THORIUM.get());
        register("og_ore_titanium", 8, 6, 5, 30, NTMOresNBlocks.ORE_TITANIUM.get());
        register("og_ore_sulfur", 5, 8, 5, 30, NTMOresNBlocks.ORE_SULFUR.get());
        register("og_ore_niter", 6, 6, 5, 30, NTMOresNBlocks.ORE_NITER.get());
        register("og_ore_tungsten", 10, 8, 5, 30, NTMOresNBlocks.ORE_TUNGSTEN.get());
        register("og_ore_aluminium", 7, 6, 5, 40, NTMOresNBlocks.ORE_ALUMINIUM.get());
        register("og_ore_fluorite", 6, 4, 5, 45, NTMOresNBlocks.ORE_FLUORITE.get());
        register("og_ore_beryllium", 6, 4, 5, 30, NTMOresNBlocks.ORE_BERYLLIUM.get());
        register("og_ore_lead", 6, 9, 5, 30, NTMOresNBlocks.ORE_LEAD.get());
        register("og_ore_lignite", 2, 24, 35, 25, NTMOresNBlocks.ORE_LIGNITE.get());
        register("og_ore_asbestos", 4, 4, 16, 16, NTMOresNBlocks.ORE_ASBESTOS.get());
        register("og_ore_rare", 6, 5, 5, 20, NTMOresNBlocks.ORE_RARE.get());
        register("og_ore_cobalt", 2, 4, 4, 8, NTMOresNBlocks.ORE_COBALT.get());
        register("og_ore_cinnebar", 1, 4, 8, 16, NTMOresNBlocks.ORE_CINNEBAR.get());

        register("og_cluster_iron", 4, 6, 15, 45, NTMOresNBlocks.CLUSTER_IRON.get());
        register("og_cluster_titanium", 2, 6, 15, 30, NTMOresNBlocks.CLUSTER_TITANIUM.get());
        register("og_cluster_aluminium", 3, 6, 15, 35, NTMOresNBlocks.CLUSTER_ALUMINIUM.get());
        register("og_cluster_copper", 4, 6, 15, 20, NTMOresNBlocks.CLUSTER_COPPER.get());


        for (int i = 1; i <= 5; i++) {
            registerColtan("og_ore_coltan_"+i, 2, 4, 15, 25, NTMOresNBlocks.ORE_COLTAN.get(), 5, 750/i, 1500);
        }

        registerAustralium("og_ore_australium", 2, 50, 15, 15, NTMOresNBlocks.ORE_AUSTRALIUM.get(), -450, -350, -450, -350);
    }



    public static void register(String name,
                                int veinCount, int veinSize,
                                int minHeight, int variance,
                                Block block) {
        QuickFeatureRegistry.registerCommonOre(name,
                veinCount, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(minHeight + variance)),
                veinSize, 0,
                List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), block.defaultBlockState())),
                BiomeTags.IS_OVERWORLD);
    }
    public static void registerRare(String name,
                                 int onceEvery, int veinSize,
                                 int minHeight, int variance,
                                 Block block) {
        QuickFeatureRegistry.registerRareOre(name,
                onceEvery, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(minHeight + variance)),
                veinSize, 0,
                List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), block.defaultBlockState())),
                BiomeTags.IS_OVERWORLD);
    }

    public static void registerAustralium(String name,
                                int veinCount, int veinSize,
                                int minHeight, int variance,
                                Block block, int minX, int maxX, int minZ, int maxZ) {
        QuickFeatureRegistry.register(
                name,
                new ConfiguredFeature<>(
                        NTMWorldFeatures.WITHIN_AREA_ORE.get(),
                        new WithinAreaOreConfiguration(
                                List.of(WithinAreaOreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), block.defaultBlockState())),
                                veinSize,
                                0f,
                                minX,maxX,minZ,maxZ
                        )
                ),
                ModOrePlacement.commonOrePlacement(veinCount,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(minHeight + variance))),
                BiomeTags.IS_OVERWORLD
        );
    }

    public static void registerColtan(String name,
                                          int veinCount, int veinSize,
                                          int minHeight, int variance,
                                          Block block, int seed_offset, int range, int maxDistFromSpawn) {
        QuickFeatureRegistry.register(
                name,
                new ConfiguredFeature<>(
                        NTMWorldFeatures.WITHIN_SEEDED_RANDOM_AREA_ORE.get(),
                        new WithinSeededRandomAreaOreConfiguration(
                                List.of(WithinSeededRandomAreaOreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), block.defaultBlockState())),
                                veinSize,
                                0f,
                                seed_offset,range,maxDistFromSpawn
                        )
                ),
                ModOrePlacement.commonOrePlacement(veinCount,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(minHeight + variance))),
                BiomeTags.IS_OVERWORLD
        );
    }
}
