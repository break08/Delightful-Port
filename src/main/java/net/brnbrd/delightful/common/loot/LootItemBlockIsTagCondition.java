package net.brnbrd.delightful.common.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

public class LootItemBlockIsTagCondition implements LootItemCondition {
    public static final MapCodec<LootItemBlockIsTagCondition> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    TagKey.codec(Registries.BLOCK).fieldOf("tag").forGetter(cond -> cond.tag)
            ).apply(instance, LootItemBlockIsTagCondition::new)
    );

    final TagKey<Block> tag;

    public LootItemBlockIsTagCondition(TagKey<Block> tag) {
        this.tag = tag;
    }

    @Override
    public @NotNull LootItemConditionType getType() {
        return DelightfulLootItemConditions.IS_TAG.get();
    }

    @Override
    public boolean test(LootContext lootContext) {
        BlockState state = lootContext.getParamOrNull(LootContextParams.BLOCK_STATE);
        return state != null && state.is(this.tag);
    }


}
