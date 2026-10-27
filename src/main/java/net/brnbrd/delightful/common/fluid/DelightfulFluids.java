package net.brnbrd.delightful.common.fluid;

import net.brnbrd.delightful.Delightful;
import net.brnbrd.delightful.compat.brewinandchewin.AgedRoeFluidType;
import net.brnbrd.delightful.compat.brewinandchewin.CaviarFluidType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DelightfulFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, Delightful.MODID);
    public static final DeferredRegister<FluidType> TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Delightful.MODID);

    public static final DeferredHolder<FluidType, FluidType> MATCHA_LATTE_TYPE = TYPES.register("matcha_latte_type",
            () -> new DFluidType(0xff7FA036));
    public static final DeferredHolder<Fluid, FlowingFluid> MATCHA_LATTE = FLUIDS.register("matcha_latte",
            () -> new BaseFlowingFluid.Source(DelightfulFluids.MATCHA_LATTE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MATCHA_LATTE = FLUIDS.register("flowing_matcha_latte",
            () -> new BaseFlowingFluid.Flowing(DelightfulFluids.MATCHA_LATTE_PROPERTIES));
    public static final BaseFlowingFluid.Properties MATCHA_LATTE_PROPERTIES = new BaseFlowingFluid.Properties(
            MATCHA_LATTE_TYPE,
            MATCHA_LATTE,
            FLOWING_MATCHA_LATTE
    );

    public static final DeferredHolder<FluidType, FluidType> ENDER_NECTAR_TYPE = TYPES.register("ender_nectar_type",
            () -> new DFluidType(0xff316364));
    public static final DeferredHolder<Fluid, FlowingFluid> ENDER_NECTAR = FLUIDS.register("ender_nectar",
            () -> new BaseFlowingFluid.Source(DelightfulFluids.ENDER_NECTAR_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ENDER_NECTAR = FLUIDS.register("flowing_ender_nectar",
            () -> new BaseFlowingFluid.Flowing(DelightfulFluids.ENDER_NECTAR_PROPERTIES));
    public static final BaseFlowingFluid.Properties ENDER_NECTAR_PROPERTIES = new BaseFlowingFluid.Properties(
            ENDER_NECTAR_TYPE,
            ENDER_NECTAR,
            FLOWING_ENDER_NECTAR
    );

    public static final DeferredHolder<FluidType, FluidType> AZALEA_TEA_TYPE = TYPES.register("azalea_tea_type",
            () -> new DFluidType(0xffd3619c));
    public static final DeferredHolder<Fluid, FlowingFluid> AZALEA_TEA = FLUIDS.register("azalea_tea",
            () -> new BaseFlowingFluid.Source(DelightfulFluids.AZALEA_TEA_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_AZALEA_TEA = FLUIDS.register("flowing_azalea_tea",
            () -> new BaseFlowingFluid.Flowing(DelightfulFluids.AZALEA_TEA_PROPERTIES));
    public static final BaseFlowingFluid.Properties AZALEA_TEA_PROPERTIES = new BaseFlowingFluid.Properties(
            AZALEA_TEA_TYPE,
            AZALEA_TEA,
            FLOWING_AZALEA_TEA
    );

    public static final DeferredHolder<FluidType, FluidType> LAVENDER_TEA_TYPE = TYPES.register("lavender_tea_type",
            () -> new DFluidType(0xff9e79a2));
    public static final DeferredHolder<Fluid, FlowingFluid> LAVENDER_TEA = FLUIDS.register("lavender_tea",
            () -> new BaseFlowingFluid.Source(DelightfulFluids.LAVENDER_TEA_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LAVENDER_TEA = FLUIDS.register("flowing_lavender_tea",
            () -> new BaseFlowingFluid.Flowing(DelightfulFluids.LAVENDER_TEA_PROPERTIES));
    public static final BaseFlowingFluid.Properties LAVENDER_TEA_PROPERTIES = new BaseFlowingFluid.Properties(
            LAVENDER_TEA_TYPE,
            LAVENDER_TEA,
            FLOWING_LAVENDER_TEA
    );

    public static final DeferredHolder<FluidType, FluidType> PRICKLY_PEAR_JUICE_TYPE = TYPES.register("prickly_pear_juice_type",
            () -> new DFluidType(0xffb83546));
    public static final DeferredHolder<Fluid, FlowingFluid> PRICKLY_PEAR_JUICE = FLUIDS.register("prickly_pear_juice",
            () -> new BaseFlowingFluid.Source(DelightfulFluids.PRICKLY_PEAR_JUICE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_PRICKLY_PEAR_JUICE = FLUIDS.register("flowing_prickly_pear_juice",
            () -> new BaseFlowingFluid.Flowing(DelightfulFluids.PRICKLY_PEAR_JUICE_PROPERTIES));
    public static final BaseFlowingFluid.Properties PRICKLY_PEAR_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
            PRICKLY_PEAR_JUICE_TYPE,
            PRICKLY_PEAR_JUICE,
            FLOWING_PRICKLY_PEAR_JUICE
    );

    public static final DeferredHolder<FluidType, FluidType> LONG_PRICKLY_PEAR_JUICE_TYPE = TYPES.register("long_prickly_pear_juice_type",
            () -> new DFluidType(0xffb83546));
    public static final DeferredHolder<Fluid, FlowingFluid> LONG_PRICKLY_PEAR_JUICE = FLUIDS.register("long_prickly_pear_juice",
            () -> new BaseFlowingFluid.Source(DelightfulFluids.LONG_PRICKLY_PEAR_JUICE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LONG_PRICKLY_PEAR_JUICE = FLUIDS.register("flowing_long_prickly_pear_juice",
            () -> new BaseFlowingFluid.Flowing(DelightfulFluids.LONG_PRICKLY_PEAR_JUICE_PROPERTIES));
    public static final BaseFlowingFluid.Properties LONG_PRICKLY_PEAR_JUICE_PROPERTIES = new BaseFlowingFluid.Properties(
            LONG_PRICKLY_PEAR_JUICE_TYPE,
            LONG_PRICKLY_PEAR_JUICE,
            FLOWING_LONG_PRICKLY_PEAR_JUICE
    );

    public static final DeferredHolder<FluidType, FluidType> AGED_ROE_TYPE = TYPES.register("aged_roe_type",
            AgedRoeFluidType::new);
    public static final DeferredHolder<Fluid, FlowingFluid> AGED_ROE = FLUIDS.register("aged_roe",
            () -> new BaseFlowingFluid.Source(DelightfulFluids.AGED_ROE_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_AGED_ROE = FLUIDS.register("flowing_aged_roe",
            () -> new BaseFlowingFluid.Flowing(DelightfulFluids.AGED_ROE_PROPERTIES));
    public static final BaseFlowingFluid.Properties AGED_ROE_PROPERTIES = new BaseFlowingFluid.Properties(
            AGED_ROE_TYPE,
            AGED_ROE,
            FLOWING_AGED_ROE
    );

    public static final DeferredHolder<FluidType, FluidType> CAVIAR_TYPE = TYPES.register("caviar_type",
            CaviarFluidType::new);
    public static final DeferredHolder<Fluid, FlowingFluid> CAVIAR = FLUIDS.register("caviar",
            () -> new BaseFlowingFluid.Source(DelightfulFluids.CAVIAR_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_CAVIAR = FLUIDS.register("flowing_caviar",
            () -> new BaseFlowingFluid.Flowing(DelightfulFluids.CAVIAR_PROPERTIES));
    public static final BaseFlowingFluid.Properties CAVIAR_PROPERTIES = new BaseFlowingFluid.Properties(
            CAVIAR_TYPE,
            CAVIAR,
            FLOWING_CAVIAR
    );

    public static final DeferredHolder<FluidType, FluidType> EGGNOG_TYPE = TYPES.register("eggnog_type",
            () -> new DFluidType(0xffD8D5B6));
    public static final DeferredHolder<Fluid, FlowingFluid> EGGNOG = FLUIDS.register("eggnog",
            () -> new BaseFlowingFluid.Source(DelightfulFluids.EGGNOG_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_EGGNOG = FLUIDS.register("flowing_eggnog",
            () -> new BaseFlowingFluid.Flowing(DelightfulFluids.EGGNOG_PROPERTIES));
    public static final BaseFlowingFluid.Properties EGGNOG_PROPERTIES = new BaseFlowingFluid.Properties(
            EGGNOG_TYPE,
            EGGNOG,
            FLOWING_EGGNOG
    );

    public static void create(IEventBus bus) {
        FLUIDS.register(bus);
        TYPES.register(bus);
    }
}
