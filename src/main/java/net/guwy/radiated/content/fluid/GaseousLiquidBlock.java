package net.guwy.radiated.content.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.function.Supplier;

public class GaseousLiquidBlock extends LiquidBlock {
    public GaseousLiquidBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties) {
        super(pFluid, pProperties);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {

        int x = pPos.getX(), y = pPos.getY(), z = pPos.getZ();
        int r = 2;

        List<Entity> list = pLevel.getEntities(null, new AABB(x-r, y-r, z-r, x+r, y+r, z+r));
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getType() == EntityType.PLAYER){
                Player player = (Player) list.get(i);
                String str = pLevel.getFluidState(pPos).getFluidType().getDescription().getString();
                player.sendSystemMessage(Component.translatable("message.radiated.fluid.gas_dissipate", str));
            }

        }

        pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
    }
}
