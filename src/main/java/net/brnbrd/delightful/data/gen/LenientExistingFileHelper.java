package net.brnbrd.delightful.data.gen;

import net.minecraft.server.packs.PackType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class LenientExistingFileHelper extends ExistingFileHelper {
    public LenientExistingFileHelper(ExistingFileHelper base) {
        super(java.util.List.of(), java.util.Set.of(), false, null, null);
    }

    @Override
    public boolean exists(ResourceLocation loc, PackType type) {
        return true;
    }

    @Override
    public boolean exists(ResourceLocation loc, PackType type, String suffix, String prefix) {
        return true;
    }
}
