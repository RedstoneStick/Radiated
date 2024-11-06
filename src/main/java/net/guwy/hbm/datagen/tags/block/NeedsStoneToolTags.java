package net.guwy.hbm.datagen.tags.block;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

public class NeedsStoneToolTags {
    private static void addTags() {
        register(NTMOresNBlocks.ORE_THORIUM);
        register(NTMOresNBlocks.ORE_ALUMINIUM);
        register(NTMOresNBlocks.ORE_BERYLLIUM);
        register(NTMOresNBlocks.CLUSTER_IRON);
        register(NTMOresNBlocks.CLUSTER_ALUMINIUM);
        register(NTMOresNBlocks.CLUSTER_COPPER);

        register(NTMOresNBlocks.DEEPSLATE_ORE_THORIUM);
        register(NTMOresNBlocks.DEEPSLATE_ORE_ALUMINIUM);
        register(NTMOresNBlocks.DEEPSLATE_ORE_BERYLLIUM);
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_IRON);
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_ALUMINIUM);
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_COPPER);

        register(NTMOresNBlocks.BLOCK_RAW_THORIUM);
        register(NTMOresNBlocks.BLOCK_RAW_ALUMINIUM);
        register(NTMOresNBlocks.BLOCK_RAW_BERYLLIUM);
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
