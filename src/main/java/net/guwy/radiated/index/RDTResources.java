package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
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
                    sound(SoundType.STONE), UniformInt.of(3,7)), NTMCreativeModeTabs.ORES_AND_BLOCKS);

    public static final RegistryObject<Block> BERYLLIUM_ORE_DEEPSLATE = registerBlock("beryllium_ore_deepslate", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).
                    strength(3f).explosionResistance(6f).requiresCorrectToolForDrops().
                    sound(SoundType.DEEPSLATE), UniformInt.of(3,7)), NTMCreativeModeTabs.ORES_AND_BLOCKS);

    public static final RegistryObject<Item> RAW_BERYLLIUM = ITEMS.register("raw_beryllium",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> CRUSHED_BERYLLIUM = ITEMS.register("crushed_beryllium",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> BERYLLIUM_NUGGET = ITEMS.register("beryllium_nugget",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> BERYLLIUM_BILLET = ITEMS.register("beryllium_billet",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));






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
