package net.guwy.hbm.datagen.tags.block.mineable;

import net.guwy.hbm.index.NTMMachines;
import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

public class MineableWithPickaxeTags {
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
        register(NTMOresNBlocks.ORE_COAL_OIL);
        register(NTMOresNBlocks.ORE_COAL_OIL_BURNING);

        register(NTMOresNBlocks.DEEPSLATE_ORE_URANIUM);
        register(NTMOresNBlocks.DEEPSLATE_ORE_THORIUM);
        register(NTMOresNBlocks.DEEPSLATE_ORE_TITANIUM);
        register(NTMOresNBlocks.DEEPSLATE_ORE_SULFUR);
        register(NTMOresNBlocks.DEEPSLATE_ORE_NITER);
        register(NTMOresNBlocks.DEEPSLATE_ORE_TUNGSTEN);
        register(NTMOresNBlocks.DEEPSLATE_ORE_ALUMINIUM);
        register(NTMOresNBlocks.DEEPSLATE_ORE_FLUORITE);
        register(NTMOresNBlocks.DEEPSLATE_ORE_BERYLLIUM);
        register(NTMOresNBlocks.DEEPSLATE_ORE_LEAD);
        register(NTMOresNBlocks.DEEPSLATE_ORE_OIL);
        register(NTMOresNBlocks.DEEPSLATE_ORE_LIGNITE);
        register(NTMOresNBlocks.DEEPSLATE_ORE_ASBESTOS);
        register(NTMOresNBlocks.DEEPSLATE_ORE_AUSTRALIUM);
        register(NTMOresNBlocks.DEEPSLATE_ORE_RARE);
        register(NTMOresNBlocks.DEEPSLATE_ORE_COBALT);
        register(NTMOresNBlocks.DEEPSLATE_ORE_CINNEBAR);
        register(NTMOresNBlocks.DEEPSLATE_ORE_COLTAN);
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_IRON);
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_TITANIUM);
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_ALUMINIUM);
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_COPPER);
        register(NTMOresNBlocks.DEEPSLATE_ORE_COAL_OIL);
        register(NTMOresNBlocks.DEEPSLATE_ORE_COAL_OIL_BURNING);

        register(NTMOresNBlocks.BLOCK_RAW_URANIUM);
        register(NTMOresNBlocks.BLOCK_RAW_THORIUM);
        register(NTMOresNBlocks.BLOCK_RAW_TITANIUM);
        register(NTMOresNBlocks.BLOCK_RAW_TUNGSTEN);
        register(NTMOresNBlocks.BLOCK_RAW_ALUMINIUM);
        register(NTMOresNBlocks.BLOCK_RAW_BERYLLIUM);
        register(NTMOresNBlocks.BLOCK_RAW_LEAD);
        register(NTMOresNBlocks.BLOCK_RAW_AUSTRALIUM);
        register(NTMOresNBlocks.BLOCK_RAW_COBALT);

        register(NTMOresNBlocks.BLOCK_SULFUR);
        register(NTMOresNBlocks.BLOCK_NITER);
        register(NTMOresNBlocks.BLOCK_FLUORITE);
        register(NTMOresNBlocks.BLOCK_COLTAN);
        register(NTMOresNBlocks.BLOCK_TITANIUM);
        register(NTMOresNBlocks.BLOCK_STEEL);
        register(NTMOresNBlocks.BLOCK_COBALT);

        register(NTMMachines.BRICK_FURNACE);
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
