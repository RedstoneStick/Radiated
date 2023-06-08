package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.items.BasicRadioactiveItem;
import net.guwy.sticky_foundations.StickyFoundations;
import net.guwy.sticky_foundations.index.SFCreativeModTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class RDTResources {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Radiated.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);






    public static final RegistryObject<Block> BERYLLIUM_ORE = registerBlock("beryllium_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).
                    strength(3f).explosionResistance(3f).requiresCorrectToolForDrops().
                    sound(SoundType.STONE), UniformInt.of(3,7)), RDTCreativeModeTabs.ORES_AND_BLOCKS);

    public static final RegistryObject<Block> BERYLLIUM_ORE_DEEPSLATE = registerBlock("beryllium_ore_deepslate", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).
                    strength(3f).explosionResistance(6f).requiresCorrectToolForDrops().
                    sound(SoundType.DEEPSLATE), UniformInt.of(3,7)), RDTCreativeModeTabs.ORES_AND_BLOCKS);

    public static final RegistryObject<Item> RAW_BERYLLIUM = ITEMS.register("raw_beryllium",
            () -> new Item(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> CRUSHED_BERYLLIUM = ITEMS.register("crushed_beryllium",
            () -> new Item(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot",
            () -> new Item(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> BERYLLIUM_NUGGET = ITEMS.register("beryllium_nugget",
            () -> new Item(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> BERYLLIUM_BILLET = ITEMS.register("beryllium_billet",
            () -> new Item(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS)));



    public static final RegistryObject<Item> RED_COPPER = ITEMS.register("red_copper",
            () -> new Item(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> RED_COPPER_WIRE = ITEMS.register("red_copper_wire",
            () -> new Item(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS)));



    public static final RegistryObject<Item> QUARTZ_DUST = ITEMS.register("quartz_dust",
            () -> new Item(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS)));



    public static final RegistryObject<Item> URANIUM_BILLET = ITEMS.register("uranium_billet",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.175));

    public static final RegistryObject<Item> THORIUM_BILLET = ITEMS.register("thorium_billet",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.05));



    public static final RegistryObject<Item> RADIUM_INGOT = ITEMS.register("radium_ingot",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 7.5));

    public static final RegistryObject<Item> RADIUM_NUGGET = ITEMS.register("radium_nugget",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.75));

    public static final RegistryObject<Item> RADIUM_BILLET = ITEMS.register("radium_billet",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 3.75));



    public static final RegistryObject<Item> URANIUM_235_INGOT = ITEMS.register("uranium_235_ingot",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 1.0));

    public static final RegistryObject<Item> URANIUM_235_NUGGET = ITEMS.register("uranium_235_nugget",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.1));

    public static final RegistryObject<Item> URANIUM_235_BILLET = ITEMS.register("uranium_235_billet",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.5));



    public static final RegistryObject<Item> URANIUM_238_INGOT = ITEMS.register("uranium_238_ingot",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.25));

    public static final RegistryObject<Item> URANIUM_238_NUGGET = ITEMS.register("uranium_238_nugget",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.025));

    public static final RegistryObject<Item> URANIUM_238_BILLET = ITEMS.register("uranium_238_billet",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.125));



    public static final RegistryObject<Item> URANIUM_FUEL_INGOT = ITEMS.register("uranium_fuel_ingot",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.5));

    public static final RegistryObject<Item> URANIUM_FUEL_NUGGET = ITEMS.register("uranium_fuel_nugget",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.05));

    public static final RegistryObject<Item> URANIUM_FUEL_BILLET = ITEMS.register("uranium_fuel_billet",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.25));



    public static final RegistryObject<Item> THORIUM_FUEL_INGOT = ITEMS.register("thorium_fuel_ingot",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 1.75));

    public static final RegistryObject<Item> THORIUM_FUEL_NUGGET = ITEMS.register("thorium_fuel_nugget",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.175));

    public static final RegistryObject<Item> THORIUM_FUEL_BILLET = ITEMS.register("thorium_fuel_billet",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(RDTCreativeModeTabs.RESOURCES_AND_PARTS), 0.875));






    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return RDTResources.BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey){
        return RDTResources.BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(Component.literal(tooltipKey));
            }
        });
    }


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
