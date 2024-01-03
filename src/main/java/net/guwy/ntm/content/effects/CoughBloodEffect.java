package net.guwy.ntm.content.effects;

import net.guwy.ntm.index.NTMEffects;
import net.guwy.ntm.index.NTMParticles;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CoughBloodEffect extends MobEffect {

    public CoughBloodEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
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

        // Calculate pos and speed
        double XLook = Math.toRadians(pLivingEntity.getViewYRot(1) + 90);
        double YLook = Math.toRadians(-pLivingEntity.getViewXRot(1));
        double multiplier = 0.4, randMultiplier = 0.2;

        double XSpeed = Math.cos(XLook) * Math.cos(YLook) * multiplier;
        double YSpeed = YLook * multiplier;
        double ZSpeed = Math.sin(XLook) * Math.cos(YLook) * multiplier;


        // Spawn Particles
        for(int i = 0; i < 20; i++){
            XSpeed += (Math.random() - 0.5) * randMultiplier;
            YSpeed += (Math.random() - 0.5) * randMultiplier;
            ZSpeed += (Math.random() - 0.5) * randMultiplier;

            pLivingEntity.level.addParticle(NTMParticles.COUGH_BLOOD_PARTICLE.get(),
                    pLivingEntity.getX(), pLivingEntity.getY() + pLivingEntity.getEyeHeight(), pLivingEntity.getZ(),
                    XSpeed, YSpeed, ZSpeed);
        }

        // Remove Effect
        pLivingEntity.removeEffect(NTMEffects.COUGH_BLOOD.get());

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
