package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RDTFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Radiated.MOD_ID);



    public static final RegistryObject<FlowingFluid> SOURCE_UF6 = FLUIDS.register("uf6_fluid",
            () -> new ForgeFlowingFluid.Source(RDTFluids.UF6_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_UF6 = FLUIDS.register("flowing_uf6",
            () -> new ForgeFlowingFluid.Flowing(RDTFluids.UF6_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties UF6_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            RDTFluidTypes.UF6_FLUID_TYPE, SOURCE_UF6, FLOWING_UF6)
            .slopeFindDistance(0).levelDecreasePerBlock(3)
            .block(RDTFluidBlocknBuckets.UF6_BLOCK)
            .bucket(RDTFluidBlocknBuckets.UF6_BUCKET);



    public static final RegistryObject<FlowingFluid> SOURCE_STEAM_LOW_PRESSURE = FLUIDS.register("steam_low_pressure_fluid",
            () -> new ForgeFlowingFluid.Source(RDTFluids.STEAM_LOW_PRESSURE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_STEAM_LOW_PRESSURE = FLUIDS.register("flowing_steam_low_pressure",
            () -> new ForgeFlowingFluid.Flowing(RDTFluids.STEAM_LOW_PRESSURE_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties STEAM_LOW_PRESSURE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            RDTFluidTypes.STEAM_LOW_PRESSURE_FLUID_TYPE, SOURCE_STEAM_LOW_PRESSURE, FLOWING_STEAM_LOW_PRESSURE)
            .slopeFindDistance(4).levelDecreasePerBlock(1)
            .block(RDTFluidBlocknBuckets.STEAM_LOW_PRESSURE_BLOCK)
            .bucket(RDTFluidBlocknBuckets.STEAM_LOW_PRESSURE_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
