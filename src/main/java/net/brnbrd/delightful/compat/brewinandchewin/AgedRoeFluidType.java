package net.brnbrd.delightful.compat.brewinandchewin;

import net.brnbrd.delightful.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

public class AgedRoeFluidType extends FluidType {
	public static final ResourceLocation AGED_ROE_STILL_TEXTURE = Util.delight("block/aged_roe_still");
	public static final ResourceLocation AGED_ROE_FLOWING_TEXTURE = Util.delight("block/aged_roe_flow");

	public AgedRoeFluidType() {
		super(FluidType.Properties.create()
			.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
			.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
			.sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
		);
	}
}