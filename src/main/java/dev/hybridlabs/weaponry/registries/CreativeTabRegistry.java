package dev.hybridlabs.weaponry.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.weaponry.Main.MODID;
import static dev.hybridlabs.weaponry.registries.ItemRegistry.*;

public class CreativeTabRegistry {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

  public static final RegistryObject<CreativeModeTab> WEAPONRY_TAB = CREATIVE_MODE_TABS.register("hybridweaponry", () -> CreativeModeTab.builder()
    .title(Component.translatable("hybrid_weaponry.itemgroup.hybridweaponry"))
    .withTabsBefore(CreativeModeTabs.COMBAT)
    .icon(() -> AURUMITE_INGOT.get().getDefaultInstance())
    .displayItems((parameters, output) -> {
      output.accept(AURUMITE_INGOT.get());
    }).build());

  public static void init(IEventBus modEventBus) {
    CREATIVE_MODE_TABS.register(modEventBus);
    modEventBus.addListener(CreativeTabRegistry::addCreative);
  }

  public static void addCreative(BuildCreativeModeTabContentsEvent event) {
    if (event.getTabKey().equals(WEAPONRY_TAB.getKey())) {
      event.accept(AURUMITE_INGOT);
      event.accept(BRIGHTSTEEL_INGOT);
      event.accept(AURUM_AXE);
      event.accept(BRIGHTSTEEL_AXE);
    }
  }
}
