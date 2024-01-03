package net.guwy.ntm.index;

import net.guwy.ntm.NTM;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NTMParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, NTM.MOD_ID);



    public static final RegistryObject<SimpleParticleType> VOMIT_PARTICLE = PARTICLE_TYPES.register("vomit_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> VOMIT_BLOOD_PARTICLE = PARTICLE_TYPES.register("vomit_blood_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> COUGH_COAL_PARTICLE = PARTICLE_TYPES.register("cough_coal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> COUGH_BLOOD_PARTICLE = PARTICLE_TYPES.register("cough_blood_particle", () -> new SimpleParticleType(true));



    public static void register(IEventBus eventBus){
        PARTICLE_TYPES.register(eventBus);
    }
}
