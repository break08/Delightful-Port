package net.brnbrd.delightful.common.block;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public interface ISliceable {
    IntegerProperty getBitesProperty();

    ItemStack getSliceItem();

    int getMaxBites();

    default int getBaseHeight() { // Height of block before first bite
        return 16;
    }

    default int getFinalHeight() { // Height of sliced block with maximum bites taken (1 remaining)
        return 1;
    }

    default int getSliceSize() {
        return Math.round((float) (getBaseHeight() - getFinalHeight()) / getMaxBites());
    }

    default int getFirstBiteMod() {
        return 0;
    }

    default float getHeight(int bites) {
        int height = getBaseHeight();
        if (bites <= 0) {
            return (float) height;
        } else if (bites == getMaxBites()) {
            return (float) getFinalHeight();
        } else if (getFirstBiteMod() == 0) {
            return (float) (height - (bites * getSliceSize()));
        } else {
            return (float) (height - getFirstBiteMod() - (bites * getSliceSize()));
        }
    }
}