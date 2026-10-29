package net.brnbrd.delightful.proxy;

import net.brnbrd.delightful.common.event.ModEvents;
import net.brnbrd.delightful.common.event.NeoForgeEvents;
import net.brnbrd.delightful.common.event.PieEvents;
import net.brnbrd.delightful.common.loot.DelightfulLootItemConditions;
import net.brnbrd.delightful.common.loot.DelightfulLootModifiers;
import net.brnbrd.delightful.data.gen.Generators;
import net.neoforged.bus.api.IEventBus;

public class CommonProxy {
    public void start(IEventBus modBus) {
        modBus.register(new NeoForgeEvents());
        modBus.register(new PieEvents());
        modBus.register(new ModEvents());
        modBus.register(Generators.class);
        DelightfulLootItemConditions.create(modBus);
        DelightfulLootModifiers.create(modBus);
    }
}
