package net.brnbrd.delightful.common.loot;

import net.brnbrd.delightful.Delightful;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DelightfulLootItemConditions {
    private static final DeferredRegister<LootItemConditionType> LICT = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, Delightful.MODID);

    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> IS_TAG = LICT.register("is_tag",
            () -> new LootItemConditionType(LootItemBlockIsTagCondition.CODEC));
    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> ENABLED = LICT.register("enabled",
            () -> new LootItemConditionType(LootItemEnabledCondition.CODEC));
    public static final DeferredHolder<LootItemConditionType, LootItemConditionType> MOD_LOADED = LICT.register("mod_loaded",
            () -> new LootItemConditionType(LootItemModLoadedCondition.CODEC));

    public static void create(IEventBus bus) {
        LICT.register(bus);
    }
}
