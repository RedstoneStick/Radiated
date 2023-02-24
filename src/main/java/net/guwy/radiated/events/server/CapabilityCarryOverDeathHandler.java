package net.guwy.radiated.events.server;

import net.guwy.radiated.mechanics.radiation.EntityRadiationProvider;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class CapabilityCarryOverDeathHandler {
    public static void init(PlayerEvent.Clone event){
        //if(event.isWasDeath()) {
        //    event.getOriginal().reviveCaps();
        //    event.getOriginal().getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(oldStore -> {
        //        event.getEntity().getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(newStore -> {
        //            if(oldStore.getPlayerRadiationVal() > 450){
        //                oldStore.setPlayerRadiationVal(450);
        //            }
        //            newStore.copyFrom(oldStore);
        //        });
        //    });
        //    event.getOriginal().invalidateCaps();
        //}
    }
}
