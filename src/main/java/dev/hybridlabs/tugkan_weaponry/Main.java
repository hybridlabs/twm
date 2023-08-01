package dev.hybridlabs.tugkan_weaponry;

import com.mojang.logging.LogUtils;
import dev.hybridlabs.tugkan_weaponry.registries.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod(Main.MODID)
public class Main {
  public static final String MODID = "tugkans_weaponry";
  public static final Logger LOGGER = LogUtils.getLogger();

  public Main() {
    Registry.init();
    MinecraftForge.EVENT_BUS.register(this);
  }
  
  public static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
  public static void queueServerWork(int tick, Runnable action) {
    workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
  }
  
  @SubscribeEvent
  public void tick(TickEvent.ServerTickEvent event) {
    if (event.phase == TickEvent.Phase.END) {
      List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
      workQueue.forEach(work -> {
        work.setValue(work.getValue() - 1);
        if (work.getValue() == 0) actions.add(work);
      });
      actions.forEach(e -> e.getKey().run());
      workQueue.removeAll(actions);
    }
  }
}
