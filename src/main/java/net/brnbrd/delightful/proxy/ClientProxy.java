package net.brnbrd.delightful.proxy;

import net.brnbrd.delightful.compat.Modid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void start(IEventBus modBus) {
        super.start(modBus);
        modBus.register(this);
    }

    @SubscribeEvent
    public void setupClient(FMLClientSetupEvent e) {
        if (Modid.AS.loaded()) {
            //MinecraftForge.EVENT_BUS.register(new AppleSkinEventHandler());
        }
    }
}