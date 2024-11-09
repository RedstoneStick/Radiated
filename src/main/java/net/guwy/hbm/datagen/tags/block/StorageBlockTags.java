package net.guwy.hbm.datagen.tags.block;

import net.guwy.hbm.index.ModTags;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.HashMap;
import java.util.List;

public class StorageBlockTags {
    private static void addTags() {
        register("raw_uranium", NTMOresNBlocks.BLOCK_RAW_URANIUM.get());
        register("raw_thorium", NTMOresNBlocks.BLOCK_RAW_THORIUM.get());
        register("raw_titanium", NTMOresNBlocks.BLOCK_RAW_TITANIUM.get());
        register("raw_tungsten", NTMOresNBlocks.BLOCK_RAW_TUNGSTEN.get());
        register("raw_aluminium", NTMOresNBlocks.BLOCK_RAW_ALUMINIUM.get());
        register("raw_beryllium", NTMOresNBlocks.BLOCK_RAW_BERYLLIUM.get());
        register("raw_lead", NTMOresNBlocks.BLOCK_RAW_LEAD.get());
        register("raw_australium", NTMOresNBlocks.BLOCK_RAW_AUSTRALIUM.get());
        register("raw_cobalt", NTMOresNBlocks.BLOCK_RAW_COBALT.get());
    }


    private static HashMap<List<TagKey<Block>>, Block[]> blockTags = new HashMap<>();

    private static void register(TagKey<Block> tagKey, Block... block) {
        blockTags.put(List.of(tagKey, ModTags.Blocks.STORAGE_BLOCKS), block);
    }
    private static void register(String tagKey, Block... block) {
        register(TagKey.create(Registries.BLOCK, ResourceLocation.parse("c:storage_blocks/" + tagKey)), block);
    }

    public static HashMap<List<TagKey<Block>>, Block[]> getMap() {
        addTags();
        return blockTags;
    }
}
