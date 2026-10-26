package net.brnbrd.delightful.common.block;

import com.mojang.serialization.MapCodec;
import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
// import net.minecraftforge.common.PlantType;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

public class CantaloupePlantBlock extends BushBlock implements BonemealableBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(3D, 0D, 3D, 13D, 2D, 13D),
            Block.box(2D, 0D, 2D, 14D, 5D, 14D),
            Block.box(0D, 0D, 0D, 16D, 6D, 16D),
            Block.box(0D, 0D, 0D, 16D, 8D, 16D)
    };
    public static final MapCodec<CantaloupePlantBlock> CODEC = simpleCodec(CantaloupePlantBlock::new);

    public CantaloupePlantBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected @NotNull MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockState state, @NotNull HitResult target, @NotNull LevelReader level, @NotNull BlockPos pos, @NotNull Player player) {
        return Util.getStack(this.isMaxAge(state) ? DelightfulItems.CANTALOUPE : DelightfulItems.CANTALOUPE_SEEDS);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return pState.is(Tags.Blocks.SANDS);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return SHAPE_BY_AGE[pState.getValue(AGE)];
    }

    @Override
    public void tick(BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        if (!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }
    }

    /**
     * @return whether this block needs random ticking.
     */
    @Override
    public boolean isRandomlyTicking(@NotNull BlockState state) {
        return !this.isMaxAge(state);
    }

    @Override
    public void randomTick(BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        int i = pState.getValue(AGE);
        if (
                i < MAX_AGE &&
                        pLevel.getRawBrightness(pPos.above(), 0) >= 8 &&
                        CommonHooks.canCropGrow(pLevel, pPos, pState, pRandom.nextInt(16) == 0)
        ) {
            BlockState blockstate = pState.setValue(AGE, i + 1);
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
            CommonHooks.fireCropGrowPost(pLevel, pPos, pState);
        }
    }

    @Override
    public boolean canSurvive(@NotNull BlockState pState, LevelReader pLevel, BlockPos pPos) {
        TriState soilDecision = pLevel.getBlockState(pPos.below()).canSustainPlant(pLevel, pPos.below(), Direction.UP, this.defaultBlockState());
        if (!soilDecision.isDefault()) {
            return soilDecision.isTrue();
        }
        BlockState blockstate = pLevel.getBlockState(pPos.below());
        if (blockstate.is(Tags.Blocks.SANDS)) {
            BlockPos blockpos = pPos.below();
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (
                        pState.canBeHydrated(pLevel, pPos, pLevel.getFluidState(blockpos.relative(direction)), blockpos.relative(direction)) ||
                                pLevel.getBlockState(blockpos.relative(direction)).is(Blocks.FROSTED_ICE)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        boolean flag = this.isMaxAge(state);
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else if (flag) {
            popResource(level, pos, Util.getStack(DelightfulItems.CANTALOUPE));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = state.setValue(AGE, 0);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hit);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader var1, @NotNull BlockPos var2, @NotNull BlockState var3) {
        return !this.isMaxAge(var3);
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, BlockState pState) {
        pLevel.setBlock(pPos, pState.setValue(AGE, Math.min(MAX_AGE, pState.getValue(AGE) + 1)), 2);
    }

    public boolean isMaxAge(BlockState state) {
        return state.getValue(AGE) >= MAX_AGE;
    }

    @Override
    public @NotNull TriState canSustainPlant(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos soilPosition, @NotNull Direction facing, @NotNull BlockState plant) {
        // TriState.TRUE / FALSE / DEFAULT
        return TriState.DEFAULT;
    }
}
