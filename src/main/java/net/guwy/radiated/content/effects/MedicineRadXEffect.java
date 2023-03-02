package net.guwy.radiated.content.effects;

import net.guwy.radiated.mechanics.radiation.RadiationResistanceModifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class MedicineRadXEffect extends MobEffect implements RadiationResistanceModifier {
    public MedicineRadXEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public double resistanceVal() {
        return 0.37;
    }
}
