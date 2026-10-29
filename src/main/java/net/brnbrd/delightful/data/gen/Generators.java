package net.brnbrd.delightful.data.gen;

import net.brnbrd.delightful.Delightful;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Delightful.MODID)
public class Generators {
    // Gathering data
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator gen = e.getGenerator();
        PackOutput output = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = e.getLookupProvider();
        ExistingFileHelper helper = new LenientExistingFileHelper(e.getExistingFileHelper());;

        for (String name : List.of("gloomgourd_side", "gloomgourd_top", "gloomgourd_bottom")) {
            helper.trackGenerated(
                    ResourceLocation.fromNamespaceAndPath("undergarden", "block/" + name),
                    PackType.CLIENT_RESOURCES, ".png", "textures");
        }
        gen.addProvider(e.includeServer(), new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(DelightfulBlockLoot::new, LootContextParamSets.BLOCK)),
                e.getLookupProvider()));

        e.getGenerator().addProvider(e.includeServer(), new DelightfulRecipeProvider(output, e.getLookupProvider()));
        DelightfulBlockTagProvider blockTag = new DelightfulBlockTagProvider(output, lookup, helper);
        e.getGenerator().addProvider(e.includeServer(), blockTag);
        e.getGenerator().addProvider(e.includeServer(), new DelightfulItemTagProvider(output, lookup, blockTag.contentsGetter(), helper));
        e.getGenerator().addProvider(e.includeServer(), new DelightfulEntityTagProvider(output, lookup, helper));
        e.getGenerator().addProvider(e.includeServer(), new DelightfulLootModifierProvider(output, e.getLookupProvider(), Delightful.MODID));

        e.getGenerator().addProvider(e.includeClient(), new DelightfulBlockStateProvider(output, helper));
        e.getGenerator().addProvider(e.includeClient(), new DelightfulItemModelProvider(output, helper));
        e.getGenerator().addProvider(e.includeClient(), new DelightfulLanguageProvider(output));
    }
}
