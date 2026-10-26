package net.brnbrd.delightful.common.item;

import net.brnbrd.delightful.compat.Modid;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CompatBlockItem extends BlockItem implements IConfigured {
    private final Modid[] modid;

    public CompatBlockItem(Block block, Item.Properties props, Modid... modid) {
        super(block, props);
        this.modid = modid;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack p_41421_, @NotNull TooltipContext p_339594_, @NotNull List<Component> p_41423_, @NotNull TooltipFlag p_41424_) {
        this.enabledText(p_41423_);
        super.appendHoverText(p_41421_, p_339594_, p_41423_, p_41424_);
    }

    @Override
    public Modid[] getModid() {
        return modid;
    }
}