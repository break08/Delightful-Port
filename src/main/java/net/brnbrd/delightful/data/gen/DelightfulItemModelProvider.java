package net.brnbrd.delightful.data.gen;

import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.brnbrd.delightful.common.item.knife.DKnifeItem;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;

public class DelightfulItemModelProvider extends ItemModelProvider {
    private static final List<ResourceLocation> HANDHELD = List.of(
            DelightfulItems.MARSHMALLOW_STICK.getId(),
            DelightfulItems.COOKED_MARSHMALLOW_STICK.getId(),
            DelightfulItems.ROCK_CANDY.getId()
    );
    private static final List<ResourceLocation> FLAT_BLOCKS = List.of(
            DelightfulItems.WILD_SALMONBERRIES.getId(),
            DelightfulItems.STUFFED_CANTALOUPE_BLOCK.getId()
    );
    private static final List<ResourceLocation> ITEM_BLOCKS = List.of(
            DelightfulItems.SALMONBERRY_PIE.getId(),
            DelightfulItems.BAKLAVA.getId()
    );
    private static final List<ResourceLocation> EMISSIVE = List.of(
            //Knives.FIERY.getId()
    );

    public DelightfulItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Delightful.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ResourceLocation id;
        for (DeferredHolder<Item, ? extends Item> entry : DelightfulItems.ITEMS.getEntries()) {
            {
                id = entry.getId();
                if (id.getPath().startsWith("strong_")) {
                    getBuilder(id.toString())
                            .parent(new ModelFile.UncheckedModelFile("item/generated"))
                            .texture("layer0", Util.delight("item/" + id.getPath().replace("strong_", "")));
                    continue;
                } else if (id.getPath().startsWith("long_")) {
                    getBuilder(id.toString())
                            .parent(new ModelFile.UncheckedModelFile("item/generated"))
                            .texture("layer0", Util.delight("item/" + id.getPath().replace("long_", "")));
                    continue;
                } else if (EMISSIVE.contains(id)) {
                    emissive(id);
                    continue;
                } else if (HANDHELD.contains(id) || entry.get() instanceof DKnifeItem) {
                    handheld(id);
                    continue;
                } else if (FLAT_BLOCKS.contains(id)) {
                    flatBlock(id);
                    continue;
                } else if (
                        entry.get() instanceof BlockItem b &&
                                !(entry.get() instanceof ItemNameBlockItem) &&
                                !ITEM_BLOCKS.contains(id)
                ) {
                    if (b.getBlock() instanceof WallBlock) {
                        wallInventory(id.getPath(), Util.rl(id.getNamespace(), "block/" + id.getPath().replace("_wall", "s")));
                    } else {
                        withExistingParent(id.getPath(), Util.rl(this.modid, "block/" + id.getPath()));
                    }
                    continue;
                }
                basicItem(id);
            }
        }

    }
    void flatBlock(ResourceLocation id) {
        getBuilder(id.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "block/" + id.getPath()));
    }

    void handheld(ResourceLocation item) {
        withExistingParent(item.getPath(), "item/handheld")
                .texture("layer0", Util.delight("item/" + item.getPath()));
    }

    void emissive(ResourceLocation item) {
        withExistingParent(item.getPath(), "item/handheld")
                .texture("layer0", Util.delight("item/" + item.getPath()))
                .guiLight(BlockModel.GuiLight.FRONT);
    }
}