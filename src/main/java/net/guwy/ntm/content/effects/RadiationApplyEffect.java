package net.guwy.ntm.content.effects;

import net.guwy.ntm.mechanics.radiation.EntityRadiationProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class RadiationApplyEffect extends MobEffect {
    double rad;
    public RadiationApplyEffect(double rad, MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
        this.rad = rad;
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
        pLivingEntity.getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(handler -> {
            handler.increaseGeigerVal(rad);
        });
    }
}
