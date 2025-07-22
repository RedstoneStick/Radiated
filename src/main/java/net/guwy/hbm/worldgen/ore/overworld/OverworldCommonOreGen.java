package net.guwy.hbm.worldgen.ore.overworld;

import net.guwy.hbm.index.ModTags;
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

public class OverworldCommonOreGen {
    public static void init() {
        // Ore densities are mostly the same as 1.7.10

        //Uranium (0.3 *y)
        registerTriangle("ore_uranium", 22, 5, -60, 10, NTMOresNBlocks.ORE_URANIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_URANIUM.get());
        registerUniform("ore_uranium_mountain", 13, 5, 5, 50, NTMOresNBlocks.ORE_URANIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_URANIUM.get(), 0, BiomeTags.IS_MOUNTAIN);

        //Thorium (0.28 *y)
        registerUniform("ore_thorium", 14, 5, -20, 30, NTMOresNBlocks.ORE_THORIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_THORIUM.get());
        registerTriangle("ore_thorium_mountain", 30, 3, 60, 200, NTMOresNBlocks.ORE_THORIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_THORIUM.get(), 0.8f, BiomeTags.IS_MOUNTAIN);

        //Titanium (0.27 *y)
        registerUniform("ore_titanium", 18, 6, -60, 35, NTMOresNBlocks.ORE_TITANIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_TITANIUM.get());
        registerTriangle("ore_titanium_weighted", 8, 6, -25, 35, NTMOresNBlocks.ORE_TITANIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_TITANIUM.get());

        //Sulfur (0.17 *y)
        registerUniform("ore_sulfur", 16, 8, -60, 35, NTMOresNBlocks.ORE_SULFUR.get(), NTMOresNBlocks.DEEPSLATE_ORE_SULFUR.get());
        registerUniform("ore_sulfur_badlands", 5, 8, 5, 35, NTMOresNBlocks.ORE_SULFUR.get(), NTMOresNBlocks.DEEPSLATE_ORE_SULFUR.get(), 0, BiomeTags.IS_BADLANDS);
        registerUniform("ore_sulfur_savanna", 5, 8, 5, 35, NTMOresNBlocks.ORE_SULFUR.get(), NTMOresNBlocks.DEEPSLATE_ORE_SULFUR.get(), 0, BiomeTags.IS_SAVANNA);

        //Niter (0.2 *y)
        registerUniform("ore_niter", 19, 6, -60, 35, NTMOresNBlocks.ORE_NITER.get(), NTMOresNBlocks.DEEPSLATE_ORE_NITER.get());
        registerUniform("ore_niter_badlands", 6, 6, 5, 35, NTMOresNBlocks.ORE_NITER.get(), NTMOresNBlocks.DEEPSLATE_ORE_NITER.get(), 0, BiomeTags.IS_BADLANDS);
        registerUniform("ore_niter_savanna", 6, 6, 5, 35, NTMOresNBlocks.ORE_NITER.get(), NTMOresNBlocks.DEEPSLATE_ORE_NITER.get(), 0, BiomeTags.IS_SAVANNA);

        //Tungsten (0.3 *y)
        registerUniform("ore_tungsten", 29, 8, -60, 35, NTMOresNBlocks.ORE_TUNGSTEN.get(), NTMOresNBlocks.DEEPSLATE_ORE_TUNGSTEN.get());

        //Aluminium (0.18 *y)
        registerUniform("ore_aluminium", 17, 6, -60, 45, NTMOresNBlocks.ORE_ALUMINIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_ALUMINIUM.get());

        //Fluorite (0.13 *y)
        //registerUniform("ore_fluorite", 7, 4, -60, 50, NTMOresNBlocks.ORE_FLUORITE.get(), NTMOresNBlocks.DEEPSLATE_ORE_FLUORITE.get());
        //registerTriangle("ore_fluorite_weighted", 7, 4, -30, 50, NTMOresNBlocks.ORE_FLUORITE.get(), NTMOresNBlocks.DEEPSLATE_ORE_FLUORITE.get());

        //Beryllium (0.2 *y)
        registerUniform("ore_beryllium", 13, 4, -60, 35, NTMOresNBlocks.ORE_BERYLLIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_BERYLLIUM.get());
        registerTriangle("ore_beryllium_weighted", 6, 4, -60, -15, NTMOresNBlocks.ORE_BERYLLIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_BERYLLIUM.get());

        //Lead (0.2 *y)
        registerUniform("ore_lead", 13, 9, -60, 35, NTMOresNBlocks.ORE_LEAD.get(), NTMOresNBlocks.DEEPSLATE_ORE_LEAD.get());
        registerTriangle("ore_lead_weighted", 6, 9, -10, 35, NTMOresNBlocks.ORE_LEAD.get(), NTMOresNBlocks.DEEPSLATE_ORE_LEAD.get());

        //Lignite (0.08 *y)
        registerUniform("ore_lignite", 2, 24, 35, 60, NTMOresNBlocks.ORE_LIGNITE.get(), NTMOresNBlocks.DEEPSLATE_ORE_LIGNITE.get());
        registerUniform("ore_lignite_high", 5, 24, 80, 160, NTMOresNBlocks.ORE_LIGNITE.get(), NTMOresNBlocks.DEEPSLATE_ORE_LIGNITE.get(), 0.7f);
        registerUniform("ore_lignite_swamp", 2, 24, 35, 60, NTMOresNBlocks.ORE_LIGNITE.get(), NTMOresNBlocks.DEEPSLATE_ORE_LIGNITE.get(), 0, ModTags.Biomes.IS_SWAMP);

        //Asbestos (0.25 *y)
        registerUniform("ore_asbestos", 4, 4, 16, 32, NTMOresNBlocks.ORE_ASBESTOS.get(), NTMOresNBlocks.DEEPSLATE_ORE_ASBESTOS.get());

        //Rare (0.3 *y)
        registerUniform("ore_rare", 9, 5, -5, 25, NTMOresNBlocks.ORE_RARE.get(), NTMOresNBlocks.DEEPSLATE_ORE_RARE.get());
        registerUniform("ore_rare_deep", 12, 5, -60, -20, NTMOresNBlocks.ORE_RARE.get(), NTMOresNBlocks.DEEPSLATE_ORE_RARE.get(), 0.4f);

        //Cobalt (0.25 *y)
        registerUniform("ore_cobalt", 4, 4, -4, 12, NTMOresNBlocks.ORE_COBALT.get(), NTMOresNBlocks.DEEPSLATE_ORE_COBALT.get());

        //Cinnabar (0.06 *y)
        registerUniform("ore_cinnebar", 1, 4, 8, 24, NTMOresNBlocks.ORE_CINNEBAR.get(), NTMOresNBlocks.DEEPSLATE_ORE_CINNEBAR.get());


        //registerUniform("cluster_iron", 4, 6, 15, 60, NTMOresNBlocks.CLUSTER_IRON.get(), NTMOresNBlocks.DEEPSLATE_CLUSTER_IRON.get());
        //registerUniform("cluster_titanium", 2, 6, 15, 45, NTMOresNBlocks.CLUSTER_TITANIUM.get(), NTMOresNBlocks.DEEPSLATE_CLUSTER_TITANIUM.get());
        //registerUniform("cluster_aluminium", 3, 6, 15, 50, NTMOresNBlocks.CLUSTER_ALUMINIUM.get(), NTMOresNBlocks.DEEPSLATE_CLUSTER_ALUMINIUM.get());
        //registerUniform("cluster_copper", 4, 6, 15, 35, NTMOresNBlocks.CLUSTER_COPPER.get(), NTMOresNBlocks.DEEPSLATE_CLUSTER_COPPER.get());
    }

    public static void registerUniform(String name, int veinCount, int veinSize, int minHeight, int maxHeight,
                                Block stoneBlock, Block deepslateBlock, float discardChanceOnAirExposure, TagKey<Biome> tagKey) {
        QuickFeatureRegistry.registerCommonOre(name,
                veinCount, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)),
                veinSize, discardChanceOnAirExposure,
                List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), stoneBlock.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), deepslateBlock.defaultBlockState())),
                tagKey);
    }
    public static void registerUniform(String name, int veinCount, int veinSize, int minHeight, int maxHeight,
                                       Block stoneBlock, Block deepslateBlock, float discardChanceOnAirExposure) {
        registerUniform(name, veinCount, veinSize, minHeight, maxHeight, stoneBlock, deepslateBlock, discardChanceOnAirExposure, BiomeTags.IS_OVERWORLD);
    }
    public static void registerUniform(String name, int veinCount, int veinSize, int minHeight, int maxHeight,
                                       Block stoneBlock, Block deeplslateBlock) {
        registerUniform(name, veinCount, veinSize, minHeight, maxHeight, stoneBlock, deeplslateBlock, 0, BiomeTags.IS_OVERWORLD);
    }

    public static void registerTriangle(String name, int veinCount, int veinSize, int minHeight, int maxHeight,
                                       Block stoneBlock, Block deepslateBlock, float discardChanceOnAirExposure, TagKey<Biome> tagKey) {
        QuickFeatureRegistry.registerCommonOre(name,
                veinCount, HeightRangePlacement.triangle(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)),
                veinSize, discardChanceOnAirExposure,
                List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), stoneBlock.defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), deepslateBlock.defaultBlockState())),
                tagKey);
    }
    public static void registerTriangle(String name, int veinCount, int veinSize, int minHeight, int maxHeight,
                                       Block stoneBlock, Block deepslateBlock, float discardChanceOnAirExposure) {
        registerTriangle(name, veinCount, veinSize, minHeight, maxHeight, stoneBlock, deepslateBlock, discardChanceOnAirExposure, BiomeTags.IS_OVERWORLD);
    }
    public static void registerTriangle(String name, int veinCount, int veinSize, int minHeight, int maxHeight,
                                       Block stoneBlock, Block deepslateBlock) {
        registerTriangle(name, veinCount, veinSize, minHeight, maxHeight, stoneBlock, deepslateBlock, 0, BiomeTags.IS_OVERWORLD);
    }
}
