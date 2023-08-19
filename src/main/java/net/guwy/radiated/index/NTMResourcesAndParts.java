package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.items.hazard_items.BasicHazardItem;
import net.guwy.radiated.content.items.hazard_items.BasicRadioactiveItem;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class NTMResourcesAndParts {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Radiated.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);



    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.35));
    public static final RegistryObject<Item> URANIUM_233_INGOT = ITEMS.register("uranium_233_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.0));
    public static final RegistryObject<Item> URANIUM_235_INGOT = ITEMS.register("uranium_235_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            1.0));
    public static final RegistryObject<Item> URANIUM_238_INGOT = ITEMS.register("uranium_238_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.25));
    public static final RegistryObject<Item> THORIUM_232_INGOT = ITEMS.register("thorium_232_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            0.1));
    public static final RegistryObject<Item> PLUTONIUM_INGOT = ITEMS.register("plutonium_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));
    public static final RegistryObject<Item> PLUTONIUM_238_INGOT = ITEMS.register("plutonium_238_ingot", () -> new BasicHazardItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            10.0, 0, 0, true, false, false, false));
    public static final RegistryObject<Item> PLUTONIUM_239_INGOT = ITEMS.register("plutonium_239_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            5.0));
    public static final RegistryObject<Item> PLUTONIUM_240_INGOT = ITEMS.register("plutonium_240_ingot", () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS),
            7.5));



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
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
