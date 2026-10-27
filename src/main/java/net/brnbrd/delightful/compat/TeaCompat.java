package net.brnbrd.delightful.compat;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class TeaCompat {
    public static Holder<MobEffect> getYellowTeaEffect() {
        return MobEffects.DAMAGE_RESISTANCE;
    }
}
