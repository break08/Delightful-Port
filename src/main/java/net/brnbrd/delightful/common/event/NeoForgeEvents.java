package net.brnbrd.delightful.common.event;

import net.brnbrd.delightful.Util;
import net.brnbrd.delightful.common.block.DelightfulBlocks;
import net.brnbrd.delightful.common.block.ISliceable;
import net.brnbrd.delightful.common.item.DelightfulItems;
import net.brnbrd.delightful.compat.Modid;
import net.brnbrd.delightful.data.tags.DelightfulItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.List;
import java.util.Objects;

public class NeoForgeEvents {
    private final ResourceLocation crystalline = Util.rl(Modid.EP, "crystalline_knife");

    /*
    @SubscribeEvent
    void onMissingMappings(MissingMappingsEvent e) {
        // Item
        for (var map : e.getMappings(Registries.ITEM, Delightful.MODID)) {
            if (checkRoeMap(map)) {
                map.remap(DelightfulItems.AGED_ROE.get());
            } else if (map.getKey().getPath().equals("crystalline_knife") && Util.itemExists(crystalline)) {
                map.remap(Util.item(crystalline));
            } else if (map.getKey().getPath().equals("pumpkin_pie_slice")) {
                map.remap(ModItems.PUMPKIN_PIE_SLICE.get());
            }
        }
        // Block
        for (var map : e.getMappings(Registries.BLOCK, Delightful.MODID)) {
            if (map.getKey().getPath().equals("pumpkin_pie")) {
                map.remap(ModBlocks.PUMPKIN_PIE.get());
            }
        }
        // Fluid
        e.getMappings(Registries.FLUID, Delightful.MODID).stream()
                .filter(this::checkRoeMap)
                .forEach(map -> map.remap(DelightfulFluids.AGED_ROE.get()));
    }

    private boolean checkRoeMap(final MissingMappingsEvent.Mapping<?> mapping) {
        final String path = mapping.getKey().getPath();
        return path.equals("aged_fish_roe") || path.equals("aged_prawn_roe");
    }

     */

    @SubscribeEvent
    void onEatEffectProvider(LivingEntityUseItemEvent.Finish e) {
        final ItemStack stack = e.getItem();
        final LivingEntity entity = e.getEntity();
        if (
                Modid.CAD.loaded() &&
                        stack.is(DelightfulItemTags.ROTTEN) &&
                        entity.getRandom().nextBoolean() // 50% chance
        ) {
            int duration = 160;
            if (stack.is(Modid.RL.item("rotten_chunk"))) {
                duration = 1800;
            }
            Util.addEffect(entity, Modid.CAD.effect("rotten"), duration, 0);
        }
    }

    @SubscribeEvent
    void onWanderingTrader(WandererTradesEvent e) {
        final List<VillagerTrades.ItemListing> trades = e.getGenericTrades();
        if (Util.enabled(DelightfulItems.SALMONBERRIES) && Util.enabled(DelightfulItems.SALMONBERRY_PIPS)) {
            trades.add((ent, r) -> new MerchantOffer(new ItemCost(Items.EMERALD, 2), Util.getStack(DelightfulItems.SALMONBERRY_PIPS), 5, 1, 1));
        }
        if (Util.enabled(DelightfulItems.CANTALOUPE) && Util.enabled(DelightfulItems.CANTALOUPE_SLICE)) {
            trades.add((ent, r) -> new MerchantOffer(new ItemCost(Items.EMERALD, 3), Util.getStack(DelightfulItems.CANTALOUPE_SLICE, 8), 5, 1, 1));
        }
        if (
                Util.enabled(DelightfulItems.CANTALOUPE) &&
                        Util.enabled(DelightfulItems.STUFFED_CANTALOUPE_BLOCK) &&
                        Util.enabled(DelightfulItems.STUFFED_CANTALOUPE)
        ) {
            trades.add((ent, r) -> new MerchantOffer(new ItemCost(Items.EMERALD, 5), Util.getStack(DelightfulItems.STUFFED_CANTALOUPE_BLOCK, 1), 3, 1, 1));
        }
    }

    // Crouch right-click slicing
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    void onInteract(PlayerInteractEvent.RightClickBlock e) {
        Level level = e.getLevel();
        BlockPos pos = e.getPos();
        if (e.getItemStack().is(ModTags.Items.KNIVES) && !e.getEntity().isCrouching()) {
            Block current = level.getBlockState(pos).getBlock();
            Block newBlock;
            if (current == Blocks.MELON) {
                newBlock = DelightfulBlocks.SLICED_MELON.get();
            } else if (current == Blocks.PUMPKIN) {
                newBlock = DelightfulBlocks.SLICED_PUMPKIN.get();
            } else if (
                    Objects.equals(BuiltInRegistries.BLOCK.getKey(current), Modid.UG.rl("carved_gloomgourd"))
            ) {
                newBlock = DelightfulBlocks.SLICED_GLOOMGOURD.get();
            } else {
                return;
            }
            if (newBlock instanceof ISliceable slice) {
                boolean client = level.isClientSide();
                e.setCancellationResult(InteractionResult.sidedSuccess(client));
                e.setCanceled(true);
                if (!client) {
                    slice(newBlock.defaultBlockState(), slice.getSliceItem(), level, pos, e.getEntity(), e.getHand());
                }
            }
        }
    }

    // Replaces Block in world, drops Item, cancels interaction event
    void slice(BlockState block, ItemStack slice, Level world, BlockPos pos, Player player, InteractionHand hand) {
        world.setBlock(pos, block, 2);
        Util.dropOrGive(slice, world, pos, player);
        world.playSound(null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1F, 1F);
        player.getItemInHand(hand).hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
    }
}
