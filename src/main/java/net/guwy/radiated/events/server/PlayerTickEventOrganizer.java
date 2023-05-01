package net.guwy.radiated.events.server;

import net.guwy.radiated.events.server.player_tick.PlayerRadiationHandler;
import net.guwy.radiated.mechanics.gasmask.VisorWearTick;
import net.minecraftforge.event.TickEvent;

public class PlayerTickEventOrganizer {
    public static void init(TickEvent.PlayerTickEvent event){
        int counter = event.player.tickCount;

        if((counter % 20) == 0){    //Every Second
            PlayerRadiationHandler.init(event);
        }



        if((counter % 10) == 0){    //Every Half a Second
            VisorWearTick.process(event.player);
        }



        //if((counter % 5) == 0){    //Every Quarter of a Second
        //}



        //if((counter % 1200) == 0){    //Every Minute (Not very reliable under some circumstances)
        //}
    }
}
