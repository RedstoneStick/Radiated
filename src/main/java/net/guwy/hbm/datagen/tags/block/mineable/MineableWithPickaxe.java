package net.guwy.hbm.datagen.tags.block.mineable;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

public class MineableWithPickaxe {
    private static void addTags() {
        register(NTMOresNBlocks.ORE_URANIUM);
        register(NTMOresNBlocks.ORE_THORIUM);
        register(NTMOresNBlocks.ORE_TITANIUM);
        register(NTMOresNBlocks.ORE_SULFUR);
        register(NTMOresNBlocks.ORE_NITER);
        register(NTMOresNBlocks.ORE_TUNGSTEN);
        register(NTMOresNBlocks.ORE_ALUMINIUM);
        register(NTMOresNBlocks.ORE_FLUORITE);
        register(NTMOresNBlocks.ORE_BERYLLIUM);
        register(NTMOresNBlocks.ORE_LEAD);
        register(NTMOresNBlocks.ORE_OIL);
        register(NTMOresNBlocks.ORE_LIGNITE);
        register(NTMOresNBlocks.ORE_ASBESTOS);
        register(NTMOresNBlocks.ORE_AUSTRALIUM);
        register(NTMOresNBlocks.ORE_RARE);
        register(NTMOresNBlocks.ORE_COBALT);
        register(NTMOresNBlocks.ORE_CINNEBAR);
        register(NTMOresNBlocks.ORE_COLTAN);
        register(NTMOresNBlocks.CLUSTER_IRON);
        register(NTMOresNBlocks.CLUSTER_TITANIUM);
        register(NTMOresNBlocks.CLUSTER_ALUMINIUM);
        register(NTMOresNBlocks.CLUSTER_COPPER);
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
