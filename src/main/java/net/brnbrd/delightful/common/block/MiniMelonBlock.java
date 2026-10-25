package net.brnbrd.delightful.common.block;

import net.brnbrd.delightful.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.CommonHooks;
import vectorwing.farmersdelight.common.tag.ModTags;
import org.jetbrains.annotations.NotNull;

public class MiniMelonBlock extends MiniBlock implements BonemealableBlock {
    public MiniMelonBlock(Properties properties) {
        super(properties);
    }

    public void grow(Level level, BlockPos pos) {
        BlockState newState = Blocks.MELON.defaultBlockState();
        level.setBlock(pos, newState, 2);
        CommonHooks.canCropGrow(level, pos, newState, true);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(@NotNull BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (
                level.getRawBrightness(pos, 0) >= 5 &&
                        level.getBlockState(pos.below()).is(Blocks.DIRT) &&
                        CommonHooks.canCropGrow(level, pos, state, random.nextInt(10) == 0)
        ) {
            grow(level, pos);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void performBonemeal(ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        if (!level.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (CommonHooks.canCropGrow(level, pos, state, true)) grow(level, pos);
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (stack.is(ModTags.Items.KNIVES)) {
            if (!level.isClientSide()) {
                SlicedMiniMelonBlock sliced = (SlicedMiniMelonBlock) DelightfulBlocks.SLICED_MINI_MELON.get();
                level.setBlock(pos, sliced.defaultBlockState(), 2);
                Direction direction = hit.getDirection();
                Util.dropOrGive(
                        sliced.getSliceItem(),
                        level,
                        pos,
                        direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : direction,
                        player
                );
                level.playSound(null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1F, 1F);
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide());
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}