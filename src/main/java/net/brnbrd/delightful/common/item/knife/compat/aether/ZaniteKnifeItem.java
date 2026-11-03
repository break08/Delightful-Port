package net.brnbrd.delightful.common.item.knife.compat.aether;

import net.brnbrd.delightful.common.item.DelightfulTiers;
import net.brnbrd.delightful.data.tags.DelightfulItemTags;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

public class ZaniteKnifeItem extends AetherKnifeItem {
	public ZaniteKnifeItem(Properties properties) {
		super(DelightfulItemTags.GEMS_ZANITE, DelightfulTiers.ZANITE, properties);

	}

	/*
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
		Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		if (this.enabled() && slot == EquipmentSlot.MAINHAND) {
			builder.putAll(map);
			builder.put(Attributes.ATTACK_DAMAGE.value(), new AttributeModifier(
				BASE_ATTACK_DAMAGE_ID,
					calculateIncrease(map, stack),
				AttributeModifier.Operation.ADD_VALUE)
			);
			return builder.build();
		}
		return map;
	}

	 */

	// nah deprecated
	public int calculateIncrease(ItemAttributeModifierEvent event, ItemStack stack) {
		double baseDamage = 0.0;
		for (var entry : event.getModifiers()) {
			if (entry.attribute().is(Attributes.ATTACK_DAMAGE)) {
				baseDamage += entry.modifier().amount();
			}
		}
		if (baseDamage <= 0) return 0;
		double boostedDamage = baseDamage * (2.0 * ((double) stack.getDamageValue()) / ((double) stack.getMaxDamage()) + 0.5);
		boostedDamage -= baseDamage;

		if (boostedDamage < 0.0) {
			boostedDamage = 0.0;
		}
		return (int) Math.round(boostedDamage);
	}
}