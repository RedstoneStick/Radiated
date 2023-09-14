package net.guwy.radiated.events.client;

import net.guwy.radiated.content.particles.CoughBloodParticle;
import net.guwy.radiated.content.particles.CoughCoalParticle;
import net.guwy.radiated.content.particles.VomitBloodParticle;
import net.guwy.radiated.content.particles.VomitParticle;
import net.guwy.radiated.index.NTMParticles;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;

public class RegisterParticleFactoriesEventHandler {
    public static void init(final RegisterParticleProvidersEvent event){

        event.register(NTMParticles.VOMIT_PARTICLE.get(), VomitParticle.Provider::new);
        event.register(NTMParticles.VOMIT_BLOOD_PARTICLE.get(), VomitBloodParticle.Provider::new);
        event.register(NTMParticles.COUGH_COAL_PARTICLE.get(), CoughCoalParticle.Provider::new);
        event.register(NTMParticles.COUGH_BLOOD_PARTICLE.get(), CoughBloodParticle.Provider::new);
    }
}
