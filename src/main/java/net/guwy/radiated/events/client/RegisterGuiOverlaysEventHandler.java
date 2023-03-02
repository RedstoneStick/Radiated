package net.guwy.radiated.events.client;

import net.guwy.radiated.overlays.HazmatHelmetOverlay;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;

public class RegisterGuiOverlaysEventHandler {
    public static void init(final RegisterGuiOverlaysEvent event){
        event.registerBelowAll("hazmat_helmet", HazmatHelmetOverlay.HELMET_OVERLAY);
    }
}
