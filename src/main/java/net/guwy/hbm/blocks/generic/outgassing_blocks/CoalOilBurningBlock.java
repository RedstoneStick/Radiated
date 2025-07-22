package net.guwy.hbm.blocks.generic.outgassing_blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CoalOilBurningBlock extends OutgasBlock {
    public CoalOilBurningBlock(Properties properties) {
        super(properties, Blocks.AIR, false); //TODO replace air with carbon monoxide
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        for (Direction dir : Direction.values()) {
            if (dir == Direction.DOWN) continue;

            if (level.getBlockState(pos.relative(dir)).isAir()) {
                double ix = pos.getX() + 0.5f + dir.getStepX() + random.nextDouble() - 0.5;
                double iy = pos.getY() + 0.5f + dir.getStepY() + random.nextDouble() - 0.5;
                double iz = pos.getZ() + 0.5f + dir.getStepZ() + random.nextDouble() - 0.5;

                if (dir.getStepX() != 0)
                    ix = pos.getX() + 0.5f + dir.getStepX() * 0.5 + random.nextDouble() * 0.125 * dir.getStepX();
                if (dir.getStepY() != 0)
                    iy = pos.getY() + 0.5f + dir.getStepY() * 0.5 + random.nextDouble() * 0.125 * dir.getStepY();
                if (dir.getStepZ() != 0)
                    iz = pos.getZ() + 0.5f + dir.getStepZ() * 0.5 + random.nextDouble() * 0.125 * dir.getStepZ();

                level.addParticle(ParticleTypes.FLAME, ix, iy, iz, 0, 0, 0);
                level.addParticle(ParticleTypes.SMOKE, ix, iy, iz, 0, 0, 0);
                level.addParticle(ParticleTypes.SMOKE, ix, iy, iz, 0, 0.1, 0);
            }
        }
    }

    @Override
    protected void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
        level.setBlock(pos, BaseFireBlock.getState(level, pos), 3);

        for (int ix = -2; ix <= 2; ix++) {
            for (int iy = -2; iy <= 2; iy++) {
                for (int iz = -2; iz <= 2; iz++) {

                    BlockPos bPos = pos.offset(ix, iy, iz);
                    if (Math.abs(ix + iy + iz) < 5 && level.getBlockState(bPos).getBlock() == Blocks.AIR) {
                        level.setBlock(bPos, this.gasBlock.defaultBlockState(), 3);
                    }
                }
            }
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity.getRemainingFireTicks() < 3) entity.setRemainingFireTicks(3);
    }
}
