package dev.hybridlabs.twm.registries;

import dev.hybridlabs.twm.items.tiers.WeaponryFistTiers;
import dev.hybridlabs.twm.items.tiers.WeaponrySwordTiers;
import dev.hybridlabs.twm.items.tiers.WeaponryToolTiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registry {
  public static void init() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ItemRegistry.init(modEventBus);
    BlockRegistry.init(modEventBus);
    CreativeTabRegistry.init(modEventBus);
    
    WeaponryToolTiers.init();
    WeaponryFistTiers.init();
    WeaponrySwordTiers.init();
    
    EnchantmentRegistry.init(modEventBus);
    SoundRegistry.init(modEventBus);
  }
}
