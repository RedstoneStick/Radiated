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
        registerRare("ore_oil", 128, 64, 32, 32, NTMOresNBlocks.ORE_OIL.get());

        register("ore_uranium", 6, 5, 5, 20, NTMOresNBlocks.ORE_URANIUM.get());
        register("ore_thorium", 7, 5, 5, 25, NTMOresNBlocks.ORE_THORIUM.get());
        register("ore_titanium", 8, 6, 5, 30, NTMOresNBlocks.ORE_TITANIUM.get());
        register("ore_sulfur", 5, 8, 5, 30, NTMOresNBlocks.ORE_SULFUR.get());
        register("ore_niter", 6, 6, 5, 30, NTMOresNBlocks.ORE_NITER.get());
        register("ore_tungsten", 10, 8, 5, 30, NTMOresNBlocks.ORE_TUNGSTEN.get());
        register("ore_aluminium", 7, 6, 5, 40, NTMOresNBlocks.ORE_ALUMINIUM.get());
        register("ore_fluorite", 6, 4, 5, 45, NTMOresNBlocks.ORE_FLUORITE.get());
        register("ore_beryllium", 6, 4, 5, 30, NTMOresNBlocks.ORE_BERYLLIUM.get());
        register("ore_lead", 6, 9, 5, 30, NTMOresNBlocks.ORE_LEAD.get());
        register("ore_lignite", 2, 24, 35, 25, NTMOresNBlocks.ORE_LIGNITE.get());
        register("ore_asbestos", 4, 4, 16, 16, NTMOresNBlocks.ORE_ASBESTOS.get());
        register("ore_rare", 6, 5, 5, 20, NTMOresNBlocks.ORE_RARE.get());
        register("ore_cobalt", 2, 4, 4, 8, NTMOresNBlocks.ORE_COBALT.get());
        register("ore_cinnebar", 1, 4, 8, 16, NTMOresNBlocks.ORE_CINNEBAR.get());

        register("cluster_iron", 4, 6, 15, 45, NTMOresNBlocks.CLUSTER_IRON.get());
        register("cluster_titanium", 2, 6, 15, 30, NTMOresNBlocks.CLUSTER_TITANIUM.get());
        register("cluster_aluminium", 3, 6, 15, 35, NTMOresNBlocks.CLUSTER_ALUMINIUM.get());
        register("cluster_copper", 4, 6, 15, 20, NTMOresNBlocks.CLUSTER_COPPER.get());


        // I could use a for loop, but why
        registerColtan("ore_coltan_1", 2, 4, 15, 25, NTMOresNBlocks.ORE_COLTAN.get(), 5, 750, 1500);
        registerColtan("ore_coltan_2", 2, 4, 15, 25, NTMOresNBlocks.ORE_COLTAN.get(), 5, 750/2, 1500);
        registerColtan("ore_coltan_3", 2, 4, 15, 25, NTMOresNBlocks.ORE_COLTAN.get(), 5, 750/3, 1500);
        registerColtan("ore_coltan_4", 2, 4, 15, 25, NTMOresNBlocks.ORE_COLTAN.get(), 5, 750/4, 1500);
        registerColtan("ore_coltan_5", 2, 4, 15, 25, NTMOresNBlocks.ORE_COLTAN.get(), 5, 750/5, 1500);

        registerAustralium("ore_australium", 2, 50, 15, 15, NTMOresNBlocks.ORE_AUSTRALIUM.get(), -450, -350, -450, -350);
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
