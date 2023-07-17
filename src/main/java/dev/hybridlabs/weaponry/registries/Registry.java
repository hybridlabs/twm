package dev.hybridlabs.weaponry.registries;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registry {
  public static void init() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ItemRegistry.init(modEventBus);
    CreativeTabRegistry.init(modEventBus);
    TierRegistry.init();
    ConfigRegistry.init();
  }
}
