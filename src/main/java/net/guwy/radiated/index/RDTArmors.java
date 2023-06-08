package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.items.HazmatArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RDTArmors {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Radiated.MOD_ID);



    public static final RegistryObject<Item> HAZMAT_HELMET = ITEMS.register("hazmat_helmet",
            () -> new HazmatArmorItem(0.06, ModArmorMaterials.HAZMAT_ARMOR, EquipmentSlot.HEAD
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> HAZMAT_CHESTPLATE = ITEMS.register("hazmat_chestplate",
            () -> new HazmatArmorItem(0.12, ModArmorMaterials.HAZMAT_ARMOR, EquipmentSlot.CHEST
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> HAZMAT_LEGGINGS = ITEMS.register("hazmat_leggings",
            () -> new HazmatArmorItem(0.09, ModArmorMaterials.HAZMAT_ARMOR, EquipmentSlot.LEGS
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> HAZMAT_BOOTS = ITEMS.register("hazmat_boots",
            () -> new HazmatArmorItem(0.03, ModArmorMaterials.HAZMAT_ARMOR, EquipmentSlot.FEET
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));



    public static final RegistryObject<Item> HAZMAT_ADVANCED_HELMET = ITEMS.register("hazmat_advanced_helmet",
            () -> new HazmatArmorItem(0.10, ModArmorMaterials.HAZMAT_ADVANCED_ARMOR, EquipmentSlot.HEAD
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> HAZMAT_ADVANCED_CHESTPLATE = ITEMS.register("hazmat_advanced_chestplate",
            () -> new HazmatArmorItem(0.20, ModArmorMaterials.HAZMAT_ADVANCED_ARMOR, EquipmentSlot.CHEST
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> HAZMAT_ADVANCED_LEGGINGS = ITEMS.register("hazmat_advanced_leggings",
            () -> new HazmatArmorItem(0.15, ModArmorMaterials.HAZMAT_ADVANCED_ARMOR, EquipmentSlot.LEGS
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> HAZMAT_ADVANCED_BOOTS = ITEMS.register("hazmat_advanced_boots",
            () -> new HazmatArmorItem(0.05, ModArmorMaterials.HAZMAT_ADVANCED_ARMOR, EquipmentSlot.FEET
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));



    public static final RegistryObject<Item> HAZMAT_HIGH_PERFORMANCE_HELMET = ITEMS.register("hazmat_high_performance_helmet",
            () -> new HazmatArmorItem(0.17, ModArmorMaterials.HAZMAT_HIGH_PERFORMANCE_ARMOR, EquipmentSlot.HEAD
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> HAZMAT_HIGH_PERFORMANCE_CHESTPLATE = ITEMS.register("hazmat_high_performance_chestplate",
            () -> new HazmatArmorItem(0.33, ModArmorMaterials.HAZMAT_HIGH_PERFORMANCE_ARMOR, EquipmentSlot.CHEST
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> HAZMAT_HIGH_PERFORMANCE_LEGGINGS = ITEMS.register("hazmat_high_performance_leggings",
            () -> new HazmatArmorItem(0.22, ModArmorMaterials.HAZMAT_HIGH_PERFORMANCE_ARMOR, EquipmentSlot.LEGS
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> HAZMAT_HIGH_PERFORMANCE_BOOTS = ITEMS.register("hazmat_high_performance_boots",
            () -> new HazmatArmorItem(0.08, ModArmorMaterials.HAZMAT_HIGH_PERFORMANCE_ARMOR, EquipmentSlot.FEET
                    , new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
