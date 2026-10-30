package net.brnbrd.delightful;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import net.brnbrd.delightful.common.DelightfulConfig;
import net.brnbrd.delightful.common.block.DelightfulBlocks;
import net.brnbrd.delightful.common.crafting.EnabledCondition;
import net.brnbrd.delightful.common.event.ModEvents;
import net.brnbrd.delightful.common.event.NeoForgeEvents;
import net.brnbrd.delightful.common.event.PieEvents;
import net.brnbrd.delightful.common.fluid.DelightfulFluids;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.brnbrd.delightful.common.loot.DelightfulLootItemConditions;
import net.brnbrd.delightful.common.loot.DelightfulLootModifiers;
import net.brnbrd.delightful.common.world.DelightfulPlacementModifiers;
import net.brnbrd.delightful.compat.Modid;
import net.brnbrd.delightful.data.gen.Generators;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.slf4j.Logger;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

@Mod(Delightful.MODID)
public class Delightful {

    public static final String MODID = "delightful";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static Delightful instance;

    private void addBlocksToBlockEntities(BlockEntityTypeAddBlocksEvent event) {
        event.modify(ModBlockEntityTypes.CABINET.get(),
                DelightfulBlocks.BASALT_CABINET.get(),
                DelightfulBlocks.QUARTZ_CABINET.get());
    }

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Delightful.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + Delightful.MODID))
                    .icon(() -> new ItemStack(DelightfulItems.MINI_MELON.get()))
                    .displayItems((parameters, output) ->
                            DelightfulItems.ITEMS.getEntries().forEach(item -> output.accept(item.get())))
                    .build());

    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITIONS =
            DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, MODID);

    static {
        CONDITIONS.register("enabled", () -> EnabledCondition.CODEC);
    }

    private static void registerAliases() {
        final ResourceLocation crystalline = Util.rl(Modid.EP, "crystalline_knife");

        for (String oldRoe : new String[]{"aged_fish_roe", "aged_prawn_roe"}) {
            DelightfulItems.ITEMS.addAlias(Util.delight(oldRoe), DelightfulItems.AGED_ROE.getId());
            DelightfulFluids.FLUIDS.addAlias(Util.delight(oldRoe), DelightfulFluids.AGED_ROE.getId());
        }

        // Item
        DelightfulItems.ITEMS.addAlias(Util.delight("pumpkin_pie_slice"),
                ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "pumpkin_pie_slice"));
        if (ModList.get().isLoaded(crystalline.getNamespace())) {
            DelightfulItems.ITEMS.addAlias(Util.delight("crystalline_knife"), crystalline);
        }

        // Block
        DelightfulBlocks.BLOCKS.addAlias(Util.delight("pumpkin_pie"),
                ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "pumpkin_pie"));
    }

    public Delightful(IEventBus modEventBus, ModContainer modContainer) {
        instance = this;
        modEventBus.addListener(this::commonSetup);

        registerAliases();

        // Register Global Events
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(new NeoForgeEvents());
        NeoForge.EVENT_BUS.register(new PieEvents());

        // Register Mod Bus Listeners
        modEventBus.register(new ModEvents());
        modEventBus.register(Generators.class);
        modEventBus.addListener(this::addBlocksToBlockEntities);

        // Register Registries (Chỉ gọi đúng 1 lần duy nhất trên modEventBus)
        DelightfulBlocks.BLOCKS.register(modEventBus);
        DelightfulItems.ITEMS.register(modEventBus);
        DelightfulFluids.create(modEventBus);
        DelightfulPlacementModifiers.PLACEMENT_MODIFIERS.register(modEventBus);
        TABS.register(modEventBus);
        CONDITIONS.register(modEventBus);
        DelightfulLootItemConditions.create(modEventBus);
        DelightfulLootModifiers.create(modEventBus);

        // Register Config
        modContainer.registerConfig(ModConfig.Type.COMMON, DelightfulConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}