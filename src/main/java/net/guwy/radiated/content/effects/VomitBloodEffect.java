package net.guwy.radiated.content.effects;

import net.guwy.radiated.index.NTMDamageSources;
import net.guwy.radiated.index.NTMParticles;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class VomitBloodEffect extends MobEffect {

    public VomitBloodEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Level level = pLivingEntity.getLevel();

        // Don't puke if the health is critical
        if(pLivingEntity.getHealth() > 1){
            double XLook = Math.toRadians(pLivingEntity.getViewYRot(1) + 90);
            double YLook = Math.toRadians(-pLivingEntity.getViewXRot(1));
            double multiplier = 0.8, randMultiplier = 0.3;

            double XSpeed = Math.cos(XLook) * Math.cos(YLook) * multiplier;
            double YSpeed = YLook * multiplier;
            double ZSpeed = Math.sin(XLook) * Math.cos(YLook) * multiplier;

            for(int i = 0; i < 4; i++){
                XSpeed += (Math.random() - 0.5) * randMultiplier;
                YSpeed += (Math.random() - 0.5) * randMultiplier;
                ZSpeed += (Math.random() - 0.5) * randMultiplier;

                level.addParticle(NTMParticles.VOMIT_BLOOD_PARTICLE.get(), pLivingEntity.position().x(), pLivingEntity.position().y() + pLivingEntity.getEyeHeight(), pLivingEntity.position().z(), XSpeed, YSpeed, ZSpeed);
            }

            // Damage
            pLivingEntity.hurt(NTMDamageSources.VOMIT_BLOOD, 0.4f);
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
