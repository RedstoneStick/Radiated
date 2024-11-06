package net.guwy.hbm.worldgen.ore.overworld;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMWorldFeatures;
import net.guwy.hbm.worldgen.ModOrePlacement;
import net.guwy.hbm.worldgen.features.WithinAreaOreConfiguration;
import net.guwy.hbm.worldgen.features.WithinSeededRandomAreaOreConfiguration;
import net.guwy.hbm.worldgen.util.QuickFeatureRegistry;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class OverworldSpecialOreGen {
    public static void init() {

        for (int i = 1; i <= 5; i++) {
            registerWithinRandomAreaUniform("ore_coltan_"+i, 2, 4, 15, 40, NTMOresNBlocks.ORE_COLTAN.get(), NTMOresNBlocks.DEEPSLATE_ORE_COLTAN.get(), 5, 750/i, 1500);
        }

        registerWithinAreaUniform("ore_australium", 2, 50, 15, 30, NTMOresNBlocks.ORE_AUSTRALIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_AUSTRALIUM.get(), -450, -350, -450, -350);
    }

    public static void registerWithinAreaUniform(String name,
                                                 int veinCount, int veinSize,
                                                 int minHeight, int maxHeight,
                                                 Block stoneBlock, Block deepslateBlock,
                                                 int minX, int maxX, int minZ, int maxZ) {
        QuickFeatureRegistry.register(
                name,
                new ConfiguredFeature<>(
                        NTMWorldFeatures.WITHIN_AREA_ORE.get(),
                        new WithinAreaOreConfiguration(
                                List.of(WithinAreaOreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), stoneBlock.defaultBlockState()),
                                        WithinAreaOreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), deepslateBlock.defaultBlockState())),
                                veinSize,
                                0f,
                                minX,maxX,minZ,maxZ
                        )
                ),
                ModOrePlacement.commonOrePlacement(veinCount,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))),
                BiomeTags.IS_OVERWORLD
        );
    }

    public static void registerWithinRandomAreaUniform(String name,
                                                       int veinCount, int veinSize,
                                                       int minHeight, int maxHeight,
                                                       Block stoneBlock, Block deepslateBlock,
                                                       int seed_offset, int range, int maxDistFromSpawn) {
        QuickFeatureRegistry.register(
                name,
                new ConfiguredFeature<>(
                        NTMWorldFeatures.WITHIN_SEEDED_RANDOM_AREA_ORE.get(),
                        new WithinSeededRandomAreaOreConfiguration(
                                List.of(WithinSeededRandomAreaOreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), stoneBlock.defaultBlockState()),
                                        WithinSeededRandomAreaOreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), deepslateBlock.defaultBlockState())),
                                veinSize,
                                0f,
                                seed_offset,range,maxDistFromSpawn
                        )
                ),
                ModOrePlacement.commonOrePlacement(veinCount,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))),
                BiomeTags.IS_OVERWORLD
        );
    }
}
