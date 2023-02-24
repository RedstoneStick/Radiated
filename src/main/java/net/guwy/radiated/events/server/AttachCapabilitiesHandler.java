package net.guwy.radiated.events.server;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.mechanics.radiation.EntityRadiation;
import net.guwy.radiated.mechanics.radiation.EntityRadiationProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class AttachCapabilitiesHandler {
    public static void initEntity(AttachCapabilitiesEvent<Entity> event){
        //if (event.getObject() instanceof Player) {
        //}

        if (!event.getObject().getCapability(EntityRadiationProvider.ENTITY_RADIATION).isPresent()) {
            event.addCapability(new ResourceLocation(Radiated.MOD_ID, "radiation"), new EntityRadiationProvider());
        }
    }
}
