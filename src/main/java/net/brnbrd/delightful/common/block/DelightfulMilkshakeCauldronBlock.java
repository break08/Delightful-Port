package net.brnbrd.delightful.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class DelightfulMilkshakeCauldronBlock extends LayeredCauldronBlock {
    public static final Predicate<Biome.Precipitation> FALSE = (precipitation) -> false;

    public DelightfulMilkshakeCauldronBlock(Biome.Precipitation precipitation, CauldronInteraction.InteractionMap map, BlockBehaviour.Properties properties) {
        super(precipitation, map, BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON));
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull LevelReader p_304395_, @NotNull BlockPos p_49824_, @NotNull BlockState p_49825_) {
        return new ItemStack(Items.CAULDRON);
    }
}