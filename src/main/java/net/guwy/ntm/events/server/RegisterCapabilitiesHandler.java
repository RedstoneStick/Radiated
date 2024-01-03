package net.guwy.ntm.events.server;

import net.guwy.ntm.mechanics.lung_diseases.PlayerLungDiseases;
import net.guwy.ntm.mechanics.radiation.ChunkRadiation;
import net.guwy.ntm.mechanics.radiation.EntityRadiation;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public class RegisterCapabilitiesHandler {
    public static void init(RegisterCapabilitiesEvent event){
        event.register(EntityRadiation.class);
        event.register(PlayerLungDiseases.class);
        event.register(ChunkRadiation.class);
    }
}
