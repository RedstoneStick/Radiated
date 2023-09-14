package net.guwy.radiated.content.effects;

import net.guwy.radiated.index.NTMEffects;
import net.guwy.radiated.index.NTMParticles;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CoughCoalEffect extends MobEffect {

    public CoughCoalEffect(MobEffectCategory p_19451_, int p_19452_) {
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
        for(int i = 0; i < 10; i++){
            XSpeed += (Math.random() - 0.5) * randMultiplier;
            YSpeed += (Math.random() - 0.5) * randMultiplier;
            ZSpeed += (Math.random() - 0.5) * randMultiplier;

            pLivingEntity.level.addParticle(NTMParticles.COUGH_COAL_PARTICLE.get(),
                    pLivingEntity.getX(), pLivingEntity.getY() + pLivingEntity.getEyeHeight(), pLivingEntity.getZ(),
                    XSpeed, YSpeed, ZSpeed);
        }

        // Remove Effect
        pLivingEntity.removeEffect(NTMEffects.COUGH_COAL.get());

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
