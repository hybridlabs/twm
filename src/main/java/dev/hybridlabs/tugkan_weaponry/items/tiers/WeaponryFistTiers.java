package dev.hybridlabs.tugkan_weaponry.items.tiers;

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
public enum WeaponryFistTiers implements Tier {
  TERRAPOTTA(250, 4.0F, 0.0F, 0, 10, () -> Ingredient.EMPTY),
  NAUTILUS(1000, 4.0F, 0.0F, 0, 22, () -> Ingredient.of(Items.NAUTILUS_SHELL)),
  HEART_OF_THE_SEA(2000, 4.0F, 0.0F, 0, 22, () -> Ingredient.of(Items.HEART_OF_THE_SEA)),
  SHULKER(2031, 4.0F, 1.0F, 0, 10, () -> Ingredient.of(Items.SHULKER_SHELL));
  
  private final int level;
  private final int uses;
  private final float speed;
  private final float damage;
  private final int enchantmentValue;
  private final LazyLoadedValue<Ingredient> repairIngredient;
  
  WeaponryFistTiers(int durability, float speed, float damage, int levelTier, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
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
    registerTier(TERRAPOTTA, "terrapotta", Tiers.WOOD);
    registerTier(NAUTILUS, "nautilus", TERRAPOTTA);
    registerTier(HEART_OF_THE_SEA, "heart_of_the_sea", NAUTILUS);
    registerTier(SHULKER, "shulker", HEART_OF_THE_SEA);
  }
}
