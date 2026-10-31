package net.brnbrd.delightful.common.event;

import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.common.item.knife.DKnifeItem;
import net.brnbrd.delightful.common.item.knife.compat.aether.ZaniteKnifeItem;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

@EventBusSubscriber(modid = Delightful.MODID)
public class AttributeEvents {
    @SubscribeEvent
    public static void onItemAttributes(ItemAttributeModifierEvent event) {
        Item eventStack = event.getItemStack().getItem();

        if (eventStack instanceof DKnifeItem base && base.enabled()) {
            Lazy<ItemAttributeModifiers> additional = base.getModifiers(event.getItemStack());
            if (additional != null) {
                additional.get().modifiers().forEach(e ->
                        event.addModifier(e.attribute(), e.modifier(), e.slot()));
            }
        }

        if (eventStack instanceof ZaniteKnifeItem base && base.enabled()){
            double bonusDamage = base.calculateIncrease(event, event.getItemStack());

            if (bonusDamage > 0) {
                event.addModifier(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                ZaniteKnifeItem.BASE_ATTACK_DAMAGE_ID,
                                bonusDamage,
                                AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                );
            }
        }

    }
}