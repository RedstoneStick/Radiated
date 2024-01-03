package net.guwy.ntm.content.effects;

import net.guwy.ntm.index.NTMParticles;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class VomitEffect extends MobEffect {

    public VomitEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Level level = pLivingEntity.getLevel();

        boolean puke = true;

        // If the player doesn't have any food, don't puke
        if(pLivingEntity.getType() == EntityType.PLAYER){
            Player player = (Player) pLivingEntity;

            puke = player.getFoodData().getFoodLevel() != 0;
        }

        if(puke){
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

                level.addParticle(NTMParticles.VOMIT_PARTICLE.get(), pLivingEntity.position().x(), pLivingEntity.position().y() + pLivingEntity.getEyeHeight(), pLivingEntity.position().z(), XSpeed, YSpeed, ZSpeed);
            }

            // Food Drain
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 2, 100, false, false, false));
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
