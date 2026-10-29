package net.brnbrd.delightful.common.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.brnbrd.delightful.compat.Mods;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

public class LootItemModLoadedCondition implements LootItemCondition {
    public static final MapCodec<LootItemModLoadedCondition> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.STRING.fieldOf("modid").forGetter(c -> c.modid)
            ).apply(instance, LootItemModLoadedCondition::new)
    );


    final String modid;

    public LootItemModLoadedCondition(String modid) {
        this.modid = modid;
    }

    @Override
    public @NotNull LootItemConditionType getType() {
        return DelightfulLootItemConditions.MOD_LOADED.get();
    }

    @Override
    public boolean test(LootContext lootContext) {
        return Mods.stringLoaded(this.modid);
    }
}
