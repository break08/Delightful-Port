package net.brnbrd.delightful.common.block;

import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.registry.ModItems;

public class DelightfulBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Delightful.MODID);
    public static final DeferredBlock<Block> MINI_MELON = BLOCKS.register("mini_melon",
            () -> new MiniMelonBlock(Block.Properties.ofFullCopy(Blocks.MELON).noOcclusion()));
    public static final DeferredBlock<Block> SLICED_MINI_MELON = BLOCKS.register("sliced_mini_melon",
            () -> new SlicedMiniMelonBlock(Block.Properties.ofFullCopy(MINI_MELON.get()).noOcclusion(), () -> Items.MELON_SLICE, ModItems.MELON_JUICE));
    public static final DeferredBlock<Block> SLICED_CANTALOUPE = BLOCKS.register("sliced_cantaloupe",
            () -> new SlicedMiniMelonBlock(Block.Properties.ofFullCopy(SLICED_MINI_MELON.get()).noOcclusion(), DelightfulItems.CANTALOUPE_SLICE, null));
    public static final DeferredBlock<Block> CANTALOUPE = BLOCKS.register("cantaloupe",
            () -> new CantaloupeBlock(Block.Properties.ofFullCopy(MINI_MELON.get()).noOcclusion()));
    public static final DeferredBlock<Block> CANTALOUPE_PLANT = BLOCKS.register("cantaloupe_plant",
            () -> new CantaloupePlantBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .pushReaction(PushReaction.DESTROY)
            ));

    public static final DeferredBlock<Block> SALMONBERRY_BUSH = BLOCKS.register("salmonberry_bush",
            () -> new SalmonberryBushBlock(
                    Block.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)
                            .randomTicks()
                            .noCollission()
                            .sound(SoundType.SWEET_BERRY_BUSH)
            ));
}
