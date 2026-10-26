package net.brnbrd.delightful.common.block.old;

import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StemBlock;

// replace the removed MelonBlock class in 1.20.1
public class ModMelonBlock extends ModStemGrownBlock {
    protected ModMelonBlock(Properties properties) {
        super(properties);
    }

    @Override
    public StemBlock getStem() {
        return (StemBlock)Blocks.MELON_STEM;
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) Blocks.ATTACHED_MELON_STEM;
    }
}
