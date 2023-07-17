package dev.hybridlabs.weaponry.registries;

import dev.hybridlabs.weaponry.config.Config;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class ConfigRegistry {
  public static void init() {
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }
}
