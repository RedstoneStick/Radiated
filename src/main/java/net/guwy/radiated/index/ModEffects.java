package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.effects.FoodYellowcakeEffect;
import net.guwy.radiated.content.effects.MedicineRadXEffect;
import net.guwy.radiated.content.effects.RadiationApplyEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Radiated.MOD_ID);

    public static final RegistryObject<MobEffect> FOOD_YELLOWCAKE = MOB_EFFECTS.register("food_yellowcake",
            () -> new FoodYellowcakeEffect(MobEffectCategory.HARMFUL, 0xFEBDEF0));

    public static final RegistryObject<MobEffect> MEDICINE_RAD_X = MOB_EFFECTS.register("medicine_rad_x",
            () -> new MedicineRadXEffect(MobEffectCategory.BENEFICIAL, 0xFEBDEF0));

    public static final RegistryObject<MobEffect> COFFE_RADIUM = MOB_EFFECTS.register("coffee_radium",
            () -> new RadiationApplyEffect(500, MobEffectCategory.HARMFUL, 0xFEBDEF0));



    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
