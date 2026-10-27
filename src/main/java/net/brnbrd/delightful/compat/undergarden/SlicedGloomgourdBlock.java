package net.brnbrd.delightful.compat.undergarden;

import net.brnbrd.delightful.common.block.SlicedGourdBlock;
import net.brnbrd.delightful.compat.Modid;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SlicedGloomgourdBlock extends SlicedGourdBlock {
    public SlicedGloomgourdBlock(Properties properties) {
        super(properties, () -> Modid.UGD.loaded() ? Modid.UGD.item("gloomgourd_slice") : Items.AIR);
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state) {
        if (!Modid.UGD.loaded() && Modid.UG.loaded()) {
            return Modid.UG.itemStack("gloomgourd");
        } else {
            return super.getCloneItemStack(level, pos, state);
        }
    }
}