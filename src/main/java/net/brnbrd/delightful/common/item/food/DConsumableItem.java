package net.brnbrd.delightful.common.item.food;

import net.brnbrd.delightful.common.item.IConfigured;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class DConsumableItem extends ConsumableItem implements IConfigured {
    public DConsumableItem(Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasFoodEffectTooltip, hasCustomTooltip);
    }

    public DConsumableItem(Item.Properties properties) {
        super(properties, false, false);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack p_41421_, @NotNull TooltipContext p_339594_, @NotNull List<Component> p_41423_, @NotNull TooltipFlag p_41424_) {
        this.enabledText(p_41423_);
        super.appendHoverText(p_41421_, p_339594_, p_41423_, p_41424_);
    }
}
