package dev.hybridlabs.tugkan_weaponry.registries;

import dev.hybridlabs.tugkan_weaponry.items.tiers.WeaponryFistTiers;
import dev.hybridlabs.tugkan_weaponry.items.armor.BrightsteelArmor;
import dev.hybridlabs.tugkan_weaponry.items.tiers.WeaponrySwordTiers;
import dev.hybridlabs.tugkan_weaponry.items.weapons.*;
import dev.hybridlabs.tugkan_weaponry.items.tiers.WeaponryToolTiers;
import dev.hybridlabs.tugkan_weaponry.items.weapons.fists.FistOfTheSeaItem;
import dev.hybridlabs.tugkan_weaponry.items.weapons.fists.GauntilusFistItem;
import dev.hybridlabs.tugkan_weaponry.items.weapons.fists.ShulkerGauntletFistItem;
import dev.hybridlabs.tugkan_weaponry.items.weapons.fists.TerrapottaFistItem;
import dev.hybridlabs.tugkan_weaponry.items.weapons.swords.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;

public class ItemRegistry {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
  
  public static final RegistryObject<Item> AURUMITE_INGOT = ITEMS.register("aurumite_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> AURUMITE_SCRAP = ITEMS.register("aurumite_scrap", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> BEDROCK_SAMPLE = ITEMS.register("bedrock_sample", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_INGOT = ITEMS.register("brightsteel_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> OBSIDIAN_SHARD = ITEMS.register("obsidian_shard", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> SHATTERED_GLASS = ITEMS.register("shattered_glass", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> TITANITE_INGOT = ITEMS.register("titanite_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> TITANITE_SCRAP = ITEMS.register("titanite_scrap", () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> BEDROCK = ITEMS.register("bedrock", () -> new BlockItem(BlockRegistry.BEDROCK.get(), new Item.Properties()));
  public static final RegistryObject<Item> BEDROCK_BRICKS = ITEMS.register("bedrock_bricks", () -> new BlockItem(BlockRegistry.BEDROCK_BRICKS.get(), new Item.Properties()));
  public static final RegistryObject<Item> BEDROCK_BRICKS_UNBREAKABLE = ITEMS.register("bedrock_bricks_unbreakable", () -> new BlockItem(BlockRegistry.BEDROCK_BRICKS_UNBREAKABLE.get(), new Item.Properties()));
  
  public static final RegistryObject<Item> ANCIENT_DEBRIS = ITEMS.register("ancient_debris", () -> new BlockItem(BlockRegistry.ANCIENT_DEBRIS.get(), new Item.Properties()));
  public static final RegistryObject<Item> ANCIENT_DEBRIS_DEEPSLATE = ITEMS.register("ancient_debris_deepslate", () -> new BlockItem(BlockRegistry.ANCIENT_DEBRIS_DEEPSLATE.get(), new Item.Properties()));
  public static final RegistryObject<Item> GOLD_ANCIENT_DEBRIS = ITEMS.register("gold_ancient_debris", () -> new BlockItem(BlockRegistry.GOLD_ANCIENT_DEBRIS.get(), new Item.Properties()));
  public static final RegistryObject<Item> GOLD_ANCIENT_DEBRIS_NETHERRACK = ITEMS.register("gold_ancient_debris_netherrack", () -> new BlockItem(BlockRegistry.GOLD_ANCIENT_DEBRIS_NETHERRACK.get(), new Item.Properties()));
  
  public static final RegistryObject<Item> STEEL_BLOCK = ITEMS.register("steel_block", () -> new BlockItem(BlockRegistry.STEEL_BLOCK.get(), new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_BLOCK = ITEMS.register("brightsteel_block", () -> new BlockItem(BlockRegistry.BRIGHTSTEEL_BLOCK.get(), new Item.Properties()));
  public static final RegistryObject<Item> AURUMITE_BLOCK = ITEMS.register("aurumite_block", () -> new BlockItem(BlockRegistry.AURUMITE_BLOCK.get(), new Item.Properties()));
  
  public static final RegistryObject<Item> WOODEN_CLUB = ITEMS.register("wooden_club_mace", () -> new MaceItem(Tiers.WOOD, 5.0F, -2.8F, new Item.Properties().defaultDurability(100)));
  public static final RegistryObject<Item> WOODEN_MACE = ITEMS.register("wooden_mace", () -> new MaceItem(Tiers.WOOD, 7.0F, -2.8F, new Item.Properties().defaultDurability(200)));
  public static final RegistryObject<Item> COPPER_MACE = ITEMS.register("copper_mace", () -> new MaceItem(WeaponryToolTiers.COPPER, 6.0F, -2.8F, new Item.Properties().defaultDurability(500)));
  public static final RegistryObject<Item> IRON_MACE = ITEMS.register("iron_mace", () -> new MaceItem(Tiers.IRON, 5.0F, -2.8F, new Item.Properties().defaultDurability(500)));
  public static final RegistryObject<Item> STEEL_MACE = ITEMS.register("steel_mace", () -> new MaceItem(WeaponryToolTiers.STEEL, 7.0F, -2.8F, new Item.Properties().defaultDurability(2000)));
  
  public static final RegistryObject<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer", () -> new HammerItem(Tiers.WOOD, 5.0F, -2.8F, new Item.Properties().defaultDurability(200)));
  public static final RegistryObject<Item> STEEL_HAMMER = ITEMS.register("steel_hammer", () -> new HammerItem(WeaponryToolTiers.STEEL, 9.0F, -2.8F, new Item.Properties().defaultDurability(2000)));
  
  public static final RegistryObject<Item> GLASS_RAPIER = ITEMS.register("glass_rapier", () -> new GlassRapierItem(WeaponrySwordTiers.GLASS, 1.0F, -1.0F, new Item.Properties().defaultDurability(0)));
  public static final RegistryObject<Item> MACHUAHUITL_CLAYMORE = ITEMS.register("machuahuitl_claymore", () -> new Machuahuitltem(WeaponrySwordTiers.MACHUAHUITL, 1.0F, -1.0F, new Item.Properties()));
  public static final RegistryObject<Item> SOULMETAL_SWORD = ITEMS.register("soulmetal_sword", () -> new SoulmetalSwordItem(WeaponrySwordTiers.SOULMETAL, 1.0F, -1.0F, new Item.Properties()));
  public static final RegistryObject<Item> KATANA = ITEMS.register("katana", () -> new KatanaItem(WeaponrySwordTiers.KATANA, 1.0F, -1.0F, new Item.Properties()));
  public static final RegistryObject<Item> BLOODTHIRSTER_CLAYMORE = ITEMS.register("bloodthirster_claymore", () -> new BloodthirsterItem(WeaponrySwordTiers.BLOODTHIRSTER, 1.0F, -1.0F, new Item.Properties()));
  public static final RegistryObject<Item> BREAKER_BLADE = ITEMS.register("breaker_blade_claymore", () -> new BreakerBladeItem(WeaponrySwordTiers.BREAKER, 1.0F, -1.0F, new Item.Properties()));
  
  public static final RegistryObject<Item> TERRAPOTTA_FIST = ITEMS.register("terrapotta_fist", () -> new TerrapottaFistItem(WeaponryFistTiers.TERRAPOTTA, 3.0F, -1.0F, new Item.Properties()));
  public static final RegistryObject<Item> GAUNTILUS_FIST = ITEMS.register("gauntilus_fist", () -> new GauntilusFistItem(WeaponryFistTiers.NAUTILUS, 3.0F, -1.0F, new Item.Properties()));
  public static final RegistryObject<Item> FIST_OF_THE_SEA_FIST = ITEMS.register("fist_of_the_sea_fist", () -> new FistOfTheSeaItem(WeaponryFistTiers.HEART_OF_THE_SEA, 3.0F, -1.0F, new Item.Properties()));
  public static final RegistryObject<Item> SHULKER_GAUNTLET_FIST = ITEMS.register("shulker_gauntlet_fist", () -> new ShulkerGauntletFistItem(WeaponryFistTiers.SHULKER, 3.0F, -1.0F, new Item.Properties()));
  
  public static final RegistryObject<Item> DIAMOND_KNIFE = ITEMS.register("diamond_knife", () -> new KnifeItem(Tiers.DIAMOND, 2.0F, -2.0F, new Item.Properties()));
  public static final RegistryObject<Item> NETHERITE_KNIFE = ITEMS.register("netherite_knife", () -> new KnifeItem(Tiers.NETHERITE, 2.5F, -2.0F, new Item.Properties()));
  public static final RegistryObject<Item> GILDED_NETHERITE_KNIFE = ITEMS.register("gilded_netherite_knife", () -> new KnifeItem(WeaponryToolTiers.GILDED_NETHERITE, 2.5F, -2.0F, new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_KNIFE = ITEMS.register("brightsteel_knife", () -> new KnifeItem(WeaponryToolTiers.BRIGHTSTEEL, 2.0F, -2.0F, new Item.Properties()));

  public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(WeaponryToolTiers.COPPER, 3, -2.4F, new Item.Properties()));
  public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(WeaponryToolTiers.COPPER, 1.5F, -3.0F, new Item.Properties()));
  public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(WeaponryToolTiers.COPPER, 1, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(WeaponryToolTiers.COPPER, 7.0F, -3.2F, new Item.Properties()));

  public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(WeaponryToolTiers.STEEL, 3, -2.4F, new Item.Properties()));
  public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(WeaponryToolTiers.STEEL, 1.5F, -3.0F, new Item.Properties()));
  public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(WeaponryToolTiers.STEEL, 1, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(WeaponryToolTiers.STEEL, 6.0F, -3.1F, new Item.Properties()));

  public static final RegistryObject<Item> OBSIDIAN_EDGED_DIAMOND_SHOVEL = ITEMS.register("obsidian_edged_diamond_shovel", () -> new ShovelItem(WeaponryToolTiers.OBSIDIAN_EDGED_DIAMOND, 1.5F, -3.0F, new Item.Properties()));
  public static final RegistryObject<Item> OBSIDIAN_EDGED_DIAMOND_PICKAXE = ITEMS.register("obsidian_edged_diamond_pickaxe", () -> new PickaxeItem(WeaponryToolTiers.OBSIDIAN_EDGED_DIAMOND, 1, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> OBSIDIAN_EDGED_DIAMOND_AXE = ITEMS.register("obsidian_edged_diamond_axe", () -> new AxeItem(WeaponryToolTiers.OBSIDIAN_EDGED_DIAMOND, 5.0F, -3.0F, new Item.Properties()));

  public static final RegistryObject<Item> GILDED_NETHERITE_SWORD = ITEMS.register("gilded_netherite_sword", () -> new SwordItem(WeaponryToolTiers.GILDED_NETHERITE, 3, -2.4F, new Item.Properties()));
  public static final RegistryObject<Item> GILDED_NETHERITE_SHOVEL = ITEMS.register("gilded_netherite_shovel", () -> new ShovelItem(WeaponryToolTiers.GILDED_NETHERITE, 1.5F, -3.0F, new Item.Properties()));
  public static final RegistryObject<Item> GILDED_NETHERITE_PICKAXE = ITEMS.register("gilded_netherite_pickaxe", () -> new PickaxeItem(WeaponryToolTiers.GILDED_NETHERITE, 1, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> GILDED_NETHERITE_AXE = ITEMS.register("gilded_netherite_axe", () -> new AxeItem(WeaponryToolTiers.GILDED_NETHERITE, 5.0F, -3.0F, new Item.Properties()));
  
  public static final RegistryObject<Item> BRIGHTSTEEL_BOOTS = ITEMS.register("brightsteel_boots", BrightsteelArmor.Boots::new);
  public static final RegistryObject<Item> BRIGHTSTEEL_LEGGINGS = ITEMS.register("brightsteel_leggings", BrightsteelArmor.Leggings::new);
  public static final RegistryObject<Item> BRIGHTSTEEL_CHESTPLATE = ITEMS.register("brightsteel_chestplate", BrightsteelArmor.Chestplate::new);
  public static final RegistryObject<Item> BRIGHTSTEEL_HELMET = ITEMS.register("brightsteel_helmet", BrightsteelArmor.Helmet::new);
  public static final RegistryObject<Item> BRIGHTSTEEL_SWORD = ITEMS.register("brightsteel_sword", () -> new SwordItem(WeaponryToolTiers.BRIGHTSTEEL, 3, -2.4F, new Item.Properties()));
  public static final RegistryObject<Item> BRIGHTSTEEL_SHOVEL = ITEMS.register("brightsteel_shovel", () -> new ShovelItem(WeaponryToolTiers.BRIGHTSTEEL, 1.5F, -2.8F, new Item.Properties().defaultDurability(16382)));
  public static final RegistryObject<Item> BRIGHTSTEEL_PICKAXE = ITEMS.register("brightsteel_pickaxe", () -> new PickaxeItem(WeaponryToolTiers.BRIGHTSTEEL, 1, -2.8F, new Item.Properties().defaultDurability(16382)));
  public static final RegistryObject<Item> BRIGHTSTEEL_AXE = ITEMS.register("brightsteel_axe", () -> new AxeItem(WeaponryToolTiers.BRIGHTSTEEL, 5.0F, -3.0F, new Item.Properties()));

  public static final RegistryObject<Item> AURUM_SHOVEL = ITEMS.register("aurum_shovel", () -> new ShovelItem(WeaponryToolTiers.AURUM, 1.5F, -2.8F, new Item.Properties()));
  public static final RegistryObject<Item> AURUM_PICKAXE = ITEMS.register("aurum_pickaxe", () -> new PickaxeItem(WeaponryToolTiers.AURUM, 1, -2.6F, new Item.Properties()));
  public static final RegistryObject<Item> AURUM_AXE = ITEMS.register("aurum_axe", () -> new AxeItem(WeaponryToolTiers.AURUM, 5.0F, -3.0F, new Item.Properties()));
  
  public static void init(IEventBus modEventBus) {
    ITEMS.register(modEventBus);
  }
}
