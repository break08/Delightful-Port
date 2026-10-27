package net.brnbrd.delightful.compat.ars_nouveau;

import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.compat.Modid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ArsNouveauCompat {
    public static MobEffect getManaRegen() {
        return Util.effect(Modid.AN, "mana_regen", MobEffects.ABSORPTION.value());
    }

    public static final FoodProperties SOURCE_BERRY_PIE_SLICE = (new FoodProperties.Builder())
            .nutrition(3).saturationModifier(0.3F).fast()
            .effect(() -> new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(getManaRegen()), 300, 1), 1F).build();

    public static final FoodProperties SOURCE_BERRY_COOKIE = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.1F).fast()
            .effect(() -> new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(getManaRegen()), 60, 0), 1F).build();

    public static final FoodProperties SOURCE_BERRY_ICE_CREAM = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(getManaRegen()), 1200, 0), 1F).build();

    public static final FoodProperties SOURCE_BERRY_MILKSHAKE = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(1.5F).alwaysEdible()
            .effect(() -> new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(getManaRegen()), 600, 0), 1F).build();

    public static final FoodProperties SOURCE_BERRY_GUMMY = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0F).alwaysEdible()
            .effect(() -> new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(getManaRegen()), 80, 2), 1F).build();
}
