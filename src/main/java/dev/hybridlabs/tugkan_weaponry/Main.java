package dev.hybridlabs.tugkan_weaponry;

import com.mojang.logging.LogUtils;
import dev.hybridlabs.tugkan_weaponry.config.Config;
import dev.hybridlabs.tugkan_weaponry.registries.Registry;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(Main.MODID)
public class Main {
  public static final String MODID = "tugkans_weaponry";
  public static final Logger LOGGER = LogUtils.getLogger();

  public Main() {
    Registry.init();

    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }
}
