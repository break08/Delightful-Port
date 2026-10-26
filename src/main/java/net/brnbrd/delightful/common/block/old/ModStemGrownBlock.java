package net.brnbrd.delightful.common.block.old;

import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;

public abstract class ModStemGrownBlock extends Block {
    public ModStemGrownBlock(Properties p_49795_) {
        super(p_49795_);
    }

    public abstract StemBlock getStem();

    public abstract AttachedStemBlock getAttachedStem();
}
