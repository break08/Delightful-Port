package net.brnbrd.delightful.compat.brewinandchewin;

import net.brnbrd.delightful.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;


public class CaviarFluidType extends FluidType {
	public static final ResourceLocation CAVIAR_STILL_TEXTURE = Util.delight("block/caviar_still");
	public static final ResourceLocation CAVIAR_FLOWING_TEXTURE = Util.delight("block/caviar_flow");

	public CaviarFluidType() {
		super(FluidType.Properties.create()
			.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
			.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
			.sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
		);
	}
}