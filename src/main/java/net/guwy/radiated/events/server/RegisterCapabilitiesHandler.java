package net.guwy.radiated.events.server;

import net.guwy.radiated.mechanics.radiation.EntityRadiation;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public class RegisterCapabilitiesHandler {
    public static void init(RegisterCapabilitiesEvent event){
        event.register(EntityRadiation.class);
    }
}
