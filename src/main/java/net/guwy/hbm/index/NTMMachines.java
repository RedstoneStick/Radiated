package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.blocks.machines.brick_furnace.BrickFurnaceEntityBlock;
import net.guwy.hbm.items.misc.BasicTooltipBlockItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NTMMachines {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NTMMain.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NTMMain.MODID);



    // Simple Functional Blocks //



    // Storage Blocks //



    // Anvils //



    // Press //



    // Furnaces //
    public static final DeferredBlock<Block> BRICK_FURNACE = registerBlock("brick_furnace",
            () -> new BrickFurnaceEntityBlock(BlockBehaviour.Properties.of().strength(5f, 10f).mapColor(MapColor.COLOR_RED)));



    // Heat (TU) Machines //



    // Basic Electric Machines //



    // Oil Machines //



    // Nuclear Machines //



    // Generators //



    // Power Transmission //



    // Power Storage //



    // Fluid Transmission //



    // Fluid Storage //



    // Misc



    /**
     * Registers a block with a basic block item
     */
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, new Item.Properties());
        return toReturn;
    }
    /// Registers a block with custom block item properties
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Item.Properties itemProperties) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemProperties);
        return toReturn;
    }
    /// Registers a block, with custom block item properties and tooltip
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Item.Properties itemProperties, Component... tooltip) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemProperties, tooltip);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Item.Properties itemProperties) {
        ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Item.Properties itemProperties, Component... tooltip) {
        ITEMS.register(name, () -> new BasicTooltipBlockItem(block.get(), itemProperties, tooltip));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
