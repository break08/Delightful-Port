package net.brnbrd.delightful.common.item;

import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.common.item.food.DConsumableItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerItem;

public class DelightfulItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Delightful.MODID);

    public static final DeferredItem<Item> CANTALOUPE_SLICE = registerFood("cantaloupe_slice", Nutrition.CANTALOUPE_SLICE);

    public static DeferredItem<Item> registerFood(String name, FoodProperties food, Item... remainder) {
        if (remainder.length > 0) {
            if (remainder[0].equals(Items.BOWL)) {
                return registerItem(name,
                        () -> new BowlFoodItem((new Item.Properties()).food(food).craftRemainder(Items.BOWL)));
            } else {
                return registerConsumable(name, food, remainder[0], false, false);
            }
        }
        return registerItem(name, () -> new DConsumableItem((new Item.Properties()).food(food)));
    }

    public static DeferredItem<Item> registerConsumable(String name, FoodProperties food, @Nullable Item remainder, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        return registerItem(name,
                () -> new DConsumableItem((new Item.Properties()).food(food).craftRemainder(remainder), hasFoodEffectTooltip, hasCustomTooltip));
    }

    public static DeferredItem<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }
}
