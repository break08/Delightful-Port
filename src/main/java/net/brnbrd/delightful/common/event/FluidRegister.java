package net.brnbrd.delightful.common.event;

import net.brnbrd.delightful.common.fluid.DFluidType;
import net.brnbrd.delightful.common.fluid.DelightfulFluids;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import static net.brnbrd.delightful.Delightful.MODID;
import static net.brnbrd.delightful.compat.brewinandchewin.AgedRoeFluidType.AGED_ROE_FLOWING_TEXTURE;
import static net.brnbrd.delightful.compat.brewinandchewin.AgedRoeFluidType.AGED_ROE_STILL_TEXTURE;
import static net.brnbrd.delightful.compat.brewinandchewin.CaviarFluidType.CAVIAR_FLOWING_TEXTURE;
import static net.brnbrd.delightful.compat.brewinandchewin.CaviarFluidType.CAVIAR_STILL_TEXTURE;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class FluidRegister {
    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return AGED_ROE_STILL_TEXTURE;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return AGED_ROE_FLOWING_TEXTURE;
            }

        }, DelightfulFluids.AGED_ROE_TYPE);

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return CAVIAR_STILL_TEXTURE;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return CAVIAR_FLOWING_TEXTURE;
            }


        }, DelightfulFluids.CAVIAR_TYPE);

        registerTinted(event, DelightfulFluids.MATCHA_LATTE_TYPE);
        registerTinted(event, DelightfulFluids.ENDER_NECTAR_TYPE);
        registerTinted(event, DelightfulFluids.AZALEA_TEA_TYPE);
        registerTinted(event, DelightfulFluids.LAVENDER_TEA_TYPE);
        registerTinted(event, DelightfulFluids.PRICKLY_PEAR_JUICE_TYPE);
        registerTinted(event, DelightfulFluids.LONG_PRICKLY_PEAR_JUICE_TYPE);
        registerTinted(event, DelightfulFluids.EGGNOG_TYPE);

    }

    private static void registerTinted(RegisterClientExtensionsEvent event, DeferredHolder<FluidType, FluidType> type) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return ResourceLocation.withDefaultNamespace("block/water_still");
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return ResourceLocation.withDefaultNamespace("block/water_flow");
            }

            @Override
            public int getTintColor() {
                return ((DFluidType) type.get()).getTint();
            }
        }, type);
    }
}
