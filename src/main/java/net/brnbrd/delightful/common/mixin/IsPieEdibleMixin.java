package net.brnbrd.delightful.common.mixin;

import net.brnbrd.delightful.common.DelightfulConfig;
import net.brnbrd.delightful.common.event.PieEvents;
import net.brnbrd.delightful.data.tags.DelightfulItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.tag.ModTags;

@Mixin(Item.class)
public abstract class IsPieEdibleMixin {
    @Shadow
    public abstract ItemStack getDefaultInstance();

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void isPieEdible(Level p_41432_, Player p_41433_, InteractionHand p_41434_, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        final ItemStack stack = getDefaultInstance();
        if (
                stack.is(ModTags.Items.PIES) &&
                        DelightfulConfig.PIE_EDIBLE_MIXIN.get() &&
                        (!stack.is(DelightfulItemTags.COMPAT_PIES) || PieEvents.isCompatPie(stack))
        ) {
            cir.setReturnValue(InteractionResultHolder.pass(p_41433_.getItemInHand(p_41434_)));
        }
    }
}