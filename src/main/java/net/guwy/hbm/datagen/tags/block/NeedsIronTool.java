package net.guwy.hbm.datagen.tags.block;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

public class NeedsIronTool {
    private static void addTags() {
        register(NTMOresNBlocks.ORE_TITANIUM);
        register(NTMOresNBlocks.ORE_LEAD);
        register(NTMOresNBlocks.ORE_RARE);
        register(NTMOresNBlocks.ORE_COBALT);
        register(NTMOresNBlocks.ORE_COLTAN);
        register(NTMOresNBlocks.CLUSTER_TITANIUM);
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
