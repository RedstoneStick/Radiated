package net.guwy.hbm.blocks.generic.outgassing_blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class OutgasBlock extends Block {
    protected Block gasBlock;
    int tickRate;
    boolean onBreak;
    boolean onNeighbour;

    public OutgasBlock(Properties properties, Block gasBlock, int tickRate, boolean onBreak, boolean onNeighbour) {
        super(properties);
        this.gasBlock = gasBlock;
        this.tickRate = tickRate;
        this.onBreak = onBreak;
        this.onNeighbour = onNeighbour;
    }
    public OutgasBlock(Properties properties, Block gasBlock, int tickRate, boolean onBreak) {
        this(properties, gasBlock, tickRate, onBreak, false);
    }
    public OutgasBlock(Properties properties, Block gasBlock, boolean onBreak) {
        this(properties, gasBlock, 1, onBreak, false);
    }

    /* TODO
    protected Block getGas() {
        if(this == ModBlocks.ore_uranium || this == ModBlocks.ore_uranium_scorched ||
                this == ModBlocks.ore_gneiss_uranium || this == ModBlocks.ore_gneiss_uranium_scorched ||
                this == ModBlocks.ore_nether_uranium || this == ModBlocks.ore_nether_uranium_scorched) {
            return ModBlocks.gas_radon;
        }

        if(this == ModBlocks.block_corium_cobble)
            return ModBlocks.gas_radon;

        if(this == ModBlocks.ancient_scrap)
            return ModBlocks.gas_radon_tomb;

        if(this == ModBlocks.ore_coal_oil_burning || this == ModBlocks.ore_nether_coal) {
            return ModBlocks.gas_monoxide;
        }

        if(this == ModBlocks.ore_asbestos || this == ModBlocks.ore_gneiss_asbestos ||
                this == ModBlocks.block_asbestos || this == ModBlocks.deco_asbestos ||
                this == ModBlocks.brick_asbestos || this == ModBlocks.tile_lab ||
                this == ModBlocks.tile_lab_cracked || this == ModBlocks.tile_lab_broken) {
            return ModBlocks.gas_asbestos;
        }

        return Blocks.air;
    }
     */

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        level.scheduleTick(pos, this, this.tickRate);
    }


    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!this.isRandomlyTicking) {

            Direction dir = Direction.from3DDataValue(random.nextInt(6));

            if (level.getBlockState(pos.relative(dir)).getBlock() == Blocks.AIR) {
                level.setBlock(pos.relative(dir), this.gasBlock.defaultBlockState(), 3);
            }

            level.scheduleTick(pos, this, this.tickRate);
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        Direction dir = Direction.from3DDataValue(random.nextInt(6));

        if (level.getBlockState(pos.relative(dir)).getBlock() == Blocks.AIR) {
            level.setBlock(pos.relative(dir), this.gasBlock.defaultBlockState(), 3);
        }
    }


    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (this.onBreak)
            level.setBlock(pos, this.gasBlock.defaultBlockState(), 3);

        super.onRemove(state, level, pos, newState, movedByPiston);
    }


    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {

        if (this.onNeighbour)
            for (Direction dir : Direction.values())
                if (level.getBlockState(pos.relative(dir)).getBlock() == Blocks.AIR)
                    level.setBlock(pos.relative(dir), this.gasBlock.defaultBlockState(), 3);

        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
    }
}
