package net.brnbrd.delightful.common.item.knife.compat.unusualend;

import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.common.item.DelightfulTiers;
import net.brnbrd.delightful.common.item.knife.DKnifeItem;
import net.brnbrd.delightful.compat.Modid;
import net.brnbrd.delightful.data.tags.DelightfulItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.common.util.Lazy;
import org.jetbrains.annotations.Nullable;

public class PearlescentKnifeItem extends DKnifeItem {
	private final Lazy<ItemAttributeModifiers> defaultModifiers;

	public PearlescentKnifeItem(Properties properties) {
		super(DelightfulItemTags.INGOTS_PEARLESCENT, DelightfulTiers.PEARLESCENT, properties, Modid.DD);
		this.defaultModifiers = Lazy.of(() -> ItemAttributeModifiers.builder()
				.add(Attributes.BLOCK_INTERACTION_RANGE,
						new AttributeModifier(Util.delight("pearlescent_block_reach"), 1.5D,
								AttributeModifier.Operation.ADD_VALUE),
						EquipmentSlotGroup.MAINHAND)
				.add(Attributes.ENTITY_INTERACTION_RANGE,
						new AttributeModifier(Util.delight("pearlescent_entity_reach"), 0.5D,
								AttributeModifier.Operation.ADD_VALUE),
						EquipmentSlotGroup.MAINHAND)
				.build());
	}

	/*
	@Override
	public @Nullable Lazy<ItemAttributeModifiers> getModifiers(EquipmentSlot slot, ItemStack stack) {
		return defaultModifiers;
	}

	 */

	@Override
	public @Nullable RecipeType<?> getRecipeType() {
		return RecipeType.SMITHING;
	}
}