package net.brnbrd.delightful.common.event;

import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.common.item.knife.DKnifeItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

@EventBusSubscriber(modid = Delightful.MODID)
public class AttributeEvents {
    @SubscribeEvent
    public static void onItemAttributes(ItemAttributeModifierEvent event) {
        if (event.getItemStack().getItem() instanceof DKnifeItem base && base.enabled()) {
            Lazy<ItemAttributeModifiers> additional = base.getModifiers(event.getItemStack());
            if (additional != null) {
                additional.get().modifiers().forEach(e ->
                        event.addModifier(e.attribute(), e.modifier(), e.slot()));
            }
        }
    }
}