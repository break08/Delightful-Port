package net.brnbrd.delightful.common.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Nutrition {
    public static final FoodProperties CANTALOUPE_SLICE = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1F).build();
}
