package net.guwy.ntm.mechanics.lung_diseases;

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

public class PlayerLungDiseasesProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerLungDiseases> PLAYER_LUNG_DISEASES = CapabilityManager.get(new CapabilityToken<PlayerLungDiseases>() { });

    private PlayerLungDiseases playerLungDiseases = null;
    private final LazyOptional<PlayerLungDiseases> optional = LazyOptional.of(this::createPlayerLungDiseases);

    private PlayerLungDiseases createPlayerLungDiseases() {
        if(this.playerLungDiseases == null){
            this.playerLungDiseases = new PlayerLungDiseases();
        }
        return playerLungDiseases;
    }


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_LUNG_DISEASES){
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerLungDiseases().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerLungDiseases().loadNBTData(nbt);
    }
}
