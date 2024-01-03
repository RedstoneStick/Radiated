package net.guwy.ntm.mechanics.radiation;

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

public class EntityRadiationProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<EntityRadiation> ENTITY_RADIATION = CapabilityManager.get(new CapabilityToken<EntityRadiation>() { });

    private EntityRadiation entityRadiation = null;
    private final LazyOptional<EntityRadiation> optional = LazyOptional.of(this::createEntityRadiation);

    private EntityRadiation createEntityRadiation() {
        if(this.entityRadiation == null){
            this.entityRadiation = new EntityRadiation();
        }
        return entityRadiation;
    }


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ENTITY_RADIATION){
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createEntityRadiation().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createEntityRadiation().loadNBTData(nbt);
    }
}
