package net.guwy.hbm.datagen;

import net.guwy.hbm.datagen.data_maps.FurnaceFuelDataMapRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    /**
     * Create a new provider.
     *
     * @param packOutput     the output location
     * @param lookupProvider a {@linkplain CompletableFuture} supplying the registries
     */
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        // Furnace Fuels
        FurnaceFuelDataMapRegistry.init();
        FurnaceFuelDataMapRegistry.itemlikeFurnaceFuelMap.forEach((item, b) -> {
            builder(NeoForgeDataMaps.FURNACE_FUELS).add(item, new FurnaceFuel(b), false);
        });

    }
}
