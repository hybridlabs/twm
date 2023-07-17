package dev.hybridlabs.weaponry;

import com.mojang.logging.LogUtils;
import dev.hybridlabs.weaponry.registries.Registry;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(Main.MODID)
public class Main {
  public static final String MODID = "hybrid_weaponry";
  public static final Logger LOGGER = LogUtils.getLogger();

  public Main() {
    Registry.init();

  }
}
