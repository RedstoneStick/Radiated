package net.guwy.hbm.datagen.loot_tables;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

public class OreBlockLootTableRegistry {

    public static void init() {
        //register(NTMOresNBlocks.ORE_URANIUM.get(), NTMOresNBlocks.ORE_URANIUM.asItem());
        //register(NTMOresNBlocks.ORE_URANIUM.get(), NTMOresNBlocks.ORE_URANIUM.asItem(), 1, 10);
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
