package dev.hybridlabs.tugkan_weaponry.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.TierSortingRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;
import static dev.hybridlabs.tugkan_weaponry.registries.TagRegistry.NEEDS_FIST;

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
    registerTier(WeaponryFistTiers.TERRAPOTTA, "terrapotta", Tiers.STONE, Tiers.IRON);
  }
  
  public static void registerTier(Tier tier, String name, Tier after) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), List.of());
  }
  
  public static void registerTier(Tier tier, String name, Tier after, Tier before) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), List.of(before));
  }
}
