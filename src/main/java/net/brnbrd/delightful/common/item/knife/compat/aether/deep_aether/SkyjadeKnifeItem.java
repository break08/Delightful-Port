package net.brnbrd.delightful.common.item.knife.compat.aether.deep_aether;

import io.github.razordevs.deep_aether.init.DATiers;
import io.github.razordevs.deep_aether.item.gear.skyjade.SkyjadeWeapon;
import net.brnbrd.delightful.common.item.knife.compat.aether.AetherKnifeItem;
import net.brnbrd.delightful.compat.Modid;
import net.brnbrd.delightful.data.tags.DelightfulItemTags;

public class SkyjadeKnifeItem extends AetherKnifeItem implements SkyjadeWeapon
{

	public SkyjadeKnifeItem(Properties properties) {
		super(DelightfulItemTags.GEMS_SKYJADE, DATiers.SKYJADE, properties, Modid.DA);
	}

	/*
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
		return this.increaseDamage(super.getAttributeModifiers(slot, stack), stack, slot);
	}

	@Override
	public boolean isEnchantable(@NotNull ItemStack itemStack) {
		return this.enabled() && DeepAetherConfig.COMMON.skyjade_enchant.get();
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return this.enabled() && DeepAetherConfig.COMMON.skyjade_enchant.get();
	}

	 */

}