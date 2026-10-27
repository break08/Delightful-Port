package net.brnbrd.delightful.common.block;

import com.teamabnormals.neapolitan.core.other.NeapolitanCauldronInteractions;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.minecraft.core.cauldron.CauldronInteraction;


public class DelightfulCauldronInteractions {
    public static void registerCauldronInteractions() {
        NeapolitanCauldronInteractions.addMilkshakeInteractions(DelightfulItems.MATCHA_MILKSHAKE.get(), DelightfulBlocks.MATCHA_MILKSHAKE_CAULDRON.get(), DelightfulItems.MATCHA_ICE_CREAM.get(), CauldronInteraction.newInteractionMap("matcha_milkshake").map());
        NeapolitanCauldronInteractions.addMilkshakeInteractions(DelightfulItems.SALMONBERRY_MILKSHAKE.get(), DelightfulBlocks.SALMONBERRY_MILKSHAKE_CAULDRON.get(), DelightfulItems.SALMONBERRY_ICE_CREAM.get(), CauldronInteraction.newInteractionMap("salmonberry_milkshake").map());
        NeapolitanCauldronInteractions.addMilkshakeInteractions(DelightfulItems.SOURCE_BERRY_MILKSHAKE.get(), DelightfulBlocks.SOURCE_BERRY_MILKSHAKE_CAULDRON.get(), DelightfulItems.SOURCE_BERRY_ICE_CREAM.get(), CauldronInteraction.newInteractionMap("source_berry_milkshake").map());
    }
}
