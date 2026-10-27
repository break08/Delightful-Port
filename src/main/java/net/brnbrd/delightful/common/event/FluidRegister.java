package net.brnbrd.delightful.common.event;

import net.brnbrd.delightful.common.fluid.DelightfulFluids;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
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

    }
}
