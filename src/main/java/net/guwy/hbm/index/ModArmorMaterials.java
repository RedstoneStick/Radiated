package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final Holder<ArmorMaterial> STEEL = register("steel", Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
        attribute.put(ArmorItem.Type.BOOTS, 2);
        attribute.put(ArmorItem.Type.LEGGINGS, 5);
        attribute.put(ArmorItem.Type.CHESTPLATE, 6);
        attribute.put(ArmorItem.Type.HELMET, 2);
        attribute.put(ArmorItem.Type.BODY, 15);
    }), 5, 0, 0
    , () -> Ingredient.of(ModTags.Items.INGOTS_STEEL), SoundEvents.ARMOR_EQUIP_IRON);

    public static final Holder<ArmorMaterial> TITANIUM = register("titanium", Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 20);
            }), 9, 0, 0
            , () -> Ingredient.of(ModTags.Items.INGOTS_COBALT), SoundEvents.ARMOR_EQUIP_IRON);

    public static final Holder<ArmorMaterial> COBALT = register("cobalt", Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 20);
            }), 60, 0, 0
            , () -> Ingredient.of(ModTags.Items.INGOTS_COBALT), SoundEvents.ARMOR_EQUIP_DIAMOND);



    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantmentValue, float toughness, float knockbackResistance,
                                                  Supplier<Ingredient> repairIngredient, Holder<SoundEvent> equipSound) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(NTMMain.MODID, name);
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantmentValue, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }
}
