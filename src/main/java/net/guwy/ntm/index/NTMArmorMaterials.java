package net.guwy.ntm.index;

import net.guwy.ntm.NTM;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum NTMArmorMaterials implements ArmorMaterial {
    //Armor protection values are: boots, leggings, chestplate, helmet

    HAZMAT_ARMOR("hazmat_armor", 1, new int[]{1,4,5,2}, 0,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of()),

    HAZMAT_ADVANCED_ARMOR("hazmat_advanced_armor", 2, new int[]{1,4,5,2}, 0,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of()),

    HAZMAT_HIGH_PERFORMANCE_ARMOR("hazmat_high_performance_armor", 2, new int[]{1,4,5,2}, 0,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of());

    private static final int[] HEALTH_PER_SLOT = new int[]{100, 100, 100, 100};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    NTMArmorMaterials(String pName, int pDurabilityMultiplier, int[] pSlotProtections, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.slotProtections = pSlotProtections;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return NTM.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    /**
     * Gets the percentage of knockback resistance provided by armor of the material.
     */
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
