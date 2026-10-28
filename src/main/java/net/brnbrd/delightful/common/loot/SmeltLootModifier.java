package net.brnbrd.delightful.common.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

//Code adapted from https://github.com/MinecraftForge/MinecraftForge/blob/1.20.x/src/test/java/net/minecraftforge/debug/gameplay/loot/GlobalLootModifiersTest.java
//LICENSE: https://github.com/MinecraftForge/MinecraftForge/blob/1.20.x/LICENSE.txt

public class SmeltLootModifier extends LootModifier {
    public static final MapCodec<SmeltLootModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> codecStart(inst).apply(inst, SmeltLootModifier::new));

    public SmeltLootModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return DelightfulLootModifiers.SMELT.get();
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
        return generatedLoot.stream().map(stack -> {
            SingleRecipeInput input = new SingleRecipeInput(stack);
            ItemStack smelted = context.getLevel().getRecipeManager()
                    .getRecipeFor(RecipeType.SMELTING, input, context.getLevel())
                    .map(recipe -> recipe.value().assemble(input, context.getLevel().registryAccess()))
                    .filter(itemStack -> !itemStack.isEmpty())
                    .map(itemStack -> itemStack.copyWithCount(stack.getCount() * itemStack.getCount())) // Dùng copyWithCount thay vì ItemHandlerHelper
                    .orElse(stack);
            if (smelted == stack) {
                return stack;
            }
            ExperienceOrb.award(context.getLevel(), context.getParam(LootContextParams.ORIGIN), context.getRandom().nextInt(3) + 1);
            return smelted;
        }).collect(ObjectArrayList.toList());
    }
}
