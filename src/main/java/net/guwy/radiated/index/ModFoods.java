package net.guwy.radiated.index;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BRED = (
            new FoodProperties.Builder()).nutrition(2).saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.FOOD_YELLOWCAKE.get()
                    , 100, 1, false, false, false), 1f )
            .build();
    public static final FoodProperties YELLOWCAKE = (
            new FoodProperties.Builder()).nutrition(16).saturationMod(1F).alwaysEat()
            .effect(() -> new MobEffectInstance(ModEffects.FOOD_YELLOWCAKE.get()
                    , 100, 1, false, false, false), 1f)
            .build();
    public static final FoodProperties RAD_X = (
            new FoodProperties.Builder()).nutrition(0).saturationMod(0).alwaysEat()
            .effect(() -> new MobEffectInstance(ModEffects.MEDICINE_RAD_X.get()
                    , 3600, 0, false, false, false), 1f)
            .build();
    public static final FoodProperties COFFE = (
            new FoodProperties.Builder()).nutrition(0).saturationMod(0).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED
                    , 1200, 2, false, false, false), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL
                    , 1, 0, false, false, false), 1f)
            .build();
    public static final FoodProperties COFFE_RADIUM = (
            new FoodProperties.Builder()).nutrition(0).saturationMod(0).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED
                    , 1200, 2, false, false, false), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL
                    , 1, 0, false, false, false), 1f)
            .effect(() -> new MobEffectInstance(ModEffects.COFFE_RADIUM.get()
                    , 1, 0, false, false, false), 1f)
            .build();
}
