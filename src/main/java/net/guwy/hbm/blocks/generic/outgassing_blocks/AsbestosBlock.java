package net.guwy.hbm.blocks.generic.outgassing_blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class AsbestosBlock extends OutgasBlock{
    public AsbestosBlock(Properties properties, Block gasBlock, int tickRate, boolean onBreak) {
        super(properties, gasBlock, tickRate, onBreak);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        List<Entity> list = level.getEntities(EntityTypeTest.forClass(Entity.class), new AABB(pos.offset(0, 1, 0)), EntitySelector.LIVING_ENTITY_STILL_ALIVE);
        if (!list.isEmpty()) {

            if (level.getBlockState(pos.offset(0, 1, 0)).getBlock() == Blocks.AIR) {
                if (level.random.nextInt(10) == 0) {
                    level.setBlock(pos.offset(0, 1, 0), this.gasBlock.defaultBlockState(), 3);
                }

                for (int i = 0; i < 5; i++) {
                    //TODO replace ash particles with townaura particles
                    level.addParticle(ParticleTypes.ASH, pos.getX() + level.random.nextFloat(), pos.getY() + 1.1, pos.getZ() + level.random.nextFloat(), 0, 0,0);
                }
            }
        }
    }
}
