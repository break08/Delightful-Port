package net.brnbrd.delightful.common.event;

import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.common.block.DelightfulCauldronInteractions;
import net.brnbrd.delightful.compat.Modid;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import org.apache.commons.lang3.StringUtils;

public class ModEvents {
    @SubscribeEvent
    void setup(FMLCommonSetupEvent e) {
        //DPacketHandler.init(); // Botania
        e.enqueueWork(() -> {
            if (Modid.N.loaded()) {
                DelightfulCauldronInteractions.registerCauldronInteractions();
            }
        });
    }


    /*
    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        DefaultedRegistry<Item> reg = BuiltInRegistries.ITEM;
        ResourceLocation TOAST_WITH_BLUEBERRIES = Util.rl(Modid.MOD, "toast_with_blueberries");
        // Delightful Items
        if (event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey()) {
            DelightfulItems.ITEMS.getEntries().stream()
                    .filter(DelightfulItems.ITEMS.isP)
                    //.filter((object) -> !DelightfulItems.NO_GEN.contains(object.getId()))
                    .forEach((item) -> {
                        Item i = item.get();
                        ItemStack inst = i instanceof DKnifeItem ? ((DKnifeItem) i).getCreativeItem() : new ItemStack(i);
                        if (
                                (i instanceof IConfigured conf && conf.enabled() && !inst.isEmpty()) ||
                                        !(i instanceof IConfigured)
                        ) {
                            event.accept(inst, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                        }
                    });
        } else if (
                Modid.MOD.loaded() &&
                        event.getTabKey().location().getNamespace().equals(Modid.MOD.get())
        ) {
            // Kiểm tra xem tag có tồn tại và có chứa phần tử nào không trong NeoForge
            boolean hasBlueberriesTag = reg.getTag(DelightfulItemTags.FRUITS_BLUEBERRIES)
                    .map(holderSet -> !holderSet.isEmpty())
                    .orElse(false);

            if (
                    !Modid.NF.loaded() &&
                            reg.containsKey(TOAST_WITH_BLUEBERRIES) &&
                            hasBlueberriesTag
            ) {
                Item toast = reg.get(TOAST_WITH_BLUEBERRIES);
                event.accept(toast);
            }
        }
    }

     */

    @SubscribeEvent
    public void addPackFinders(AddPackFindersEvent e) {
        e.addPackFinders(
                ResourceLocation.fromNamespaceAndPath(Delightful.MODID, "overhauls"),
                PackType.CLIENT_RESOURCES,
                Component.literal(StringUtils.capitalize(Delightful.MODID) + " ")
                        .append(Component.translatable(Delightful.MODID + ".overhauls")),
                PackSource.BUILT_IN,
                false,
                Pack.Position.TOP
        );
    }
}
