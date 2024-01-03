package net.guwy.ntm.events.server;

import net.guwy.ntm.NTM;
import net.guwy.ntm.mechanics.lung_diseases.PlayerLungDiseasesProvider;
import net.guwy.ntm.mechanics.radiation.ChunkRadiationProvider;
import net.guwy.ntm.mechanics.radiation.EntityRadiationProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class AttachCapabilitiesHandler {
    public static void initEntity(AttachCapabilitiesEvent<Entity> event){
        if (!event.getObject().getCapability(EntityRadiationProvider.ENTITY_RADIATION).isPresent()) {
            event.addCapability(new ResourceLocation(NTM.MOD_ID, "radiation"), new EntityRadiationProvider());
        }

        if (!event.getObject().getCapability(PlayerLungDiseasesProvider.PLAYER_LUNG_DISEASES).isPresent()) {
            event.addCapability(new ResourceLocation(NTM.MOD_ID, "lungs"), new PlayerLungDiseasesProvider());
        }
    }

    public static void initChunk(AttachCapabilitiesEvent<LevelChunk> event){
        if (!event.getObject().getCapability(ChunkRadiationProvider.CHUNK_RADIATION).isPresent()) {
            event.addCapability(new ResourceLocation(NTM.MOD_ID, "chunk_radiation"), new ChunkRadiationProvider());
        }
    }
}
