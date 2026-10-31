package net.brnbrd.delightful.compat.aether;

import io.github.razordevs.deep_aether.init.DATiers;
import net.brnbrd.delightful.common.item.knife.Knives;
import net.brnbrd.delightful.common.item.knife.compat.aether.deep_aether.SkyjadeKnifeItem;
import net.brnbrd.delightful.common.item.knife.compat.aether.deep_aether.StratusKnifeItem;
import net.minecraft.world.item.Item;
import java.util.function.Supplier;

public class DeepAetherCompat {
    public static final Supplier<Item> SKYJADE = () -> new SkyjadeKnifeItem(Knives.props());
    public static final Supplier<Item> STRATUS = () -> new StratusKnifeItem(Knives.props(), DATiers.STRATUS);
}
