package net.brnbrd.delightful.common.item.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public class BowlFoodItem extends Item {
    public BowlFoodItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);
        if (entity instanceof Player player && player.hasInfiniteMaterials()) {
            return result;
        }
        if (result.isEmpty()) {
            return new ItemStack(Items.BOWL);
        }
        if (entity instanceof Player player) {
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Items.BOWL));
        }
        return result;
    }
}
