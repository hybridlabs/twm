package dev.hybridlabs.weaponry.registries;

import dev.hybridlabs.weaponry.items.HybridTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.weaponry.Main.MODID;

public class ItemRegistry {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
  public static final RegistryObject<Item> AURUMITE_INGOT = ITEMS.register("aurimite_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_INGOT = ITEMS.register("brightsteel_ingot", () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> AURUM_AXE = ITEMS.register("aurum_axe", () -> new AxeItem(HybridTiers.AURUM, 1.0F, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_AXE = ITEMS.register("brightsteel_axe", () -> new AxeItem(HybridTiers.AURUM, 1.0F, -3.0F, new Item.Properties()));

  public static void init(IEventBus modEventBus) {
    ITEMS.register(modEventBus);
  }
}
