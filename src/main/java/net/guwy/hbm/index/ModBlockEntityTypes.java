package net.guwy.hbm.index;

import net.guwy.hbm.NTMMain;
import net.guwy.hbm.blocks.machines.brick_furnace.BrickFurnaceBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, NTMMain.MODID);



    public static final Supplier<BlockEntityType<BrickFurnaceBlockEntity>> BRICK_FURNACE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "brick_furnace_block_entity",
            () -> BlockEntityType.Builder.of(
                            BrickFurnaceBlockEntity::new,
                            NTMMachines.BRICK_FURNACE.get()
                    ).build(null)
    );



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
