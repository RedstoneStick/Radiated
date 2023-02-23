package net.guwy.radiated.index;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BRED = (
            new FoodProperties.Builder()).nutrition(2).saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.FOOD_YELLOWCAKE.get(), 100, 1), 1f).build();
    public static final FoodProperties YELLOWCAKE = (
            new FoodProperties.Builder()).nutrition(16).saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.FOOD_YELLOWCAKE.get(), 100, 1), 1f).build();
}
