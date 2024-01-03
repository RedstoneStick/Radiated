package net.guwy.ntm.events.client;

import net.guwy.ntm.content.particles.CoughBloodParticle;
import net.guwy.ntm.content.particles.CoughCoalParticle;
import net.guwy.ntm.content.particles.VomitBloodParticle;
import net.guwy.ntm.content.particles.VomitParticle;
import net.guwy.ntm.index.NTMParticles;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;

public class RegisterParticleFactoriesEventHandler {
    public static void init(final RegisterParticleProvidersEvent event){

        event.register(NTMParticles.VOMIT_PARTICLE.get(), VomitParticle.Provider::new);
        event.register(NTMParticles.VOMIT_BLOOD_PARTICLE.get(), VomitBloodParticle.Provider::new);
        event.register(NTMParticles.COUGH_COAL_PARTICLE.get(), CoughCoalParticle.Provider::new);
        event.register(NTMParticles.COUGH_BLOOD_PARTICLE.get(), CoughBloodParticle.Provider::new);
    }
}
