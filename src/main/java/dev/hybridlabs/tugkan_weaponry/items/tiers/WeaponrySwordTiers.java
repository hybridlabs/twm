package dev.hybridlabs.tugkan_weaponry.items.tiers;

import dev.hybridlabs.tugkan_weaponry.registries.ItemRegistry;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static dev.hybridlabs.tugkan_weaponry.items.RegisterTierUtils.registerTier;
import static dev.hybridlabs.tugkan_weaponry.registries.TagRegistry.NEEDS_FIST;

@SuppressWarnings("deprecation")
public enum WeaponrySwordTiers implements Tier {
  SHATTERED_GLASS(10, 0f, -2.0f, 1, 0, () -> Ingredient.EMPTY),
  GLASS(0, 4f, 1f, 1, 22, () -> Ingredient.EMPTY),
  MACHUAHUITL(400, 4f, 6f, 1, 2, () -> Ingredient.of(ItemRegistry.OBSIDIAN_SHARD.get())),
  SOULMETAL(1000, 4.0F, 3.0F, 1, 2, () -> Ingredient.EMPTY),
  KATANA(2031, 4f, 2f, 1, 15, () -> Ingredient.EMPTY),
  BLOODTHIRSTER(3084, 4f, 6f, 1, 15, () -> Ingredient.of(Items.NETHERITE_INGOT)),
  BREAKER(4096, 4f, 16f, 4, 15, () -> Ingredient.of(Items.NETHERITE_INGOT));
  
  private final int level;
  private final int uses;
  private final float speed;
  private final float damage;
  private final int enchantmentValue;
  private final LazyLoadedValue<Ingredient> repairIngredient;
  
  WeaponrySwordTiers(int durability, float speed, float damage, int levelTier, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
    this.uses = durability;
    this.level = levelTier;
    this.speed = speed;
    this.damage = damage;
    this.enchantmentValue = enchantmentValue;
    this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
  }
  
  public int getUses() {
    return this.uses;
  }
  
  public float getSpeed() {
    return this.speed;
  }
  
  public float getAttackDamageBonus() {
    return this.damage;
  }
  
  public int getLevel() {
    return this.level;
  }
  
  public int getEnchantmentValue() {
    return this.enchantmentValue;
  }
  
  public @NotNull Ingredient getRepairIngredient() {
    return this.repairIngredient.get();
  }
  
  public @NotNull TagKey<Block> getTag() {
    return NEEDS_FIST;
  }
  
  //Tier registry
  public static void init() {
    registerTier(SHATTERED_GLASS, "shattered_glass", Tiers.STONE);
    registerTier(GLASS, "glass", SHATTERED_GLASS);
    registerTier(MACHUAHUITL, "machuahutil", GLASS);
    registerTier(SOULMETAL, "soulmetal", MACHUAHUITL);
    registerTier(KATANA, "katana", SOULMETAL);
    registerTier(BLOODTHIRSTER, "bloodthirster", KATANA);
    registerTier(BREAKER, "breaker", Tiers.DIAMOND);
  }
}
