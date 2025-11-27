package net.guwy.hbm.datagen.loot_tables;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.guwy.hbm.index.NTMResourcesNParts;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

public class  OreBlockLootTableRegistry {

    public static void init() {
        register(NTMOresNBlocks.ORE_URANIUM.get(), NTMResourcesNParts.RAW_URANIUM.get());
        register(NTMOresNBlocks.ORE_THORIUM.get(), NTMResourcesNParts.RAW_THORIUM.get());
        register(NTMOresNBlocks.ORE_TITANIUM.get(), NTMResourcesNParts.RAW_TITANIUM.get());
        register(NTMOresNBlocks.ORE_TUNGSTEN.get(), NTMResourcesNParts.RAW_TUNGSTEN.get());
        register(NTMOresNBlocks.ORE_ALUMINIUM.get(), NTMResourcesNParts.RAW_ALUMINIUM.get());
        register(NTMOresNBlocks.ORE_BERYLLIUM.get(), NTMResourcesNParts.RAW_BERYLLIUM.get());
        register(NTMOresNBlocks.ORE_LEAD.get(), NTMResourcesNParts.RAW_LEAD.get());
        register(NTMOresNBlocks.ORE_AUSTRALIUM.get(), NTMResourcesNParts.RAW_AUSTRALIUM.get());
        register(NTMOresNBlocks.ORE_COBALT.get(), NTMResourcesNParts.RAW_COBALT.get());
        register(NTMOresNBlocks.ORE_COAL_OIL.get(), Items.COAL, 2, 4);
        register(NTMOresNBlocks.ORE_SULFUR.get(), NTMResourcesNParts.SULFUR.get(), 2, 5);
        register(NTMOresNBlocks.ORE_NITER.get(), NTMResourcesNParts.NITER.get(), 2, 5);
        register(NTMOresNBlocks.ORE_FLUORITE.get(), NTMResourcesNParts.FLUORITE.get(), 2, 5);
        register(NTMOresNBlocks.ORE_LIGNITE.get(), NTMResourcesNParts.LIGNITE.get());
        register(NTMOresNBlocks.ORE_ASBESTOS.get(), NTMResourcesNParts.INGOT_ASBESTOS.get());
        register(NTMOresNBlocks.ORE_RARE.get(), NTMResourcesNParts.CHUNK_ORE_RARE.get());
        register(NTMOresNBlocks.ORE_CINNEBAR.get(), NTMResourcesNParts.CINNEBAR.get());
        register(NTMOresNBlocks.ORE_COLTAN.get(), NTMResourcesNParts.FRAGMENT_COLTAN.get());

        register(NTMOresNBlocks.DEEPSLATE_ORE_URANIUM.get(), NTMResourcesNParts.RAW_URANIUM.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_THORIUM.get(), NTMResourcesNParts.RAW_THORIUM.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_TITANIUM.get(), NTMResourcesNParts.RAW_TITANIUM.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_TUNGSTEN.get(), NTMResourcesNParts.RAW_TUNGSTEN.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_ALUMINIUM.get(), NTMResourcesNParts.RAW_ALUMINIUM.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_BERYLLIUM.get(), NTMResourcesNParts.RAW_BERYLLIUM.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_LEAD.get(), NTMResourcesNParts.RAW_LEAD.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_AUSTRALIUM.get(), NTMResourcesNParts.RAW_AUSTRALIUM.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_COBALT.get(), NTMResourcesNParts.RAW_COBALT.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_COAL_OIL.get(), Items.COAL, 2, 4);
        register(NTMOresNBlocks.DEEPSLATE_ORE_SULFUR.get(), NTMResourcesNParts.SULFUR.get(), 2, 5);
        register(NTMOresNBlocks.DEEPSLATE_ORE_NITER.get(), NTMResourcesNParts.NITER.get(), 2, 5);
        register(NTMOresNBlocks.DEEPSLATE_ORE_FLUORITE.get(), NTMResourcesNParts.FLUORITE.get(), 2, 5);
        register(NTMOresNBlocks.DEEPSLATE_ORE_LIGNITE.get(), NTMResourcesNParts.LIGNITE.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_ASBESTOS.get(), NTMResourcesNParts.INGOT_ASBESTOS.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_RARE.get(), NTMResourcesNParts.CHUNK_ORE_RARE.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_CINNEBAR.get(), NTMResourcesNParts.CINNEBAR.get());
        register(NTMOresNBlocks.DEEPSLATE_ORE_COLTAN.get(), NTMResourcesNParts.FRAGMENT_COLTAN.get());
    }

    public static HashMap<Block, Item> oreBlockToItemMap = new HashMap<>();

    public static HashMap<Block, Item> oreBlockToMultiItemMap = new HashMap<>();
    public static HashMap<Block, Integer> oreBlockToMultiItemMinMap = new HashMap<>();
    public static HashMap<Block, Integer> oreBlockToMultiItemMaxMap = new HashMap<>();

    /**
     * Registers a Ore Block that'll drop the defined item when mined.
     * Affected by silk touch and fortune
     * @param block The block that'll drop the item
     * @param item The item that'll drop
     */
    private static void register(Block block, Item item) {
        oreBlockToItemMap.put(block, item);
    }
    /**
     * Registers a Ore Block that'll drop a configurable amount of the defined item when mined.
     * Affected by silk touch and fortune
     * @param block The block that'll drop the item
     * @param item The item that'll drop
     */
    private static void register(Block block, Item item, int minDrops, int maxDrops) {
        oreBlockToMultiItemMap.put(block, item);
        oreBlockToMultiItemMinMap.put(block, minDrops);
        oreBlockToMultiItemMaxMap.put(block, maxDrops);
    }
}
