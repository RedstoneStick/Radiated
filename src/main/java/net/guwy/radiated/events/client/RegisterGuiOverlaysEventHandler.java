package net.guwy.radiated.events.client;

import net.guwy.radiated.content.overlays.GeigerCounterOverlay;
import net.guwy.radiated.content.overlays.HazmatHelmetOverlay;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;

public class RegisterGuiOverlaysEventHandler {
    public static void init(final RegisterGuiOverlaysEvent event){
        //HUD
        event.registerBelowAll("geiger_counter", GeigerCounterOverlay.OVERLAY);



        //Helmet Inner



        //Helmet Window
        event.registerBelowAll("hazmat_helmet", HazmatHelmetOverlay.HELMET_OVERLAY);
    }
}
