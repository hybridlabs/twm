package dev.hybridlabs.tugkan_weaponry.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;
import static dev.hybridlabs.tugkan_weaponry.registries.ItemRegistry.*;

public class CreativeTabRegistry {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

  public static final RegistryObject<CreativeModeTab> WEAPONRY_TAB = CREATIVE_MODE_TABS.register("weaponry", () -> CreativeModeTab.builder()
    .title(Component.translatable("hybrid_weaponry.itemgroup.hybridweaponry"))
    .icon(() -> BRIGHTSTEEL_SWORD.get().getDefaultInstance())
    .displayItems((parameters, output) -> {
      output.accept(COPPER_SWORD.get());
      output.accept(COPPER_SHOVEL.get());
      output.accept(COPPER_PICKAXE.get());
      output.accept(COPPER_AXE.get());
      output.accept(STEEL_SWORD.get());
      output.accept(STEEL_SHOVEL.get());
      output.accept(STEEL_PICKAXE.get());
      output.accept(STEEL_AXE.get());
      output.accept(OBSIDIAN_EDGED_DIAMOND_SHOVEL.get());
      output.accept(OBSIDIAN_EDGED_DIAMOND_PICKAXE.get());
      output.accept(OBSIDIAN_EDGED_DIAMOND_AXE.get());
      output.accept(GILDED_NETHERITE_SWORD.get());
      output.accept(GILDED_NETHERITE_SHOVEL.get());
      output.accept(GILDED_NETHERITE_PICKAXE.get());
      output.accept(GILDED_NETHERITE_AXE.get());
      output.accept(BRIGHTSTEEL_SWORD.get());
      output.accept(BRIGHTSTEEL_SHOVEL.get());
      output.accept(BRIGHTSTEEL_PICKAXE.get());
      output.accept(BRIGHTSTEEL_AXE.get());
      output.accept(AURUM_SHOVEL.get());
      output.accept(AURUM_PICKAXE.get());
      output.accept(AURUM_AXE.get());
      output.accept(DIAMOND_KNIFE.get());
      output.accept(NETHERITE_KNIFE.get());
    }).build());

  public static void init(IEventBus modEventBus) {
    CREATIVE_MODE_TABS.register(modEventBus);
    modEventBus.addListener(CreativeTabRegistry::addCreative);
  }

  public static void addCreative(BuildCreativeModeTabContentsEvent event) {
    if (event.getTabKey().equals(CreativeModeTabs.INGREDIENTS)) {
      event.accept(AURUMITE_INGOT);
      event.accept(AURUMITE_SCRAP);
      event.accept(BEDROCK_SAMPLE);
      event.accept(BRIGHTSTEEL_INGOT);
      event.accept(OBSIDIAN_SHARD);
      event.accept(SHATTERED_GLASS);
      event.accept(STEEL_INGOT);
      event.accept(TITANITE_INGOT);
      event.accept(TITANITE_SCRAP);
    }
  }
}
