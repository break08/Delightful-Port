package net.brnbrd.delightful.common.item.knife.compat.undergarden;

import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.common.item.DelightfulTiers;
import net.brnbrd.delightful.common.item.knife.DKnifeItem;
import net.brnbrd.delightful.common.item.knife.Knives;
import net.brnbrd.delightful.compat.Modid;
import net.brnbrd.delightful.data.tags.DelightfulItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class ForgottenKnifeItem extends DKnifeItem {

	public ForgottenKnifeItem(Properties properties) {
		super(DelightfulItemTags.ingot("forgotten_metal"), DelightfulTiers.FORGOTTEN, properties, Modid.UG);
		NeoForge.EVENT_BUS.addListener(this::onHurt);
		NeoForge.EVENT_BUS.addListener(this::onDig);
	}

	@Override
	public @NotNull Component getName(@NotNull ItemStack stack) {
		Component name = super.getName(stack);
		return this.enabled() ? name.copy().withStyle(ChatFormatting.GREEN) : name;
	}

	@Override
	public List<Component> getTools() {
		return List.of(Component.translatable("tooltip.forgotten_sword").withStyle(ChatFormatting.GREEN));
	}

	@Override
	public Modid[] getConflicts() {
		return new Modid[]{Modid.UGD};
	}

	@Override
	public @Nullable RecipeType<?> getRecipeType() {
		return RecipeType.SMITHING;
	}

	void onHurt(LivingDamageEvent.Pre e) {
		if (
			this.enabled() &&
			e.getSource().getEntity() instanceof Player player &&
			player.getMainHandItem().is(Knives.FORGOTTEN) &&
					BuiltInRegistries.ENTITY_TYPE.getKey(e.getEntity().getType()).getNamespace().equals(Modid.UG.get()) &&
					e.getEntity().canUsePortal(false)
		) {
			e.setNewDamage(e.getOriginalDamage() * 1.5F);
		}
	}

	void onDig(PlayerEvent.BreakSpeed e) {
		BlockState state = e.getState();
		if (
                this.enabled() && e.getEntity().getMainHandItem().is(this) && Util.nameSpace(state.getBlock()).equals(Modid.UG.get())
		) {
			e.setNewSpeed(e.getOriginalSpeed() * 1.5F);
		}
    }
}