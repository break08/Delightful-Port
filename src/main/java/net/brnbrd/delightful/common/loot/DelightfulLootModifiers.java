package net.brnbrd.delightful.common.loot;

import com.mojang.serialization.MapCodec;
import net.brnbrd.delightful.Delightful;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DelightfulLootModifiers {
    private static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Delightful.MODID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddItemLootModifier>> ADD_ITEM = GLM.register("add_item", () -> AddItemLootModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<SmeltLootModifier>> SMELT = GLM.register("smelt", () -> SmeltLootModifier.CODEC);
    //public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddItemLootModifier>> REPLACE = GLM.register("replace", ReplaceLootModifier.CODEC);

    public static void create(IEventBus bus) {
        GLM.register(bus);
    }
}