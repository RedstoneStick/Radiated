package net.guwy.hbm.blocks.machines.brick_furnace;

import net.guwy.hbm.index.ModBlockEntityTypes;
import net.guwy.hbm.index.ModMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class BrickFurnaceBlockEntity extends AbstractBrickFurnaceBlockEntity {

    public BrickFurnaceBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.BRICK_FURNACE_BLOCK_ENTITY.get(), pos, blockState, RecipeType.SMELTING);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.hbm.brick_furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new BrickFurnaceMenu(containerId, inventory, this, this.dataAccess);
    }
}
