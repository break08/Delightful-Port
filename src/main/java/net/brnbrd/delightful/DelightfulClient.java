package net.brnbrd.delightful;

import net.brnbrd.delightful.proxy.ClientProxy;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = Delightful.MODID, dist = Dist.CLIENT)
public class DelightfulClient {
    public DelightfulClient(IEventBus modEventBus, ModContainer modContainer) {
        ClientProxy clientProxy = new ClientProxy();
        clientProxy.start(modEventBus);
        Delightful.proxy = clientProxy;
    }
}
