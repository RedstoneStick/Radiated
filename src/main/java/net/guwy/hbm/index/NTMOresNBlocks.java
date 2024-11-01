package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.items.misc.BasicTooltipBlockItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NTMOresNBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NTMMain.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NTMMain.MODID);



    // ORES //
    public static final DeferredBlock<Block> ORE_URANIUM = registerBlock("ore_uranium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_THORIUM = registerBlock("ore_thorium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_TITANIUM= registerBlock("ore_titanium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_SULFUR= registerBlock("ore_sulfur",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );public static final DeferredBlock<Block> ORE_NITER= registerBlock("ore_niter",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    // Copper is omitted
    public static final DeferredBlock<Block> ORE_TUNGSTEN= registerBlock("ore_tungsten",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_ALUMINIUM= registerBlock("ore_aluminium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_FLUORITE= registerBlock("ore_fluorite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_BERYLLIUM= registerBlock("ore_beryllium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_LEAD= registerBlock("ore_lead",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_OIL= registerBlock("ore_oil",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)),
            Component.translatable("block.hbm.ore_oil.tooltip.1").withStyle(ChatFormatting.GRAY),
            Component.translatable("block.hbm.ore_oil.tooltip.2").withStyle(ChatFormatting.GRAY),
            Component.translatable("block.hbm.ore_oil.tooltip.3").withStyle(ChatFormatting.GRAY)
    );
    public static final DeferredBlock<Block> ORE_LIGNITE= registerBlock("ore_lignite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_ASBESTOS= registerBlock("ore_asbestos",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_AUSTRALIUM= registerBlock("ore_australium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)),
            new Item.Properties().rarity(Rarity.UNCOMMON),
            Component.translatable("block.hbm.ore_australium.tooltip.1").withStyle(ChatFormatting.GRAY),
            Component.translatable("block.hbm.ore_australium.tooltip.2").withStyle(ChatFormatting.GRAY),
            Component.translatable("block.hbm.ore_australium.tooltip.3").withStyle(ChatFormatting.GRAY)
    );
    public static final DeferredBlock<Block> ORE_RARE= registerBlock("ore_rare",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)),
            new Item.Properties().rarity(Rarity.UNCOMMON)
    );
    public static final DeferredBlock<Block> ORE_COBALT= registerBlock("ore_cobalt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_CINNEBAR= registerBlock("ore_cinnebar",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> ORE_COLTAN= registerBlock("ore_coltan",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> CLUSTER_IRON = registerBlock("cluster_iron",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> CLUSTER_TITANIUM = registerBlock("cluster_titanium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> CLUSTER_ALUMINIUM = registerBlock("cluster_aluminium",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );
    public static final DeferredBlock<Block> CLUSTER_COPPER = registerBlock("cluster_copper",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3, 3)
                    .requiresCorrectToolForDrops()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE))
    );



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
    /// Registers a block, with custom block item tooltip
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Component... tooltip) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, new Item.Properties(), tooltip);
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
