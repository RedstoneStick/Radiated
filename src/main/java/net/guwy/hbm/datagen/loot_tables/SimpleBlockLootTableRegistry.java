package net.guwy.hbm.datagen.loot_tables;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleBlockLootTableRegistry {

    public static void init() {
        register(NTMOresNBlocks.ORE_OIL.get(), Blocks.COBBLESTONE.asItem(), true);
        register(NTMOresNBlocks.CLUSTER_IRON.get());
        register(NTMOresNBlocks.CLUSTER_TITANIUM.get());
        register(NTMOresNBlocks.CLUSTER_ALUMINIUM.get());
        register(NTMOresNBlocks.CLUSTER_COPPER.get());

        register(NTMOresNBlocks.DEEPSLATE_ORE_OIL.get(), Blocks.COBBLESTONE.asItem(), true);
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_IRON.get());
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_TITANIUM.get());
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_ALUMINIUM.get());
        register(NTMOresNBlocks.DEEPSLATE_CLUSTER_COPPER.get());

        register(NTMOresNBlocks.BLOCK_RAW_URANIUM.get());
        register(NTMOresNBlocks.BLOCK_RAW_THORIUM.get());
        register(NTMOresNBlocks.BLOCK_RAW_TITANIUM.get());
        register(NTMOresNBlocks.BLOCK_RAW_TUNGSTEN.get());
        register(NTMOresNBlocks.BLOCK_RAW_ALUMINIUM.get());
        register(NTMOresNBlocks.BLOCK_RAW_BERYLLIUM.get());
        register(NTMOresNBlocks.BLOCK_RAW_LEAD.get());
        register(NTMOresNBlocks.BLOCK_RAW_AUSTRALIUM.get());
        register(NTMOresNBlocks.BLOCK_RAW_COBALT.get());


        register(NTMOresNBlocks.BLOCK_SULFUR.get());
        register(NTMOresNBlocks.BLOCK_NITER.get());
        register(NTMOresNBlocks.BLOCK_FLUORITE.get());
        register(NTMOresNBlocks.BLOCK_COLTAN.get());
        register(NTMOresNBlocks.BLOCK_ASBESTOS.get());
        register(NTMOresNBlocks.BLOCK_TITANIUM.get());
        register(NTMOresNBlocks.BLOCK_STEEL.get());
        register(NTMOresNBlocks.BLOCK_COBALT.get());
    }

    public static List<Block> selfDroppingBlockList = new ArrayList<>();
    public static HashMap<Block, Item> itemDroppingBlockMap = new HashMap<>();
    public static HashMap<Block, Item> itemDroppingBlockNoSilkTouchMap = new HashMap<>();

    /**
     * Registers a Block that'll drop itself when mined
     * @param block The block that'll drop itself
     */
    private static void register(Block block) {
        selfDroppingBlockList.add(block);
    }

    /**
     * Registers a Block that'll drop a defined item when mined.
     * Affected by silk touch
     * @param block The block that'll drop itself
     */
    private static void register(Block block, Item item) {
        register(block, item, false);
    }
    /**
     * Registers a Block that'll drop a defined item when mined.
     * Can be made to bypass silk touch
     * @param block The block that'll drop itself
     * @param item Item that'll drop
     * @param ignoreSilkTouch If {@code  true} the item will drop even when the block is mined with silk touch. If {@code false} the mined block will drop as item instead
     */
    private static void register(Block block, Item item, boolean ignoreSilkTouch) {
        if(ignoreSilkTouch) itemDroppingBlockNoSilkTouchMap.put(block, item);
        else itemDroppingBlockMap.put(block, item);
    }
}
