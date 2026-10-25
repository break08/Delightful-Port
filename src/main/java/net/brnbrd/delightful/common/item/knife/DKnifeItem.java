package net.brnbrd.delightful.common.item.knife;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.common.item.IConfigured;
import net.brnbrd.delightful.compat.Modid;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.util.Lazy;
import org.codehaus.plexus.util.StringUtils;
import net.brnbrd.delightful.Delightful;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import vectorwing.farmersdelight.common.item.KnifeItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DKnifeItem extends KnifeItem implements IConfigured {
    @Nullable private final TagKey<Item> tag;
    @NotNull private final Modid[] modid;

    public DKnifeItem(@Nullable TagKey<Item> tag, Tier tier, Properties properties) {
        super(tier, properties);
        this.tag = tag;
        this.modid = Util.EMPTY;
    }

    public DKnifeItem(@Nullable TagKey<Item> tag, Tier tier, Properties properties, @NotNull Modid... modid) {
        super(tier, properties);
        this.tag = tag;
        this.modid = modid;
    }

    public DKnifeItem(Tier tier, Properties properties) {
        super(tier, properties);
        this.tag = null;
        this.modid = Util.EMPTY;
    }

    @Override
    public @Nullable TagKey<Item> getDependencyTag() {
        return this.tag;
    }

    @Override
    public Modid[] getModid() {
        return this.modid;
    }

    public List<Component> getTools() {
        return Collections.emptyList();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack p_41421_, @NotNull TooltipContext p_339594_, @NotNull List<Component> p_41423_, @NotNull TooltipFlag p_41424_) {
        if (this.enabledText(p_41423_)) {
            if (!this.getTools().isEmpty()) {
                p_41423_.addAll(this.getTools());
            }
        }
        super.appendHoverText(p_41421_, p_339594_, p_41423_, p_41424_);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack pToRepair, @NotNull ItemStack pRepair) {
        return this.enabled() && super.isValidRepairItem(pToRepair, pRepair);
    }

    public Ingredient getRod() {
        return Ingredient.of(Tags.Items.RODS_WOODEN);
    }

    public @NotNull ItemStack getCreativeItem() {
        return new ItemStack(this);
    }

    public @Nullable RecipeType<?> getRecipeType() {
        return RecipeType.CRAFTING;
    }

    @Nullable
    public Lazy<ItemAttributeModifiers> getModifiers(ItemStack stack) {
        return null;
    }

    /*
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);
        Lazy<Multimap<Attribute, AttributeModifier>> additional = this.getModifiers(slot, stack);
        if (this.enabled() && slot == EquipmentSlot.MAINHAND && additional != null) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            if (!mods.isEmpty()) {
                builder.putAll(mods);
            }
            builder.putAll(additional.get());
            return builder.build();
        }
        return mods;
    }

     */

    public String getTranslation() {
        return StringUtils.capitaliseAllWords(
                this.getDescriptionId()
                        .toLowerCase(Locale.ROOT)
                        .replace("item." + Delightful.MODID.toLowerCase(Locale.ROOT) + ".", Util.EMPTY_STR)
                        .replace("_", " ")
        );
    }
}
