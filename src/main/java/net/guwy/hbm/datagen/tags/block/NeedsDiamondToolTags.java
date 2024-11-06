package net.guwy.hbm.datagen.tags.block;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

public class NeedsDiamondToolTags {
    private static void addTags() {
        register(NTMOresNBlocks.ORE_URANIUM);
        register(NTMOresNBlocks.ORE_TUNGSTEN);
        register(NTMOresNBlocks.ORE_AUSTRALIUM);

        register(NTMOresNBlocks.DEEPSLATE_ORE_URANIUM);
        register(NTMOresNBlocks.DEEPSLATE_ORE_TUNGSTEN);
        register(NTMOresNBlocks.DEEPSLATE_ORE_AUSTRALIUM);

        register(NTMOresNBlocks.BLOCK_RAW_URANIUM);
        register(NTMOresNBlocks.BLOCK_RAW_TUNGSTEN);
        register(NTMOresNBlocks.BLOCK_RAW_AUSTRALIUM);
    }

    private static List<ResourceKey<Block>> list = new ArrayList<>();

    private static void register(DeferredBlock<Block> block) {
        list.add(block.getKey());
    }

    public static List<ResourceKey<Block>> getList() {
        addTags();
        return list;
    }
}
