package net.brnbrd.delightful.common.world;

import com.mojang.serialization.MapCodec;
import net.brnbrd.delightful.Delightful;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DelightfulPlacementModifiers {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE.key(), Delightful.MODID);

    public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<ConfigEnabledFilter>> ENABLED = PLACEMENT_MODIFIERS.register("enabled", () -> typeConvert(ConfigEnabledFilter.CODEC));

    private static <P extends PlacementModifier> PlacementModifierType<P> typeConvert(MapCodec<P> codec) {
        return () -> codec;
    }

    public static void create(IEventBus bus) {
        PLACEMENT_MODIFIERS.register(bus);
    }
}
