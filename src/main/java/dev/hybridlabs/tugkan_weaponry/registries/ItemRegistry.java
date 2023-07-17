package dev.hybridlabs.tugkan_weaponry.registries;

import dev.hybridlabs.tugkan_weaponry.items.WeaponryTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;

public class ItemRegistry {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
  public static final RegistryObject<Item> AURUMITE_INGOT = ITEMS.register("aurimite_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> AURUMITE_SCRAP = ITEMS.register("aurimite_scrap", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> BEDROCK_SAMPLE = ITEMS.register("bedrock_sample", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_INGOT = ITEMS.register("brightsteel_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> OBSIDIAN_SHARD = ITEMS.register("obsidian_shard", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> SHATTERED_GLASS = ITEMS.register("shattered_glass", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> TITANITE_INGOT = ITEMS.register("titanite_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> TITANITE_SCRAP = ITEMS.register("titanite_scrap", () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> DIAMOND_KNIFE = ITEMS.register("diamond_knife", () -> new SwordItem(Tiers.DIAMOND, 3, -6.0F, new Item.Properties()));
  public static final RegistryObject<Item> NETHERITE_KNIFE = ITEMS.register("netherite_knife", () -> new SwordItem(Tiers.NETHERITE, 2, -7.0F, new Item.Properties()));

  public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(WeaponryTiers.COPPER, 3, -2.4F, new Item.Properties()));
  public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(WeaponryTiers.COPPER, 1.5F, -3.0F, new Item.Properties()));
  public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(WeaponryTiers.COPPER, 1, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(WeaponryTiers.COPPER, 7.0F, -3.2F, new Item.Properties()));

  public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(WeaponryTiers.STEEL, 3, -2.4F, new Item.Properties()));
  public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(WeaponryTiers.STEEL, 1.5F, -3.0F, new Item.Properties()));
  public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(WeaponryTiers.STEEL, 1, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(WeaponryTiers.STEEL, 6.0F, -3.1F, new Item.Properties()));

  public static final RegistryObject<Item> OBSIDIAN_EDGED_DIAMOND_SHOVEL = ITEMS.register("obsidian_edged_diamond_shovel", () -> new ShovelItem(WeaponryTiers.OBSIDIAN_EDGED_DIAMOND, 1.5F, -3.0F, new Item.Properties()));
  public static final RegistryObject<Item> OBSIDIAN_EDGED_DIAMOND_PICKAXE = ITEMS.register("obsidian_edged_diamond_pickaxe", () -> new PickaxeItem(WeaponryTiers.OBSIDIAN_EDGED_DIAMOND, 1, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> OBSIDIAN_EDGED_DIAMOND_AXE = ITEMS.register("obsidian_edged_diamond_axe", () -> new AxeItem(WeaponryTiers.OBSIDIAN_EDGED_DIAMOND, 5.0F, -3.0F, new Item.Properties()));

  public static final RegistryObject<Item> GILDED_NETHERITE_SWORD = ITEMS.register("gilded_netherite_sword", () -> new SwordItem(WeaponryTiers.GILDED_NETHERITE, 3, -2.4F, new Item.Properties()));
  public static final RegistryObject<Item> GILDED_NETHERITE_SHOVEL = ITEMS.register("gilded_netherite_shovel", () -> new ShovelItem(WeaponryTiers.GILDED_NETHERITE, 1.5F, -3.0F, new Item.Properties()));
  public static final RegistryObject<Item> GILDED_NETHERITE_PICKAXE = ITEMS.register("gilded_netherite_pickaxe", () -> new PickaxeItem(WeaponryTiers.GILDED_NETHERITE, 1, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> GILDED_NETHERITE_AXE = ITEMS.register("gilded_netherite_axe", () -> new AxeItem(WeaponryTiers.GILDED_NETHERITE, 5.0F, -3.0F, new Item.Properties()));

  public static final RegistryObject<Item> BRIGHTSTEEL_SWORD = ITEMS.register("brightsteel_sword", () -> new SwordItem(WeaponryTiers.BRIGHTSTEEL, 3, -2.4F, new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_SHOVEL = ITEMS.register("brightsteel_shovel", () -> new ShovelItem(WeaponryTiers.BRIGHTSTEEL, 1.5F, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_PICKAXE = ITEMS.register("brightsteel_pickaxe", () -> new PickaxeItem(WeaponryTiers.BRIGHTSTEEL, 1, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_AXE = ITEMS.register("brightsteel_axe", () -> new AxeItem(WeaponryTiers.BRIGHTSTEEL, 5.0F, -3.0F, new Item.Properties()));

  public static final RegistryObject<Item> AURUM_SHOVEL = ITEMS.register("aurum_shovel", () -> new ShovelItem(WeaponryTiers.AURUM, 1.5F, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> AURUM_PICKAXE = ITEMS.register("aurum_pickaxe", () -> new PickaxeItem(WeaponryTiers.AURUM, 1, -2.6F, new Item.Properties()));
  public static final RegistryObject<Item> AURUM_AXE = ITEMS.register("aurum_axe", () -> new AxeItem(WeaponryTiers.AURUM, 5.0F, -3.0F, new Item.Properties()));

  public static void init(IEventBus modEventBus) {
    ITEMS.register(modEventBus);
  }
}
