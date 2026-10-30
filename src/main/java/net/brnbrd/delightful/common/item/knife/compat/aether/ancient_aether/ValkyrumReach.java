package net.brnbrd.delightful.common.item.knife.compat.aether.ancient_aether;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.common.NeoForgeMod;

public interface ValkyrumReach {

	default Multimap<Attribute, AttributeModifier> extendReachModifier(Multimap<Attribute, AttributeModifier> map, EquipmentSlot slot) {
		if (slot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeBuilder = ImmutableMultimap.builder();
			attributeBuilder.putAll(map);
			attributeBuilder.put(Attributes.BLOCK_INTERACTION_RANGE.value(), new AttributeModifier(
					ResourceLocation.fromNamespaceAndPath(
							Delightful.MODID,
							"c18598a9-f66a-44e7-9ce1-99b1ee178678"
					),
				getModifier(),
				AttributeModifier.Operation.ADD_VALUE
			));
			attributeBuilder.put(Attributes.ENTITY_INTERACTION_RANGE.value(), new AttributeModifier(
					ResourceLocation.fromNamespaceAndPath(
							Delightful.MODID,
							"61f992e6-276f-4d2b-88a7-823cb64ba459"
					),
				getModifier(),
				AttributeModifier.Operation.ADD_VALUE
			));
			map = attributeBuilder.build();
		}
		return map;
	}

	private double getModifier() {
		return 1;
	}
}