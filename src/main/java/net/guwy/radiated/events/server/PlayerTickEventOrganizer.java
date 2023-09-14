package net.guwy.radiated.events.server;

import net.guwy.radiated.events.server.player.PlayerHazardHandler;
import net.guwy.radiated.events.server.player.PlayerRadiationHandler;
import net.minecraftforge.event.TickEvent;

public class PlayerTickEventOrganizer {
    public static void init(TickEvent.PlayerTickEvent event){
        int counter = event.player.tickCount;

        // Every Tick
        PlayerHazardHandler.init(event);

        if((counter % 20) == 0){    //Every Second
            PlayerRadiationHandler.init(event);
        }



        //if((counter % 10) == 0){    //Every Half a Second
        //}



        //if((counter % 5) == 0){    //Every Quarter of a Second
        //}



        //if((counter % 1200) == 0){    //Every Minute (Not very reliable under some circumstances)
        //}
    }
}
