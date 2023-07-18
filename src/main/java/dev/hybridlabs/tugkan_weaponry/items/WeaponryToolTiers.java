package dev.hybridlabs.tugkan_weaponry.items;

import dev.hybridlabs.tugkan_weaponry.registries.ItemRegistry;
import dev.hybridlabs.tugkan_weaponry.registries.TagRegistry;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;

public enum WeaponryToolTiers implements Tier {
  COPPER(250, 4.0F, 1.0F, 1, 5, () -> Ingredient.of(Items.COPPER_INGOT)),
  STEEL(500, 6.0F, 2.0F, 2, 14, () -> Ingredient.of(ItemRegistry.STEEL_INGOT.get())),
  OBSIDIAN_EDGED_DIAMOND(2031, 8.0F, 3.0F, 4, 10, () -> Ingredient.of(ItemRegistry.OBSIDIAN_SHARD.get())),
  GILDED_NETHERITE(2031, 9.0F, 4.0F, 4, 15, () -> Ingredient.of(Items.NETHERITE_INGOT)),
  BRIGHTSTEEL(8192, 13.0F, 6.0F, 4, 20, () -> Ingredient.of(ItemRegistry.BRIGHTSTEEL_INGOT.get())),
  AURUM(4096, 13.0F, 6.0F, 5, 20, () -> Ingredient.of(ItemRegistry.AURUMITE_INGOT.get()));

  private final int level;
  private final int uses;
  private final float speed;
  private final float damage;
  private final int enchantmentValue;
  private final LazyLoadedValue<Ingredient> repairIngredient;

  WeaponryToolTiers(int durability, float speed, float damage, int levelTier, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
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

  @Nullable public TagKey<Block> getTag() {
    return TagRegistry.getTagFromTier(this);
  }

  //Tier registry
  public static void init() {
    registerTier(WeaponryToolTiers.COPPER, "copper", Tiers.STONE, Tiers.IRON);
    registerTier(WeaponryToolTiers.STEEL, "steel", Tiers.IRON, Tiers.DIAMOND);
    registerTier(WeaponryToolTiers.OBSIDIAN_EDGED_DIAMOND, "obsidian_edged_diamond", Tiers.DIAMOND, Tiers.NETHERITE);
    registerTier(WeaponryToolTiers.GILDED_NETHERITE, "gilded_netherite", Tiers.NETHERITE);
    registerTier(WeaponryToolTiers.BRIGHTSTEEL, "brightsteel", WeaponryToolTiers.GILDED_NETHERITE);
    registerTier(WeaponryToolTiers.AURUM, "aurum", WeaponryToolTiers.BRIGHTSTEEL);
  }

  public static void registerTier(Tier tier, String name, Tier after) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), List.of());
  }

  public static void registerTier(Tier tier, String name, Tier after, Tier before) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), List.of(before));
  }
}
