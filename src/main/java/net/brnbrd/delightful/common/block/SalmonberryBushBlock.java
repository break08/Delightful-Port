package net.brnbrd.delightful.common.block;

import com.mojang.serialization.MapCodec;
import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

public class SalmonberryBushBlock extends BushBlock implements BonemealableBlock {
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3D, 0D, 3D, 13D, 8D, 13D);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1D, 0D, 1D, 15D, 16D, 15D);

    public SalmonberryBushBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected @NotNull MapCodec<? extends BushBlock> codec() {
        return simpleCodec(SalmonberryBushBlock::new);
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull LevelReader p_304395_, @NotNull BlockPos p_49824_, BlockState p_49825_) {
        return p_49825_.getValue(AGE) <= 2 ? Util.getStack(DelightfulItems.SALMONBERRY_PIPS) : DelightfulItems.SALMONBERRIES.get().getDefaultInstance();
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        if (state.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return this.isMaxAge(state) ? super.getShape(state, pLevel, pPos, pContext) : MID_GROWTH_SHAPE;
        }
    }

    @Override
    public boolean isRandomlyTicking(@NotNull BlockState state) {
        return !this.isMaxAge(state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        int i = pState.getValue(AGE);
        if (i < MAX_AGE && pLevel.getRawBrightness(pPos.above(), 0) >= 8) {
            int speed = 20;
            Biome biome = pLevel.getBiome(pPos).value();
            if (pLevel.isRainingAt(pPos) &&
                    biome.getPrecipitationAt(pPos) == Biome.Precipitation.RAIN &&
                    biome.warmEnoughToRain(pPos)) { // Hard raining ON the block
                speed -= 15;
            } else if (pLevel.isRaining()) { // Level just raining
                speed -= 12;
            }
            if (CommonHooks.canCropGrow(pLevel, pPos, pState, pRandom.nextInt(speed) == 0)) {
                BlockState blockstate = pState.setValue(AGE, i + 1);
                pLevel.setBlock(pPos, blockstate, 2);
                pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
                CommonHooks.fireCropGrowPost(pLevel, pPos, pState);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        boolean maxAge = this.isMaxAge(state);
        if (!maxAge && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else if (state.getValue(AGE) > 2) {
            popResource(level, pos, Util.getStack(DelightfulItems.SALMONBERRIES, (maxAge ? 2 + level.random.nextInt(2) : 1)));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = state.setValue(AGE, 1);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return ItemInteractionResult.sidedSuccess(level.isClientSide());
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hit);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
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
    public TriState canSustainPlant(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos soilPosition, @NotNull Direction facing, @NotNull BlockState plant) {
        // TriState.TRUE / FALSE / DEFAULT
        return TriState.DEFAULT;
    }
}
