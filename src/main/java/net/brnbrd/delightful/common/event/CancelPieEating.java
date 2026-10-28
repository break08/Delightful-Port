package net.brnbrd.delightful.common.event;

import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.common.DelightfulConfig;
import net.brnbrd.delightful.data.tags.DelightfulItemTags;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import vectorwing.farmersdelight.common.tag.ModTags;

@EventBusSubscriber(modid = Delightful.MODID)
public class CancelPieEating {
    @SubscribeEvent
    public static void onUseStart(LivingEntityUseItemEvent.Start event) {
        final ItemStack stack = event.getItem();
        if (
                stack.is(ModTags.Items.PIES) &&
                        DelightfulConfig.PIE_EDIBLE_MIXIN.get() &&
                        (!stack.is(DelightfulItemTags.COMPAT_PIES) || PieEvents.isCompatPie(stack))
        ) {
            event.setCanceled(true);
        }
    }
}
