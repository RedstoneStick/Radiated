package net.guwy.radiated.content.effects;

import net.guwy.radiated.index.ModDamageSources;
import net.guwy.radiated.index.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FoodYellowcakeEffect extends MobEffect {
    public FoodYellowcakeEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        double rand = Math.random();

        if(rand < 0.33){
            pLivingEntity.hurt(ModDamageSources.YELLOWCAKE_1,Float.MAX_VALUE);
        } else if (rand < 0.66){
            pLivingEntity.hurt(ModDamageSources.YELLOWCAKE_2,Float.MAX_VALUE);
        } else {
            pLivingEntity.hurt(ModDamageSources.YELLOWCAKE_3,Float.MAX_VALUE);
        }

        pLivingEntity.removeEffect(ModEffects.FOOD_YELLOWCAKE.get());
    }
}
