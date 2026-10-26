package net.brnbrd.delightful.common.block;

import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class WildSalmonberriesBlock extends WildCropBlock {
    public WildSalmonberriesBlock() {
        super(MobEffects.REGENERATION, 6, BlockBehaviour.Properties.ofFullCopy(ModBlocks.WILD_BEETROOTS.get()));
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack itemInHand, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        if (itemInHand.is(Tags.Items.TOOLS_SHEAR))  {
            this.pickBerries(level, pos, player, itemInHand, hand, true);
            return ItemInteractionResult.sidedSuccess(level.isClientSide());
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hit) {
        this.pickBerries(level, pos, player, ItemStack.EMPTY, InteractionHand.MAIN_HAND, false);
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    private void pickBerries(Level level, BlockPos pos, Player player, ItemStack itemInHand, InteractionHand hand, boolean isShears) {
        popResource(level, pos, Util.getStack(DelightfulItems.SALMONBERRIES, isShears ? 2 : 1));
        level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1F, 0.8F + level.random.nextFloat() * 0.4F);
        if (isShears) itemInHand.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
        final BlockState newState = this.getPickedBushState();
        level.setBlock(pos, newState, 2);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
    }

    private BlockState getPickedBushState() {
        return DelightfulBlocks.SALMONBERRY_BUSH.get()
                .defaultBlockState()
                .setValue(SalmonberryBushBlock.AGE, 1);
    }
}