package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.items.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NTMTools {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);



    public static final RegistryObject<Item> GEIGER_COUNTER = ITEMS.register("geiger_counter",
            () -> new GeigerCounterItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR)));




    public static final RegistryObject<Item> GAS_MASK_FILTER = ITEMS.register("gas_mask_filter",
            () -> new BasicFilterItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR).durability(400000),
                    true, true, true, true, false, true));

    public static final RegistryObject<Item> CATALYTIC_MASK_FILTER = ITEMS.register("catalytic_mask_filter",
            () -> new BasicFilterItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR).durability(400000),
                    true, false, false, false, true, false));

    public static final RegistryObject<Item> GAS_MASK_COMBO_FILTER = ITEMS.register("gas_mask_combo_filter",
            () -> new BasicFilterItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR).durability(200000),
                    true, true, true, true, true, true));

    public static final RegistryObject<Item> MAKESHIFT_GAS_MASK_FILTER = ITEMS.register("makeshift_gas_mask_filter",
            () -> new BasicFilterItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR).durability(20000),
                    true, false, false, false, false, false));

    public static final RegistryObject<Item> ADVANCED_MAKESHIFT_GAS_MASK_FILTER = ITEMS.register("advanced_makeshift_gas_mask_filter",
            () -> new BasicFilterItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR).durability(20000),
                    true, false, true, false, false, false));




    public static final RegistryObject<Item> RAD_X = ITEMS.register("rad_x",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR).food(NTMFoods.RAD_X)){
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                    pTooltipComponents.add(Component.translatable("tooltip.radiated.rad_x").withStyle(ChatFormatting.GRAY));
                    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                }
            });



    public static final RegistryObject<Item> IV_BAG = ITEMS.register("iv_bag",
            () -> new IVBagItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR)));

    public static final RegistryObject<Item> BLOOD_BAG = ITEMS.register("blood_bag",
            () -> new Item(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR)));

    public static final RegistryObject<Item> RADAWAY = ITEMS.register("radaway",
            () -> new RadawayItem(200, new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR)));



    public static final RegistryObject<Item> DUCT_TAPE = ITEMS.register("duct_tape",
            () -> new DuctTapeItem(new Item.Properties().tab(NTMCreativeModeTabs.CONSUMABLES_AND_GEAR)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
