package net.guwy.radiated.mechanics.radiation;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChunkRadiationProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<ChunkRadiation> CHUNK_RADIATION = CapabilityManager.get(new CapabilityToken<ChunkRadiation>() { });

    private ChunkRadiation chunkRadiation = null;
    private final LazyOptional<ChunkRadiation> optional = LazyOptional.of(this::createChunkRadiation);

    private ChunkRadiation createChunkRadiation() {
        if(this.chunkRadiation == null){
            this.chunkRadiation = new ChunkRadiation();
        }
        return chunkRadiation;
    }


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CHUNK_RADIATION){
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createChunkRadiation().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createChunkRadiation().loadNBTData(nbt);
    }
}
