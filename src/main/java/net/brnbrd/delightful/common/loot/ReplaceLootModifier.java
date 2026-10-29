package net.brnbrd.delightful.common.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.brnbrd.delightful.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import java.util.ArrayList;
import java.util.function.Supplier;

import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.NotNull;

public class ReplaceLootModifier extends LootModifier {
    public static final Supplier<MapCodec<ReplaceLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.mapCodec(inst -> codecStart(inst).and(
                            inst.group(
                                    ResourceLocation.CODEC.fieldOf("removed_item").forGetter((m) -> m.removedItem),
                                    ResourceLocation.CODEC.fieldOf("added_item").forGetter((m) -> m.addedItem)
                            )
                    )
                    .apply(inst, ReplaceLootModifier::new)));

    private final ResourceLocation removedItem;
    private final ResourceLocation addedItem;

    /**
     * Replaces all instances of the specified item with another.
     */
    protected ReplaceLootModifier(LootItemCondition[] conditions, ResourceLocation removedItem, ResourceLocation addedItem) {
        super(conditions);
        this.removedItem = removedItem;
        this.addedItem = addedItem;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext lootContext) {
        if (Util.itemExists(this.removedItem) && Util.itemExists(this.addedItem)) {
            final Item removed = Util.item(this.removedItem);
            final Item added = Util.item(this.addedItem);
            final ArrayList<ItemStack> newLoot = Lists.newArrayList();
            generatedLoot.forEach((item) -> {
                if (item.is(removed)) {
                    ItemStack replacement = new ItemStack(added, item.getCount());
                    if (replacement.getCount() > replacement.getMaxStackSize()) {
                        replacement.setCount(replacement.getMaxStackSize());
                    }
                    newLoot.add(replacement);
                    generatedLoot.remove(item);
                }
            });

            if (!newLoot.isEmpty()) generatedLoot.addAll(newLoot);
        }
        return generatedLoot;
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return DelightfulLootModifiers.REPLACE.get();
    }
}
