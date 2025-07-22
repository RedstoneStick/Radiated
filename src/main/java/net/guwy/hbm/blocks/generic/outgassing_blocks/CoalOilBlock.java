package net.guwy.hbm.blocks.generic.outgassing_blocks;

import net.guwy.hbm.index.NTMOresNBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class CoalOilBlock extends Block {
    Supplier<Block> convertsTo;

    public CoalOilBlock(Properties properties, Supplier<Block> convertsTo) {
        super(properties);
        this.convertsTo = convertsTo;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 1;
    }
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 300;
    }


    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        for (Direction dir : Direction.values()) {
            Block nBlock = level.getBlockState(pos.relative(dir)).getBlock();

            if (isFire(nBlock)) {
                level.scheduleTick(pos, this, level.random.nextInt(20) + 2);
            }
        }

        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlock(pos, convertsTo.get().defaultBlockState(), 3);
    }


    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);

        if (doesToolIgnite(tool) && level.random.nextInt(10) == 0) {
            level.setBlock(pos, BaseFireBlock.getState(level, pos), 3);
        }
    }

    @Override
    public void wasExploded(Level level, BlockPos pos, Explosion explosion) {
        level.setBlock(pos, BaseFireBlock.getState(level, pos), 3);
    }


    @Override
    protected void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (level.isClientSide && doesToolIgnite(player.getItemInHand(InteractionHand.MAIN_HAND))) {
            for(int i = 0; i < 15; i++) {
                Vec3 vec = new Vec3(1, 0, 0);
                vec = vec.zRot((float)(Math.PI * level.random.nextDouble() * 2.0));
                vec = vec.yRot((float)(Math.PI * level.random.nextDouble() * 2.0));

                double dX = vec.x();
                double dY = vec.y();
                double dZ = vec.z();

                /*
                //Why
                if(Math.abs(dX) > 1)
                    dX /= Math.abs(dX);
                if(Math.abs(dY) > 1)
                    dY /= Math.abs(dY);
                if(Math.abs(dX) > 1)
                    dZ /= Math.abs(dZ);
                 */

                level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5 + dX * 0.75, pos.getY() + 0.5 + dY * 0.75, pos.getZ() + 0.5 + dZ * 0.75, 0.0, 0.0, 0.0);
            }
        }
    }


    private boolean doesToolIgnite(ItemStack tool) {

        if(tool.isEmpty())
            return false;

        if(tool.getItem() instanceof TieredItem tieredItem)
            return tieredItem.getTier() != Tiers.WOOD;

        return false;
    }

    private static boolean isFire(Block block) {
        return block instanceof FireBlock ||
                block == Blocks.LAVA ||
                block == NTMOresNBlocks.ORE_COAL_OIL_BURNING.get() ||
                block == NTMOresNBlocks.DEEPSLATE_ORE_COAL_OIL_BURNING.get()
                //TODO add burning nether coal ore
                //TODO add smoldering netherrack
        ;
    }
}
