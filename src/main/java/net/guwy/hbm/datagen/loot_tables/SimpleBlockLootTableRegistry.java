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
        register(NTMOresNBlocks.ORE_URANIUM.get());
        register(NTMOresNBlocks.ORE_THORIUM.get());
        register(NTMOresNBlocks.ORE_TITANIUM.get());
        register(NTMOresNBlocks.ORE_SULFUR.get());
        register(NTMOresNBlocks.ORE_NITER.get());
        register(NTMOresNBlocks.ORE_TUNGSTEN.get());
        register(NTMOresNBlocks.ORE_ALUMINIUM.get());
        register(NTMOresNBlocks.ORE_FLUORITE.get());
        register(NTMOresNBlocks.ORE_BERYLLIUM.get());
        register(NTMOresNBlocks.ORE_LEAD.get());
        register(NTMOresNBlocks.ORE_OIL.get(), Blocks.COBBLESTONE.asItem(), true);
        register(NTMOresNBlocks.ORE_LIGNITE.get());
        register(NTMOresNBlocks.ORE_ASBESTOS.get());
        register(NTMOresNBlocks.ORE_AUSTRALIUM.get());
        register(NTMOresNBlocks.ORE_RARE.get());
        register(NTMOresNBlocks.ORE_COBALT.get());
        register(NTMOresNBlocks.ORE_CINNEBAR.get());
        register(NTMOresNBlocks.ORE_COLTAN.get());
        register(NTMOresNBlocks.CLUSTER_IRON.get());
        register(NTMOresNBlocks.CLUSTER_TITANIUM.get());
        register(NTMOresNBlocks.CLUSTER_ALUMINIUM.get());
        register(NTMOresNBlocks.CLUSTER_COPPER.get());
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
