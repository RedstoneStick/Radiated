package net.guwy.radiated.events.client;

import net.guwy.radiated.content.overlays.GeigerCounterOverlay;
import net.guwy.radiated.content.overlays.HazmatHelmetOverlay;
import net.guwy.radiated.content.particles.VomitBloodParticle;
import net.guwy.radiated.content.particles.VomitParticle;
import net.guwy.radiated.index.NTMParticles;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;

public class RegisterParticleFactoriesEventHandler {
    public static void init(final RegisterParticleProvidersEvent event){

        event.register(NTMParticles.VOMIT_PARTICLE.get(), VomitParticle.Provider::new);
        event.register(NTMParticles.VOMIT_BLOOD_PARTICLE.get(), VomitBloodParticle.Provider::new);
    }
}
