package net.guwy.radiated.events.server;

import net.guwy.radiated.mechanics.lung_diseases.PlayerLungDiseases;
import net.guwy.radiated.mechanics.radiation.ChunkRadiation;
import net.guwy.radiated.mechanics.radiation.EntityRadiation;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public class RegisterCapabilitiesHandler {
    public static void init(RegisterCapabilitiesEvent event){
        event.register(EntityRadiation.class);
        event.register(PlayerLungDiseases.class);
        event.register(ChunkRadiation.class);
    }
}
