package net.brnbrd.delightful.common.item;

import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.common.block.AcornSackItem;
import net.brnbrd.delightful.common.block.CookieTilesItem;
import net.brnbrd.delightful.common.block.DelightfulBlocks;
import net.brnbrd.delightful.common.item.food.*;
import net.brnbrd.delightful.common.item.knife.FurnaceFuelItem;
import net.brnbrd.delightful.compat.*;
import net.brnbrd.delightful.compat.abnormals.AquaticCompat;
import net.brnbrd.delightful.compat.abnormals.AtmosphericCompat;
import net.brnbrd.delightful.compat.ars_nouveau.*;
import net.brnbrd.delightful.compat.brewinandchewin.BrewinChewinCompat;
import net.brnbrd.delightful.compat.undergarden.UndergardenCompat;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.PlaceableItem;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;
import java.util.function.Supplier;


public class DelightfulItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Delightful.MODID);

    public static final DeferredItem<Item> QUARTZ_CABINET = registerItem("quartz_cabinet",
            () -> new BlockItem(DelightfulBlocks.QUARTZ_CABINET.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> BASALT_CABINET = registerItem("basalt_cabinet",
            () -> new BlockItem(DelightfulBlocks.BASALT_CABINET.get(), ModItems.basicItem()));

    public static final DeferredItem<Item> SALMONBERRY_SACK = registerItem("salmonberry_sack", () ->
            new BlockItem(DelightfulBlocks.SALMONBERRY_SACK.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> ACORN_SACK = registerItem("acorn_sack", () ->
            new AcornSackItem(DelightfulBlocks.ACORN_SACK.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> MENDOSTEEN_CRATE = registerItem("mendosteen_crate", () ->
            new ArsCrateBlockItem(DelightfulBlocks.MENDOSTEEN_CRATE.get(), (new Item.Properties())));
    public static final DeferredItem<Item> BASTION_FRUIT_CRATE = registerItem("bastion_fruit_crate", () ->
            new ArsCrateBlockItem(DelightfulBlocks.BASTION_FRUIT_CRATE.get(), (new Item.Properties())));
    public static final DeferredItem<Item> FROSTAYA_CRATE = registerItem("frostaya_crate", () ->
            new ArsCrateBlockItem(DelightfulBlocks.FROSTAYA_CRATE.get(), (new Item.Properties())));
    public static final DeferredItem<Item> BOMBEGRANATE_CRATE = registerItem("bombegranate_crate", () ->
            new ArsCrateBlockItem(DelightfulBlocks.BOMBEGRANATE_CRATE.get(), (new Item.Properties())));
    public static final DeferredItem<Item> BLUEBERRY_SACK = registerItem("blueberry_sack", () ->
            new CompatBlockItem(DelightfulBlocks.BLUEBERRY_SACK.get(), (new Item.Properties()), Modid.BWG));
    public static final DeferredItem<Item> GREEN_APPLE_CRATE = registerItem("green_apple_crate", () ->
            new CompatBlockItem(DelightfulBlocks.GREEN_APPLE_CRATE.get(), (new Item.Properties()), Modid.BWG));
    public static final DeferredItem<Item> YUCCA_FRUIT_CRATE = registerItem("yucca_fruit_crate", () ->
            new CompatBlockItem(DelightfulBlocks.YUCCA_FRUIT_CRATE.get(), (new Item.Properties()), Modid.BWG));
    public static final DeferredItem<Item> BAOBAB_FRUIT_CRATE = registerItem("baobab_fruit_crate", () ->
            new CompatBlockItem(DelightfulBlocks.BAOBAB_FRUIT_CRATE.get(), (new Item.Properties()), Modid.BWG));

    public static final DeferredItem<Item> GLOW_JAM_COOKIE_TILES = registerItem("glow_jam_cookie_tiles", () ->
            new CookieTilesItem(DelightfulBlocks.GLOW_JAM_COOKIE_TILES.get(), (new Item.Properties())));
    public static final DeferredItem<Item> GLOW_JAM_COOKIE_TILE_STAIRS = registerItem("glow_jam_cookie_tile_stairs", () ->
            new CookieTilesItem(DelightfulBlocks.GLOW_JAM_COOKIE_TILE_STAIRS.get(), (new Item.Properties())));
    public static final DeferredItem<Item> GLOW_JAM_COOKIE_TILE_SLAB = registerItem("glow_jam_cookie_tile_slab", () ->
            new CookieTilesItem(DelightfulBlocks.GLOW_JAM_COOKIE_TILE_SLAB.get(), (new Item.Properties())));
    public static final DeferredItem<Item> GLOW_JAM_COOKIE_TILE_WALL = registerItem("glow_jam_cookie_tile_wall", () ->
            new CookieTilesItem(DelightfulBlocks.GLOW_JAM_COOKIE_TILE_WALL.get(), (new Item.Properties())));
    public static final DeferredItem<Item> SOURCE_BERRY_COOKIE_TILES = registerItem("source_berry_cookie_tiles", () ->
            new CookieTilesItem(DelightfulBlocks.SOURCE_BERRY_COOKIE_TILES.get(), (new Item.Properties()), Modid.AN));
    public static final DeferredItem<Item> SOURCE_BERRY_COOKIE_TILE_STAIRS = registerItem("source_berry_cookie_tile_stairs", () ->
            new CookieTilesItem(DelightfulBlocks.SOURCE_BERRY_COOKIE_TILE_STAIRS.get(), (new Item.Properties()), Modid.AN));
    public static final DeferredItem<Item> SOURCE_BERRY_COOKIE_TILE_SLAB = registerItem("source_berry_cookie_tile_slab", () ->
            new CookieTilesItem(DelightfulBlocks.SOURCE_BERRY_COOKIE_TILE_SLAB.get(), (new Item.Properties()), Modid.AN));
    public static final DeferredItem<Item> SOURCE_BERRY_COOKIE_TILE_WALL = registerItem("source_berry_cookie_tile_wall", () ->
            new CookieTilesItem(DelightfulBlocks.SOURCE_BERRY_COOKIE_TILE_WALL.get(), (new Item.Properties()), Modid.AN));

    public static final DeferredItem<Item> MATCHA_ICE_CREAM_BLOCK = registerItem("matcha_ice_cream_block", () ->
            new CompatBlockItem(DelightfulBlocks.MATCHA_ICE_CREAM_BLOCK.get(), (new Item.Properties()), Modid.N));
    public static final DeferredItem<Item> SALMONBERRY_ICE_CREAM_BLOCK = registerItem("salmonberry_ice_cream_block", () ->
            new CompatBlockItem(DelightfulBlocks.SALMONBERRY_ICE_CREAM_BLOCK.get(), (new Item.Properties()), Modid.N));
    public static final DeferredItem<Item> SOURCE_BERRY_ICE_CREAM_BLOCK = registerItem("source_berry_ice_cream_block", () ->
            new SourceBerryIceCreamBlockItem(DelightfulBlocks.SOURCE_BERRY_ICE_CREAM_BLOCK.get(), (new Item.Properties())));

    public static final DeferredItem<Item> MATCHA_ICE_CREAM = registerItem("matcha_ice_cream",
            () -> new IceCreamItem((new Item.Properties()).food(Nutrition.MATCHA_ICE_CREAM)));
    public static final DeferredItem<Item> SALMONBERRY_ICE_CREAM = registerItem("salmonberry_ice_cream",
            () -> new IceCreamItem((new Item.Properties()).food(Nutrition.SALMONBERRY_ICE_CREAM)));
    public static final DeferredItem<Item> SOURCE_BERRY_ICE_CREAM = registerItem("source_berry_ice_cream",
            () -> new SourceBerryIceCreamItem((new Item.Properties()).food(ArsNouveauCompat.SOURCE_BERRY_ICE_CREAM)));
    public static final DeferredItem<Item> MATCHA_MILKSHAKE = registerItem("matcha_milkshake",
            () -> new ShakeItem(new Item.Properties().food(Nutrition.MATCHA_MILKSHAKE)));
    public static final DeferredItem<Item> SALMONBERRY_MILKSHAKE = registerItem("salmonberry_milkshake",
            () -> new ShakeItem(new Item.Properties().food(Nutrition.SALMONBERRY_MILKSHAKE)));
    public static final DeferredItem<Item> SOURCE_BERRY_MILKSHAKE = registerItem("source_berry_milkshake",
            () -> new SourceBerryShakeItem(new Item.Properties().food(ArsNouveauCompat.SOURCE_BERRY_MILKSHAKE)));
    public static final DeferredItem<Item> GREEN_TEA_LEAF = registerItem("green_tea_leaf", () -> new GreenTeaLeavesItem(new Item.Properties().food(Nutrition.GREEN_TEA_LEAF)));
    public static final DeferredItem<Item> MATCHA = registerItem("matcha", () -> new MatchaItem(new Item.Properties()));
    public static final DeferredItem<Item> SALMONBERRIES = registerFood("salmonberries", Nutrition.SALMONBERRIES);
    public static final DeferredItem<Item> SALMONBERRY_PIPS = registerItem("salmonberry_pips",
            () -> new ItemNameBlockItem(DelightfulBlocks.SALMONBERRY_BUSH.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> WILD_SALMONBERRIES = registerItem("wild_salmonberries",
            () -> new BlockItem(DelightfulBlocks.WILD_SALMONBERRIES.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> SALMONBERRY_PIE = registerItem("salmonberry_pie",
            () -> new PlaceableItem(DelightfulBlocks.SALMONBERRY_PIE.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> SALMONBERRY_PIE_SLICE = registerItem("salmonberry_pie_slice",
            () -> new DConsumableItem((new Item.Properties()).food(Nutrition.SALMONBERRY_PIE_SLICE), true, false));
    public static final DeferredItem<Item> GLOOMGOURD_PIE_SLICE = registerCompatPieSlice("gloomgourd_pie",
            UndergardenCompat.GLOOMGOURD_PIE_SLICE.get(), Modid.UG);
    public static final DeferredItem<Item> BLUEBERRY_PIE_SLICE = registerCompatPieSlice(BWGCompat.blueberry_pie,
            FoodValues.PIE_SLICE, Modid.BWG);
    public static final DeferredItem<Item> GREEN_APPLE_PIE_SLICE = registerCompatPieSlice(BWGCompat.green_apple_pie,
            BWGCompat.GREEN_APPLE_PIE_SLICE.get(), Modid.BWG);
    public static final DeferredItem<Item> MULBERRY_PIE_SLICE = registerCompatPieSlice(AquaticCompat.mulberry_pie,
            AquaticCompat.MULBERRY_PIE_SLICE, Modid.UA);
    public static final DeferredItem<Item> PASSION_FRUIT_TART_SLICE = registerCompatPieSlice("passion_fruit_tart",
            AtmosphericCompat.PASSION_FRUIT_TART_SLICE, Modid.AT);
    public static final DeferredItem<Item> MUTTON_PIE_SLICE = registerCompatPieSlice(WindsweptCompat.MUTTON_PIE,
            FoodValues.PIE_SLICE, Modid.WS);
    public static final DeferredItem<Item> CHORUS_PIE_SLICE = registerCompatPieSlice(UnusualEndCompat.chorus_pie,
            UnusualEndCompat.CHORUS_PIE_SLICE, Modid.UE);
    public static final DeferredItem<Item> CHORUS_MUFFIN = registerItem("chorus_muffin",
            () -> new ChorusMuffinItem((new Item.Properties()).food(UnusualEndCompat.CHORUS_MUFFIN)));
    public static final DeferredItem<Item> SOURCE_BERRY_PIE_SLICE = registerItem("source_berry_pie_slice",
            () -> new SourceBerryPieSliceItem((new Item.Properties()).food(ArsNouveauCompat.SOURCE_BERRY_PIE_SLICE)));
    public static final DeferredItem<Item> SOURCE_BERRY_COOKIE = registerItem("source_berry_cookie",
            () -> new SourceBerryCookieItem((new Item.Properties()).food(ArsNouveauCompat.SOURCE_BERRY_COOKIE)));
    public static final DeferredItem<Item> GLOW_JAM_COOKIE = registerItem("glow_jam_cookie",
            () -> new ConsumableItem((new Item.Properties()).food(Nutrition.GLOW_JAM_COOKIE), true, false));
    public static final DeferredItem<Item> BAKLAVA = registerItem("baklava",
            () -> new PlaceableItem(DelightfulBlocks.BAKLAVA.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> BAKLAVA_SLICE = registerItem("baklava_slice",
            () -> new DConsumableItem((new Item.Properties()).food(Nutrition.BAKLAVA_SLICE), true, false));
    public static final DeferredItem<Item> ANIMAL_FAT = registerFood("animal_fat", Nutrition.ANIMAL_FAT);
    public static final DeferredItem<Item> ANIMAL_OIL_BOTTLE = registerItem("animal_oil_bottle",
            () -> new FurnaceFuelItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE), 3200));
    public static final DeferredItem<Item> ACORN = registerItem("acorn", () ->
            new AcornItem((new Item.Properties()).food(Nutrition.ACORN)));
    public static final DeferredItem<Item> ROASTED_ACORN = registerFood("roasted_acorn", Nutrition.ROASTED_ACORN);
    public static final DeferredItem<Item> NUT_DOUGH = registerFood("nut_dough", Nutrition.NUT_DOUGH);
    public static final DeferredItem<Item> CHOPPED_CLOVER = registerItem("chopped_clover", () -> new ChoppedCloverItem((new Item.Properties()).food(Nutrition.CHOPPED_CLOVER)));
    public static final DeferredItem<Item> CACTUS_FLESH = registerFood("cactus_flesh", Nutrition.CACTUS_FLESH);
    public static final DeferredItem<Item> CACTUS_STEAK = registerFood("cactus_steak", Nutrition.CACTUS_STEAK);
    public static final DeferredItem<Item> CACTUS_CHILI = registerItem("cactus_chili", () -> new DConsumableItem((new Item.Properties()).food(Nutrition.CACTUS_CHILI).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final DeferredItem<Item> CACTUS_SOUP = registerItem("cactus_soup", () -> new DConsumableItem((new Item.Properties()).food(Nutrition.CACTUS_SOUP).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final DeferredItem<Item> CACTUS_SOUP_CUP = registerItem("cactus_soup_cup", () -> new CupItem((new Item.Properties()).food(Nutrition.CACTUS_SOUP_CUP), true, false));
    public static final DeferredItem<Item> VENISON_STEW = registerItem("venison_stew", () -> new VenisonStewItem((new Item.Properties()).food(Nutrition.VENISON_STEW).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final DeferredItem<Item> VENISON_STEW_CUP = registerItem("venison_stew_cup", () -> new VenisonStewCupItem((new Item.Properties()).food(Nutrition.VENISON_STEW_CUP), true, false));
    public static final DeferredItem<Item> SINIGANG = registerItem("sinigang", () -> new ConsumableItem((new Item.Properties()).food(Nutrition.SINIGANG).craftRemainder(Items.BOWL).stacksTo(16), true, false));
    public static final DeferredItem<Item> SINIGANG_CUP = registerItem("sinigang_cup", () -> new CupItem((new Item.Properties()).food(Nutrition.SINIGANG_CUP), true, false));
    public static final DeferredItem<Item> COCONUT_CURRY = registerItem("coconut_curry",
            () -> new CoconutCurryItem((new Item.Properties()).food(Nutrition.COCONUT_CURRY).stacksTo(16).craftRemainder(Items.BOWL)));
    public static final DeferredItem<Item> FIELD_SALAD = registerItem("field_salad",
            () -> new DConsumableItem((new Item.Properties()).food(Nutrition.FIELD_SALAD).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final DeferredItem<Item> MATCHA_LATTE = registerItem("matcha_latte",
            () -> new DrinkItem((new Item.Properties()).food(Nutrition.MATCHA_LATTE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, false));
    public static final DeferredItem<Item> BERRY_MATCHA_LATTE = registerItem("berry_matcha_latte",
            () -> new DrinkItem((new Item.Properties()).food(Nutrition.BERRY_MATCHA_LATTE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, false));
    public static final DeferredItem<Item> ENDER_NECTAR = registerItem("ender_nectar", () ->
            Modid.BC.loaded() ?
                    BrewinChewinCompat.getEnderNectar() :
                    new EnderNectarItem((new Item.Properties()).food(Nutrition.ENDER_NECTAR).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    public static final DeferredItem<Item> AZALEA_TEA = registerItem("azalea_tea",
            () -> new AzaleaTeaItem((new Item.Properties()).food(Nutrition.AZALEA_TEA)));
    public static final DeferredItem<Item> LAVENDER_TEA = registerItem("lavender_tea",
            () -> new LavenderTeaItem((new Item.Properties()).food(Nutrition.LAVENDER_TEA)));
    public static final DeferredItem<Item> PRICKLY_PEAR_JUICE = registerItem("prickly_pear_juice",
            () -> new PricklyPearJuiceItem((new Item.Properties()).food(Nutrition.PRICKLY_PEAR_JUICE).craftRemainder(Items.GLASS_BOTTLE)));
    public static final DeferredItem<Item> LONG_PRICKLY_PEAR_JUICE = registerItem("long_prickly_pear_juice",
            () -> new PricklyPearJuiceItem((new Item.Properties()).food(Nutrition.LONG_PRICKLY_PEAR_JUICE).craftRemainder(Items.GLASS_BOTTLE), Modid.FR));
    public static final DeferredItem<Item> JAM_JAR = registerItem("jam_jar",
            () -> new JamJarItem((new Item.Properties()).food(Nutrition.JAM_JAR).craftRemainder(Items.GLASS_BOTTLE), false, false));
    public static final DeferredItem<Item> GLOW_JAM_JAR = registerItem("glow_jam_jar",
            () -> new JamJarItem((new Item.Properties()).food(Nutrition.GLOW_JAM_JAR).craftRemainder(Items.GLASS_BOTTLE), true, false));
    public static final DeferredItem<Item> NUT_BUTTER_BOTTLE = registerItem("nut_butter_bottle", () -> new NutButterBottleItem(((new Item.Properties()).food(Nutrition.NUT_BUTTER_BOTTLE).craftRemainder(Items.GLASS_BOTTLE))));
    public static final DeferredItem<Item> AGED_ROE = registerItem("aged_roe", () ->
            Modid.BC.loaded() && Modid.LFL.loaded() ?
                    BrewinChewinCompat.getAgedRoe() :
                    new CompatConsumableItem((new Item.Properties()).stacksTo(16).food(Nutrition.AGED_ROE).craftRemainder(Items.GLASS_BOTTLE), false, false, Mods.Strategy.AND, Modid.BC, Modid.LFL)
    );
    public static final DeferredItem<Item> CAVIAR = registerItem("caviar", () ->
            Modid.BC.loaded() && Modid.LFL.loaded() && Modid.TIDE.loaded() ?
                    BrewinChewinCompat.getCaviar() :
                    new CompatConsumableItem((new Item.Properties()).stacksTo(16).food(Nutrition.CAVIAR).craftRemainder(Items.GLASS_BOTTLE), false, false, Mods.Strategy.AND, Modid.BC, Modid.LFL, Modid.TIDE)
    );
    public static final DeferredItem<Item> ROE_ROLL = registerCompatFood("roe_roll", Nutrition.ROE_ROLL, true, Modid.BC, Modid.LFL);
    public static final DeferredItem<Item> ROE_BLINI = registerItem("roe_blini", () -> new RoeBliniItem((new Item.Properties()).food(Nutrition.ROE_BLINI)));
    public static final DeferredItem<Item> SALMON_AND_ROE_BLINI = registerItem("salmon_and_roe_blini", () -> new RoeBliniItem((new Item.Properties()).food(Nutrition.SALMON_AND_ROE_BLINI)));
    public static final DeferredItem<Item> CRAB_RANGOON = registerItem("crab_rangoon",
            () -> new CrabRangoonItem(new Item.Properties().food(Nutrition.CRAB_RANGOON), true));
    public static final DeferredItem<Item> NUT_BUTTER_AND_JAM_SANDWICH = registerItem("nut_butter_and_jam_sandwich", () -> new NutButterJamSandwichItem((new Item.Properties()).food(Nutrition.NUT_BUTTER_AND_JAM_SANDWICH)));
    public static final DeferredItem<Item> CHEESEBURGER = registerItem("cheeseburger", () -> new CheeseburgerItem((new Item.Properties()).food(Nutrition.CHEESEBURGER)));
    public static final DeferredItem<Item> DELUXE_CHEESEBURGER = registerConsumable("deluxe_cheeseburger", Nutrition.DELUXE_CHEESEBURGER, null, true, false);
    public static final DeferredItem<Item> CHUNKWICH = registerCompatFood("chunkwich", Nutrition.CHUNKWICH, true, Modid.RL);
    public static final DeferredItem<Item> ROCK_CANDY = registerItem("rock_candy",
            () -> new RockCandyItem((new Item.Properties()).food(Nutrition.ROCK_CANDY).stacksTo(16).craftRemainder(Items.STICK)));
    public static final DeferredItem<Item> MARSHMALLOW_STICK = registerItem("marshmallow_stick",
            () -> new MarshmallowStickItem((new Item.Properties()).food(Nutrition.MARSHMALLOW_STICK).stacksTo(16).craftRemainder(Items.STICK), true));
    public static final DeferredItem<Item> COOKED_MARSHMALLOW_STICK = registerItem("cooked_marshmallow_stick",
            () -> new MarshmallowStickItem((new Item.Properties()).food(Nutrition.COOKED_MARSHMALLOW_STICK).stacksTo(16).craftRemainder(Items.STICK), true));
    public static final DeferredItem<Item> SMORE = registerConsumable("smore", Nutrition.SMORE, null, true, false);
    public static final DeferredItem<Item> HONEY_GLAZED_WALNUT = registerItem("honey_glazed_walnut",
            () -> new HoneyGlazedWalnutItem(new Item.Properties().food(Nutrition.HONEY_GLAZED_WALNUT)));
    public static final DeferredItem<Item> VENISON_CHOPS = registerItem("venison_chops",
            () -> new VenisonChopsItem(new Item.Properties().food(Nutrition.VENISON_CHOPS)));
    public static final DeferredItem<Item> COOKED_VENISON_CHOPS = registerItem("cooked_venison_chops",
            () -> new VenisonChopsItem(new Item.Properties().food(Nutrition.COOKED_VENISON_CHOPS)));
    public static final DeferredItem<Item> RAW_GOAT = registerItem("raw_goat",
            () -> new GoatMeatItem(new Item.Properties().food(Nutrition.RAW_GOAT)));
    public static final DeferredItem<Item> COOKED_GOAT = registerItem("cooked_goat",
            () -> new GoatMeatItem(new Item.Properties().food(Nutrition.COOKED_GOAT)));
    public static final DeferredItem<Item> MINI_MELON = registerItem("mini_melon", () ->
            new BlockItem(DelightfulBlocks.MINI_MELON.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> CANTALOUPE = registerItem("cantaloupe", () ->
            new BlockItem(DelightfulBlocks.CANTALOUPE.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> CANTALOUPE_SEEDS = registerItem("cantaloupe_seeds",
            () -> new ItemNameBlockItem(DelightfulBlocks.CANTALOUPE_PLANT.get(), ModItems.basicItem()));
    public static final DeferredItem<Item> CANTALOUPE_SLICE = registerFood("cantaloupe_slice", Nutrition.CANTALOUPE_SLICE);
    public static final DeferredItem<Item> CANTALOUPE_BREAD = registerConsumable("cantaloupe_bread", Nutrition.CANTALOUPE_BREAD, null, true, false);
    public static final DeferredItem<Item> WRAPPED_CANTALOUPE = registerConsumable("wrapped_cantaloupe", Nutrition.WRAPPED_CANTALOUPE, null, true, false);
    public static final DeferredItem<Item> CANTALOUPE_POPSICLE = registerConsumable("cantaloupe_popsicle", Nutrition.CANTALOUPE_POPSICLE, Items.STICK, true, false);
    public static final DeferredItem<Item> STUFFED_CANTALOUPE_BLOCK = registerItem("stuffed_cantaloupe_block",
            () -> new PlaceableItem(DelightfulBlocks.STUFFED_CANTALOUPE_BLOCK.get(), ModItems.basicItem().stacksTo(1)));
    public static final DeferredItem<Item> STUFFED_CANTALOUPE = registerConsumable("stuffed_cantaloupe", Nutrition.STUFFED_CANTALOUPE, Items.BOWL, true, false);

    // Gummies

    /*
    public static final DeferredItem<Item> SALMONBERRY_GUMMY = registerItem("salmonberry_gummy", () ->
            new GummyItem((new Item.Properties()).food(Nutrition.SALMONBERRY_GUMMY)));
    public static final DeferredItem<Item> MATCHA_GUMMY = registerItem("matcha_gummy", () ->
            new GummyItem((new Item.Properties()).food(Nutrition.MATCHA_GUMMY)));
    public static final DeferredItem<Item> CANTALOUPE_GUMMY = registerItem("cantaloupe_gummy", () ->
            new GummyItem((new Item.Properties()).food(Nutrition.CANTALOUPE_GUMMY)));
    public static final DeferredItem<Item> SOURCE_BERRY_GUMMY = registerItem("source_berry_gummy", () ->
            new SourceBerryGummyItem((new Item.Properties()).food(ArsNouveauCompat.SOURCE_BERRY_GUMMY)));

     */

    // Roe
    /*
    public static final DeferredItem<Item> STURGEON_ROE = registerItem("sturgeon_roe", () ->
            Modid.LFL.loaded() ?
                    LetFishLoveCompat.sturgeonRoeItem() :
                    new CompatItem(new Item.Properties(), Modid.LFL)
    );

     */

    // Debug Items
    public static final DeferredItem<Item> DEBUG_GLOOMGOURD_PIE = registerItem("debug_gloomgourd_pie",
            () -> new BlockItem(DelightfulBlocks.GLOOMGOURD_PIE.get(), (new Item.Properties())) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    tooltip.add(TextUtils.DEBUG_ITEM);
                }
            });
    public static final DeferredItem<Item> DEBUG_BLUEBERRY_PIE = registerItem("debug_blueberry_pie",
            () -> new BlockItem(DelightfulBlocks.BLUEBERRY_PIE.get(), (new Item.Properties())) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    tooltip.add(TextUtils.DEBUG_ITEM);
                }
            });
    public static final DeferredItem<Item> DEBUG_GREEN_APPLE_PIE = registerItem("debug_green_apple_pie",
            () -> new BlockItem(DelightfulBlocks.GREEN_APPLE_PIE.get(), (new Item.Properties())) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    tooltip.add(TextUtils.DEBUG_ITEM);
                }
            });


    public static final DeferredItem<Item> DEBUG_CHORUS_PIE = registerItem("debug_chorus_pie",
            () -> new BlockItem(DelightfulBlocks.CHORUS_PIE.get(), (new Item.Properties())) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    tooltip.add(TextUtils.DEBUG_ITEM);
                }
            });


    public static final DeferredItem<Item> DEBUG_MULBERRY_PIE = registerItem("debug_mulberry_pie",
            () -> new BlockItem(DelightfulBlocks.MULBERRY_PIE.get(), (new Item.Properties())) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    tooltip.add(TextUtils.DEBUG_ITEM);
                }
            });
    public static final DeferredItem<Item> DEBUG_PASSION_FRUIT_TART = registerItem("debug_passion_fruit_tart",
            () -> new BlockItem(DelightfulBlocks.PASSION_FRUIT_TART.get(), (new Item.Properties())) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    tooltip.add(TextUtils.DEBUG_ITEM);
                }
            });
    public static final DeferredItem<Item> DEBUG_MUTTON_PIE = registerItem("debug_mutton_pie",
            () -> new BlockItem(DelightfulBlocks.MUTTON_PIE.get(), (new Item.Properties())) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    tooltip.add(TextUtils.DEBUG_ITEM);
                }
            });
    public static final DeferredItem<Item> DEBUG_SOURCE_BERRY_PIE = registerItem("debug_source_berry_pie",
            () -> new BlockItem(DelightfulBlocks.SOURCE_BERRY_PIE.get(), (new Item.Properties())) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
                    tooltip.add(TextUtils.DEBUG_ITEM);
                }
            });

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


    public static DeferredItem<Item> registerCompatFood(String name, FoodProperties food, boolean hasFoodEffectTooltip, Modid... modid) {
        return registerItem(name,
                () -> new CompatConsumableItem((new Item.Properties().food(food)), hasFoodEffectTooltip, false, modid));
    }

    public static DeferredItem<Item> registerCompatPieSlice(String pieName, FoodProperties food, Modid modid) {
        return registerItem(pieName + "_slice",
                () -> new CompatPieSliceItem((new Item.Properties().food(food)), modid));
    }

}
