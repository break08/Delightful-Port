package net.brnbrd.delightful.common.crafting;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.brnbrd.delightful.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.neoforged.neoforge.common.conditions.ICondition;
import org.jetbrains.annotations.NotNull;

public class EnabledCondition implements ICondition {
    private static final ResourceLocation NAME = Util.delight("enabled");
    private final String value;

    public EnabledCondition(String value) {
        this.value = value;
    }

    /*
    @Override
    public ResourceLocation getID() {
        return NAME;
    }

     */

    @Override
    public boolean test(ICondition.IContext context) {
        return Util.configEnabled(this.value);
    }

    public static final MapCodec<EnabledCondition> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            Codec.STRING.fieldOf("value").forGetter(c -> c.value)
    ).apply(i, EnabledCondition::new));

    @Override
    public @NotNull MapCodec<? extends ICondition> codec() {
        return CODEC;
    }

    @Override
    public String toString() {
        return "enabled(\"" + this.value + "\")";
    }

}
