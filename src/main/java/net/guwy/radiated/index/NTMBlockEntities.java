package net.guwy.radiated.index;

import net.guwy.radiated.Radiated;
import net.guwy.radiated.content.blocks.machines.rtg.RTGBlockEntity;
import net.guwy.radiated.content.blocks.machines.turbine.TurbineBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NTMBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Radiated.MOD_ID);


    public static final RegistryObject<BlockEntityType<TurbineBlockEntity>> TURBINE =
            BLOCK_ENTITIES.register("turbine", () ->
                    BlockEntityType.Builder.of(TurbineBlockEntity::new,
                            NTMMachines.TURBINE.get()).build(null));

    public static final RegistryObject<BlockEntityType<RTGBlockEntity>> RTG =
            BLOCK_ENTITIES.register("rtg", () ->
                    BlockEntityType.Builder.of(RTGBlockEntity::new,
                            NTMMachines.RTG.get()).build(null));




    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
