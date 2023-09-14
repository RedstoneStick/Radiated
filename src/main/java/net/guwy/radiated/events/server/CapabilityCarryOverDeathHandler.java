package net.guwy.radiated.events.server;

import net.guwy.radiated.mechanics.lung_diseases.PlayerLungDiseasesProvider;
import net.guwy.radiated.mechanics.radiation.EntityRadiationProvider;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class CapabilityCarryOverDeathHandler {
    public static void init(PlayerEvent.Clone event){

        // If not dead (travelling from end to overworld via portal)
        if(!event.isWasDeath()) {
            event.getOriginal().reviveCaps();

            // Carry Radiation Exposure
            event.getOriginal().getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(oldStore -> {
                event.getEntity().getCapability(EntityRadiationProvider.ENTITY_RADIATION).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            // Carry Lung Diseases
            event.getOriginal().getCapability(PlayerLungDiseasesProvider.PLAYER_LUNG_DISEASES).ifPresent(oldStore -> {
                event.getEntity().getCapability(PlayerLungDiseasesProvider.PLAYER_LUNG_DISEASES).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().invalidateCaps();
        }
    }
}
