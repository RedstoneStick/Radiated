package net.guwy.radiated.content.blocks.machines.rtg;

import net.guwy.radiated.index.RDTBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class RTGBlock extends BaseEntityBlock {
    public RTGBlock(Properties pProperties) {
        super(pProperties);
    }

    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty WEST = BooleanProperty.create("west");

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(NORTH);
        pBuilder.add(SOUTH);
        pBuilder.add(EAST);
        pBuilder.add(WEST);
    }

    /** Sets the default BlockStates for this block **/
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState()
                .setValue(NORTH, false)
                .setValue(SOUTH, false)
                .setValue(EAST, false)
                .setValue(WEST, false);
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, level, pos, neighbor);

        setConnections(state, (Level) level, pos);
    }

    public static void setConnections(BlockState state, Level level, BlockPos pos){
        if(!level.isClientSide()){

            Level pLevel = level;
            BlockEntity blockEntity = pLevel.getBlockEntity(pos);
            boolean north = false, south = false, east = false, west = false;

            if(blockEntity != null){
                BlockEntity neighbourEntity;

                neighbourEntity = pLevel.getBlockEntity(blockEntity.getBlockPos().relative(Direction.NORTH));
                if(neighbourEntity != null) north = neighbourEntity.getCapability(ForgeCapabilities.ENERGY, Direction.NORTH.getOpposite()).isPresent();

                neighbourEntity = pLevel.getBlockEntity(blockEntity.getBlockPos().relative(Direction.SOUTH));
                if(neighbourEntity != null) south = neighbourEntity.getCapability(ForgeCapabilities.ENERGY, Direction.SOUTH.getOpposite()).isPresent();

                neighbourEntity = pLevel.getBlockEntity(blockEntity.getBlockPos().relative(Direction.EAST));
                if(neighbourEntity != null) east = neighbourEntity.getCapability(ForgeCapabilities.ENERGY, Direction.EAST.getOpposite()).isPresent();

                neighbourEntity = pLevel.getBlockEntity(blockEntity.getBlockPos().relative(Direction.WEST));
                if(neighbourEntity != null) west = neighbourEntity.getCapability(ForgeCapabilities.ENERGY, Direction.WEST.getOpposite()).isPresent();
            }

            pLevel.setBlock(pos, state
                            .setValue(NORTH, north)
                            .setValue(SOUTH, south)
                            .setValue(EAST, east)
                            .setValue(WEST, west)
                    , 11);
        }
    }

    /* BLOCK ENTITY */

    @Override
    public @NotNull RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof RTGBlockEntity) {
                ((RTGBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof RTGBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (RTGBlockEntity)entity, pPos);
                RTGBlockEntity.onUse(pLevel, pPos, pState, pPlayer);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RTGBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
                                                                  BlockEntityType<T> type) {
        return createTickerHelper(type, RDTBlockEntities.RTG.get(),
                RTGBlockEntity::tick);
    }


}
