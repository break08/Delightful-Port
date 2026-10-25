package net.brnbrd.delightful.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.Properties;
import java.util.function.Supplier;

public class BaklavaBlock extends PieBlock {
    private static final VoxelShape BAKLAVA_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 5.0, 15.0);

    public BaklavaBlock(Properties properties, Supplier<Item> pieSlice) {
        super(properties, pieSlice);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return BAKLAVA_SHAPE;
    }
}
