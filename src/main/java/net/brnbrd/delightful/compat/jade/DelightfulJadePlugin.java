package net.brnbrd.delightful.compat.jade;

import net.brnbrd.delightful.common.block.CantaloupePlantBlock;
import net.brnbrd.delightful.common.block.DPieBlock;
import net.brnbrd.delightful.common.block.SalmonberryBushBlock;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;

@WailaPlugin
public class DelightfulJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        // Register data providers and config options here
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(DMushroomColonyAge.INSTANCE, MushroomColonyBlock.class);
        registration.registerBlockComponent(DCropProgress.INSTANCE, SalmonberryBushBlock.class);
        registration.registerBlockComponent(DCropProgress.INSTANCE, CantaloupePlantBlock.class);
        registration.registerBlockComponent(DPieIcons.INSTANCE, DPieBlock.class);
    }
}
