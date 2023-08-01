package dev.hybridlabs.tugkan_weaponry.registries;

import dev.hybridlabs.tugkan_weaponry.items.tiers.WeaponryToolTiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registry {
  public static void init() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ItemRegistry.init(modEventBus);
    BlockRegistry.init(modEventBus);
    CreativeTabRegistry.init(modEventBus);
    WeaponryToolTiers.init();
    EnchantmentRegistry.init(modEventBus);
    SoundRegistry.init(modEventBus);
  }
}
