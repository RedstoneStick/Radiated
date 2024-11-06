package net.guwy.hbm.datagen.tags.block;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.HashMap;
import java.util.List;

public class OreTags {
    private static void addTags() {
        register("uranium", NTMOresNBlocks.ORE_URANIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_URANIUM.get());
        register("thorium", NTMOresNBlocks.ORE_THORIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_THORIUM.get());
        register("titanium", NTMOresNBlocks.ORE_TITANIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_TITANIUM.get());
        register("sulfur", NTMOresNBlocks.ORE_SULFUR.get(), NTMOresNBlocks.DEEPSLATE_ORE_SULFUR.get());
        register("niter", NTMOresNBlocks.ORE_NITER.get(), NTMOresNBlocks.DEEPSLATE_ORE_NITER.get());
        register("tungsten", NTMOresNBlocks.ORE_TUNGSTEN.get(), NTMOresNBlocks.DEEPSLATE_ORE_TUNGSTEN.get());
        register("aluminium", NTMOresNBlocks.ORE_ALUMINIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_ALUMINIUM.get());
        register("fluorite", NTMOresNBlocks.ORE_FLUORITE.get(), NTMOresNBlocks.DEEPSLATE_ORE_FLUORITE.get());
        register("beryllium", NTMOresNBlocks.ORE_BERYLLIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_BERYLLIUM.get());
        register("lead", NTMOresNBlocks.ORE_LEAD.get(), NTMOresNBlocks.DEEPSLATE_ORE_LEAD.get());
        register("oil", NTMOresNBlocks.ORE_OIL.get(), NTMOresNBlocks.DEEPSLATE_ORE_OIL.get());
        register("lignite", NTMOresNBlocks.ORE_LIGNITE.get(), NTMOresNBlocks.DEEPSLATE_ORE_LIGNITE.get());
        register("asbestos", NTMOresNBlocks.ORE_ASBESTOS.get(), NTMOresNBlocks.DEEPSLATE_ORE_ASBESTOS.get());
        register("australium", NTMOresNBlocks.ORE_AUSTRALIUM.get(), NTMOresNBlocks.DEEPSLATE_ORE_AUSTRALIUM.get());
        register("rare_earth", NTMOresNBlocks.ORE_RARE.get(), NTMOresNBlocks.DEEPSLATE_ORE_RARE.get());
        register("cobalt", NTMOresNBlocks.ORE_COBALT.get(), NTMOresNBlocks.DEEPSLATE_ORE_COBALT.get());
        register("cinnabar", NTMOresNBlocks.ORE_CINNEBAR.get(), NTMOresNBlocks.DEEPSLATE_ORE_CINNEBAR.get());
        register("coltan", NTMOresNBlocks.ORE_COLTAN.get(), NTMOresNBlocks.DEEPSLATE_ORE_COLTAN.get());
    }


    private static HashMap<List<TagKey<Block>>, Block[]> blockTags = new HashMap<>();

    private static void register(TagKey<Block> tagKey, Block... block) {
        blockTags.put(List.of(tagKey, TagKey.create(Registries.BLOCK, ResourceLocation.parse("c:ores"))), block);
    }
    private static void register(String tagKey, Block... block) {
        register(TagKey.create(Registries.BLOCK, ResourceLocation.parse("c:ores/" + tagKey)), block);
    }

    public static HashMap<List<TagKey<Block>>, Block[]> getMap() {
        addTags();
        return blockTags;
    }
}
