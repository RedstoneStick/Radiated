package net.guwy.radiated.index;

import com.mojang.math.Vector3f;
import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.fluid.BaseFluidType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RDTFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation LAVA_STILL_RL = new ResourceLocation("block/lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = new ResourceLocation("block/lava_flow");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Radiated.MOD_ID);



    //public static final RegistryObject<FluidType> SOAP_WATER_FLUID_TYPE = register("soap_water_fluid",
    //        FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
    //                SoundEvents.HONEY_DRINK));

    public static final ResourceLocation UF6_STILL_RL = new ResourceLocation(Radiated.MOD_ID,"fluids/uf6_still");
    public static final ResourceLocation UF6_FLOWING_RL = new ResourceLocation(Radiated.MOD_ID,"fluids/uf6_flow");

    public static final RegistryObject<FluidType> UF6_FLUID_TYPE = register("uf6_fluid",
            FluidType.Properties.create().density(15).viscosity(5).lightLevel(2),
            0xffffffff, new Vector3f(186f / 255f, 174f / 255f, 163f / 255f),
            UF6_STILL_RL, UF6_FLOWING_RL, UF6_FLOWING_RL);




    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties, int tintColor, Vector3f fogColor,
                                                      ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlayTexture) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(stillTexture, flowingTexture, overlayTexture,
                tintColor, fogColor, properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
