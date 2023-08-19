package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.items.*;
import net.guwy.radiated.content.items.hazard_items.BasicRadioactiveItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class RDTItems {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Radiated.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);



    // Components
    public static final RegistryObject<Item> THERMOELECTRIC_ELEMENT = ITEMS.register("thermoelectric_element",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> RTG_UNIT = ITEMS.register("rtg_unit",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> COPPER_PANEL = ITEMS.register("copper_panel",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> POLYMER_BAR = ITEMS.register("polymer_bar",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> HAZMAT_CLOTH = ITEMS.register("hazmat_cloth",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> HAZMAT_ADVANCED_CLOTH = ITEMS.register("hazmat_advanced_cloth",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> HAZMAT_HIGH_PERFORMANCE_CLOTH = ITEMS.register("hazmat_high_performance_cloth",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS)));

    public static final RegistryObject<Item> YELLOWCAKE = ITEMS.register("yellowcake",
            () -> new BasicRadioactiveItem(new Item.Properties().tab(NTMCreativeModeTabs.RESOURCES_AND_PARTS).food(ModFoods.YELLOWCAKE), 1.05){
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.radiated.yellowcake").withStyle(ChatFormatting.GOLD));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });



    // Foods
    public static final RegistryObject<Item> COFFEE = ITEMS.register("coffee",
            () -> new CoffeeItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR).food(ModFoods.COFFE)));

    public static final RegistryObject<Item> COFFEE_RADIUM = ITEMS.register("coffee_radium",
            () -> new CoffeeItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR).food(ModFoods.COFFE_RADIUM)){
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.radiated.radium_coffee").withStyle(ChatFormatting.GRAY));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });




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
