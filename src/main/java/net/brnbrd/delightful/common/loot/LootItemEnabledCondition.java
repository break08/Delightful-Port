package net.brnbrd.delightful.common.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.brnbrd.delightful.Util;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

public class LootItemEnabledCondition implements LootItemCondition {
    public static final MapCodec<LootItemEnabledCondition> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.STRING.fieldOf("item").forGetter(c -> c.item)
            ).apply(instance, LootItemEnabledCondition::new)
    );

    final String item;

    public LootItemEnabledCondition(String item) {
        this.item = item;
    }

    @Override
    public @NotNull LootItemConditionType getType() {
        return DelightfulLootItemConditions.ENABLED.get();
    }

    @Override
    public boolean test(LootContext lootContext) {
        return Util.enabled(this.item);
    }
}
