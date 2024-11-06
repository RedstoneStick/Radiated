package net.guwy.hbm.worldgen.ore.overworld;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.worldgen.util.QuickFeatureRegistry;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class OverworldRareOreGen {
    public static void init() {

        registerUniform("ore_oil", 128, 64, 32, 64, NTMOresNBlocks.ORE_OIL.get(), NTMOresNBlocks.DEEPSLATE_ORE_OIL.get());
    }

    public static void registerUniform(String name, int onceEvery, int veinSize, int minHeight, int maxHeight,
                                       Block stoneBlock, Block deeplslateBlock, float discardChanceOnAirExposure, TagKey<Biome> tagKey) {
        QuickFeatureRegistry.registerRareOre(name,
                onceEvery, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)),
                veinSize, discardChanceOnAirExposure,
                List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), stoneBlock.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), deeplslateBlock.defaultBlockState())),
                tagKey);
    }
    public static void registerUniform(String name, int onceEvery, int veinSize, int minHeight, int maxHeight,
                                       Block stoneBlock, Block deeplslateBlock, float discardChanceOnAirExposure) {
        registerUniform(name, onceEvery, veinSize, minHeight, maxHeight, stoneBlock, deeplslateBlock, discardChanceOnAirExposure, BiomeTags.IS_OVERWORLD);
    }
    public static void registerUniform(String name, int onceEvery, int veinSize, int minHeight, int maxHeight,
                                       Block stoneBlock, Block deeplslateBlock) {
        registerUniform(name, onceEvery, veinSize, minHeight, maxHeight, stoneBlock, deeplslateBlock, 0, BiomeTags.IS_OVERWORLD);
    }

    public static void registerTriangle(String name, int onceEvery, int veinSize, int minHeight, int maxHeight,
                                        Block stoneBlock, Block deeplslateBlock, float discardChanceOnAirExposure, TagKey<Biome> tagKey) {
        QuickFeatureRegistry.registerRareOre(name,
                onceEvery, HeightRangePlacement.triangle(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)),
                veinSize, discardChanceOnAirExposure,
                List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), stoneBlock.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), deeplslateBlock.defaultBlockState())),
                tagKey);
    }
    public static void registerTriangle(String name, int onceEvery, int veinSize, int minHeight, int maxHeight,
                                        Block stoneBlock, Block deepslateBlock, float discardChanceOnAirExposure) {
        registerTriangle(name, onceEvery, veinSize, minHeight, maxHeight, stoneBlock, deepslateBlock, discardChanceOnAirExposure, BiomeTags.IS_OVERWORLD);
    }
    public static void registerTriangle(String name, int onceEvery, int veinSize, int minHeight, int maxHeight,
                                        Block stoneBlock, Block deepslateBlock) {
        registerTriangle(name, onceEvery, veinSize, minHeight, maxHeight, stoneBlock, deepslateBlock, 0, BiomeTags.IS_OVERWORLD);
    }
}
