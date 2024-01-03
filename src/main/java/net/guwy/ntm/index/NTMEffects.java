package net.guwy.ntm.index;

import net.guwy.ntm.NTM;
import net.guwy.ntm.content.effects.*;
import net.minecraft.util.FastColor;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NTMEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NTM.MOD_ID);

    public static final RegistryObject<MobEffect> FOOD_YELLOWCAKE = MOB_EFFECTS.register("food_yellowcake",
            () -> new FoodYellowcakeEffect(MobEffectCategory.HARMFUL, 0xFEBDEF0));

    public static final RegistryObject<MobEffect> MEDICINE_RAD_X = MOB_EFFECTS.register("medicine_rad_x",
            () -> new MedicineRadXEffect(MobEffectCategory.BENEFICIAL, 0xFEBDEF0));

    public static final RegistryObject<MobEffect> COFFE_RADIUM = MOB_EFFECTS.register("coffee_radium",
            () -> new RadiationApplyEffect(500, MobEffectCategory.HARMFUL, 0xFEBDEF0));

    public static final RegistryObject<MobEffect> VOMIT = MOB_EFFECTS.register("vomit",
            () -> new VomitEffect(MobEffectCategory.NEUTRAL, FastColor.ARGB32.color(255, 56, 130, 140)));

    public static final RegistryObject<MobEffect> VOMIT_BLOOD = MOB_EFFECTS.register("vomit_blood",
            () -> new VomitBloodEffect(MobEffectCategory.HARMFUL, FastColor.ARGB32.color(255, 140, 46, 49)));

    public static final RegistryObject<MobEffect> COUGH_COAL = MOB_EFFECTS.register("cough_coal",
            () -> new CoughCoalEffect(MobEffectCategory.NEUTRAL, FastColor.ARGB32.color(255, 112, 117, 112)));

    public static final RegistryObject<MobEffect> COUGH_BLOOD = MOB_EFFECTS.register("cough_blood",
            () -> new CoughBloodEffect(MobEffectCategory.HARMFUL, FastColor.ARGB32.color(255, 140, 46, 49)));



    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
