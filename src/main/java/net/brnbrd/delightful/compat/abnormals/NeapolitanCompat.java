package net.brnbrd.delightful.compat.abnormals;

import net.brnbrd.delightful.compat.Modid;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.Objects;

public class NeapolitanCompat {
    public static Holder<MobEffect> getSugarRush() {
        return BuiltInRegistries.MOB_EFFECT.wrapAsHolder(Objects.requireNonNull(Modid.N.effect("sugar_rush", MobEffects.MOVEMENT_SPEED.value())));
    }
}
