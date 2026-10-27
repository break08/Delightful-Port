package net.brnbrd.delightful.common.item.food;

import net.brnbrd.delightful.compat.TeaCompat;
import net.brnbrd.delightful.compat.abnormals.NeapolitanCompat;
import net.brnbrd.delightful.compat.brewinandchewin.BrewinChewinCompat;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class Nutrition {
    public static final FoodProperties CHEESEBURGER = (new FoodProperties.Builder())
            .nutrition(11).saturationModifier(0.85F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 1200, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0), 1F).build();
    public static final FoodProperties DELUXE_CHEESEBURGER = (new FoodProperties.Builder())
            .nutrition(13).saturationModifier(1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 4800, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1F).build();
    public static final FoodProperties ROCK_CANDY = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.5F)
            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 600, 1), 0.7F)
            .build();
    public static final FoodProperties MARSHMALLOW_STICK = (new FoodProperties.Builder())
            .nutrition(3).saturationModifier(0.35F)
            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 300, 0), 1F)
            .build();
    public static final FoodProperties COOKED_MARSHMALLOW_STICK = (new FoodProperties.Builder())
            .nutrition(5).saturationModifier(0.35F)
            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0), 1F).build();
    public static final FoodProperties SMORE = (new FoodProperties.Builder())
            .nutrition(8).saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 2400, 0), 1F)
            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 600, 1), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0), 1F).build();
    public static final FoodProperties CRAB_RANGOON = (new FoodProperties.Builder())
            .nutrition(10).saturationModifier(0.5F)
            //.effect(() -> CRCompat.getCorrosionOrResistance(400, 1), 1F)
            .build();
    public static final FoodProperties CHUNKWICH = (new FoodProperties.Builder())
            .nutrition(11).saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 600, 0), 1F).build();
    public static final FoodProperties JAM_JAR = (new FoodProperties.Builder())
            .nutrition(5).saturationModifier(0.3F).build();
    public static final FoodProperties NUT_BUTTER_BOTTLE = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(0.6F).build();

    public static final FoodProperties AGED_ROE = (new FoodProperties.Builder())
            .nutrition(7).saturationModifier(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1F)
            .effect(() -> new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(BrewinChewinCompat.getTipsy()), 300, 0), 1F)
            .effect(() -> BrewinChewinCompat.getIntoxicationOrHalfBadLuck(200, 0), 1F).build();
    public static final FoodProperties CAVIAR = (new FoodProperties.Builder())
            .nutrition(8).saturationModifier(1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 6000, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 900), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 900), 1F)
            .effect(() -> new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(BrewinChewinCompat.getTipsy()), 300, 0), 1F)
            .effect(() -> BrewinChewinCompat.getIntoxicationOrHalfBadLuck(200, 0), 1F).build();


    public static final FoodProperties GLOW_JAM_JAR = (new FoodProperties.Builder())
            .nutrition(5).saturationModifier(0.3F)
            //.effect(() -> new MobEffectInstance(CosmopolitanCompat.getTracer(), 1200, 0), 1F)
            .build();

    public static final FoodProperties ROE_ROLL = (new FoodProperties.Builder())
            .nutrition(8).saturationModifier(0.7F)
            .fast()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1F).build();
    public static final FoodProperties NUT_BUTTER_AND_JAM_SANDWICH = (new FoodProperties.Builder())
            .nutrition(11).saturationModifier(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1F)
            //.effect(() -> new MobEffectInstance(SOBCompat.getToughness(), 1800, 0), 1F)
            .build();
    public static final FoodProperties ROE_BLINI = (new FoodProperties.Builder())
            .nutrition(10).saturationModifier(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1F)
            //.effect(() -> CRCompat.getCorrosionOrResistance(400, 1), 1F)
            .build();
    public static final FoodProperties SALMON_AND_ROE_BLINI = (new FoodProperties.Builder())
            .nutrition(11).saturationModifier(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 6000, 0), 1F)
            //.effect(() -> CRCompat.getCorrosionOrResistance(400, 1), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1200), 1F).build();
    public static final FoodProperties HONEY_GLAZED_WALNUT = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(1F).build();
    public static final FoodProperties ACORN = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 1F).build();
    public static final FoodProperties ROASTED_ACORN = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.5F).build();
    public static final FoodProperties NUT_DOUGH = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build();
    public static final FoodProperties GREEN_TEA_LEAF = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.1F).build();
    public static final FoodProperties ANIMAL_FAT = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(2F)
            //.meat()
            .alwaysEdible()
            .fast().build();
    public static final FoodProperties CHOPPED_CLOVER = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.35F)
            .fast().build();
    public static final FoodProperties CACTUS_FLESH = (new FoodProperties.Builder())
            .nutrition(3).saturationModifier(0.3F).build();
    public static final FoodProperties CACTUS_STEAK = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.5F).build();
    public static final FoodProperties CACTUS_CHILI = (new FoodProperties.Builder())
            .nutrition(10).saturationModifier(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0), 1F).build();
    public static final FoodProperties CACTUS_SOUP = (new FoodProperties.Builder())
            .nutrition(12).saturationModifier(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1F).build();
    public static final FoodProperties CACTUS_SOUP_CUP = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 1800, 0), 1F).build();
    public static final FoodProperties VENISON_STEW = (new FoodProperties.Builder())
            .nutrition(12).saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1F).build();
    public static final FoodProperties VENISON_STEW_CUP = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 1800, 0), 1F).build();
    public static final FoodProperties FIELD_SALAD = (new FoodProperties.Builder())
            .nutrition(10).saturationModifier(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1F).build();
    public static final FoodProperties VENISON_CHOPS = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.3F)
            //.meat()
            .fast().build();

    public static final FoodProperties COOKED_VENISON_CHOPS = (new FoodProperties.Builder())
            .nutrition(3).saturationModifier(0.8F)
            //.meat()
            .fast().build();
    public static final FoodProperties RAW_GOAT = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.3F)
            //.meat()
            .build();
    public static final FoodProperties COOKED_GOAT = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(0.8F)
            //.meat()
            .build();
    public static final FoodProperties CANTALOUPE_SLICE = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1F).build();
    public static final FoodProperties CANTALOUPE_BREAD = (new FoodProperties.Builder())
            .nutrition(9).saturationModifier(0.35F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0), 1F).build();
    public static final FoodProperties WRAPPED_CANTALOUPE = (new FoodProperties.Builder())
            .nutrition(8).saturationModifier(0.95F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0), 1F).build();
    public static final FoodProperties CANTALOUPE_POPSICLE = (new FoodProperties.Builder())
            .nutrition(3).saturationModifier(0.2F)
            .fast()
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1F).build();
    public static final FoodProperties STUFFED_CANTALOUPE = (new FoodProperties.Builder())
            .nutrition(14).saturationModifier(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 4800, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1), 1F).build();
    public static final FoodProperties COCONUT_CURRY = (new FoodProperties.Builder())
            .nutrition(15).saturationModifier(0.9F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1F).build();
    public static final FoodProperties PRICKLY_PEAR_JUICE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 600, 0), 1F)
            //.effect(() -> new MobEffectInstance(SOBCompat.getSpite(), 600, 0), 1F)
            .build();
    public static final FoodProperties LONG_PRICKLY_PEAR_JUICE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1200, 0), 1F).build();
            //.effect(() -> new MobEffectInstance(SOBCompat.getSpite(), 1200, 0), 1F).build();
    public static final FoodProperties LAVENDER_TEA = (new FoodProperties.Builder()).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 600, 0), 1F)
            //.effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 600, 0), 1F)
            .build();
    public static final FoodProperties AZALEA_TEA = (new FoodProperties.Builder()).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 60, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 60, 1), 1F)
            .effect(() -> new MobEffectInstance(TeaCompat.getYellowTeaEffect(), 4800, 1), 1F).build();
    public static final FoodProperties MATCHA_LATTE = (new FoodProperties.Builder()).alwaysEdible()
            .nutrition(6).saturationModifier(0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
            //.effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 400, 1), 1F)
            //.effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 3600, 1), 1F)
            .build();
    public static final FoodProperties BERRY_MATCHA_LATTE = (new FoodProperties.Builder()).alwaysEdible()
            .nutrition(8).saturationModifier(0.65F)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
            //.effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 400, 1), 1F)
            //.effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 3600, 1), 1F)
            .build();
    public static final FoodProperties ENDER_NECTAR = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0F).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
            //.effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 3600, 2), 1F)
            //.effect(() -> new MobEffectInstance(ExquisitoCompat.getResonance(), 500, 0), 1F)
            .effect(() -> new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(BrewinChewinCompat.getTipsy()), 2400, 0), 1F)
            .effect(() -> BrewinChewinCompat.getIntoxicationOrHalfBadLuck(1800, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 60, 0), 1F).build();
    public static final FoodProperties MATCHA_ICE_CREAM = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(0.3F)
            //.effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 500, 1), 1F)
            //.effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 400, 0), 1F)
            .build();
    public static final FoodProperties 	MATCHA_MILKSHAKE = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(1.5F).alwaysEdible()
            //.effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 200, 1), 1F)
            //.effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 300, 0), 1F)
            .build();
    public static final FoodProperties SALMONBERRY_ICE_CREAM = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1200), 1F).build();
    public static final FoodProperties SALMONBERRY_MILKSHAKE = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(1.5F).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600), 1F).build();
    public static final FoodProperties SALMONBERRIES = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 0), 1F).build();
    public static final FoodProperties SALMONBERRY_PIE_SLICE = (new FoodProperties.Builder())
            .nutrition(3).saturationModifier(0.3F)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 1F).build();
    public static final FoodProperties BAKLAVA_SLICE = (new FoodProperties.Builder())
            .nutrition(5).saturationModifier(0.6F)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0, false, false), 1F).build();
    public static final FoodProperties SALMONBERRY_GUMMY = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0F).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 900, 0), 1F).build();
    public static final FoodProperties MATCHA_GUMMY = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0F).alwaysEdible()
            //.effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 100, 2), 1F)
            .build();
    public static final FoodProperties CANTALOUPE_GUMMY = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0F).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 3), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 100, 0), 1F)
            .build();

    public static final FoodProperties GLOW_JAM_COOKIE = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.1F).fast()
            //.effect(() -> new MobEffectInstance(CosmopolitanCompat.getTracer(), 300, 0), 1F)
            .build();
}
