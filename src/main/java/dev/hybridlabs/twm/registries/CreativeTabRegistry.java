package dev.hybridlabs.twm.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.twm.Main.MODID;
import static dev.hybridlabs.twm.registries.ItemRegistry.*;

public class CreativeTabRegistry {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

  public static final RegistryObject<CreativeModeTab> ARMORY_TAB = CREATIVE_MODE_TABS.register("armors", () -> CreativeModeTab.builder()
    .title(Component.translatable("twm.itemgroup.armors"))
    .icon(() -> BRIGHTSTEEL_HELMET.get().getDefaultInstance())
    .displayItems((parameters, output) -> {
      output.accept(BRIGHTSTEEL_BOOTS.get());
      output.accept(BRIGHTSTEEL_LEGGINGS.get());
      output.accept(BRIGHTSTEEL_CHESTPLATE.get());
      output.accept(BRIGHTSTEEL_HELMET.get());
    }).build());
  
  public static final RegistryObject<CreativeModeTab> WEAPONRY_TAB = CREATIVE_MODE_TABS.register("weapons", () -> CreativeModeTab.builder()
    .title(Component.translatable("twm.itemgroup.weapons"))
    .icon(() -> SOULMETAL_SWORD.get().getDefaultInstance())
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
      output.accept(OBSIDIAN_TIPPED_DIAMOND_PICKAXE.get());
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
      output.accept(GILDED_NETHERITE_KNIFE.get());
      output.accept(BRIGHTSTEEL_KNIFE.get());
      output.accept(WOODEN_CLUB.get());
      output.accept(WOODEN_MACE.get());
      output.accept(COPPER_MACE.get());
      output.accept(IRON_MACE.get());
      output.accept(STEEL_MACE.get());
      output.accept(WOODEN_HAMMER.get());
      output.accept(STEEL_HAMMER.get());
      output.accept(TERRAPOTTA_FIST.get());
      output.accept(GAUNTILUS_FIST.get());
      output.accept(FIST_OF_THE_SEA_FIST.get());
      output.accept(SHULKER_GAUNTLET_FIST.get());
      output.accept(GLASS_RAPIER.get());
      output.accept(MACHUAHUITL_CLAYMORE.get());
      output.accept(SOULMETAL_SWORD.get());
      output.accept(KATANA.get());
      output.accept(THE_BLOODTHIRSTER_CLAYMORE.get());
      output.accept(BREAKER_BLADE.get());
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
      event.accept(WEAPON_TEMPLATE);
    } else if (event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS)) {
      event.accept(STEEL_BLOCK);
      event.accept(BEDROCK);
      event.accept(BRIGHTSTEEL_BLOCK);
      event.accept(ANCIENT_DEBRIS);
      event.accept(ANCIENT_DEBRIS_DEEPSLATE);
      event.accept(BEDROCK_BRICKS);
      event.accept(BEDROCK_BRICKS_UNBREAKABLE);
      event.accept(GOLD_ANCIENT_DEBRIS);
      event.accept(GOLD_ANCIENT_DEBRIS_NETHERRACK);
      event.accept(AURUMITE_BLOCK);
    }
  }
}
