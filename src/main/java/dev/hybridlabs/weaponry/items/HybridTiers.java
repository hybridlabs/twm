package dev.hybridlabs.weaponry.items;

import dev.hybridlabs.weaponry.registries.ItemRegistry;
import dev.hybridlabs.weaponry.registries.TagRegistry;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum HybridTiers implements Tier {
  COPPER(250, 4.0F, 7.0F, 1, 5, () -> Ingredient.of(Items.COPPER_INGOT)),
  STEEL(500, 4.0F, 7.0F, 2, 14, () -> Ingredient.of(ItemRegistry.AURUMITE_INGOT.get())),
  OBSIDIAN_EDGED_DIAMOND(2031, 8.0F, 7.0F, 4, 10, () -> Ingredient.of(ItemRegistry.AURUMITE_INGOT.get())),
  GILDED_NETHERITE(2031, 9.0F, 8.0F, 4, 15, () -> Ingredient.of(ItemRegistry.AURUMITE_INGOT.get())),
  BRIGHTSTEEL(8192, 12.0F, 10.0F, 4, 20, () -> Ingredient.of(ItemRegistry.BRIGHTSTEEL_INGOT.get())),
  AURUM(4096, 20.0F, 10.0F, 5, 20, () -> Ingredient.of(ItemRegistry.AURUMITE_INGOT.get()));

  private final int level;
  private final int uses;
  private final float speed;
  private final float damage;
  private final int enchantmentValue;
  private final LazyLoadedValue<Ingredient> repairIngredient;

  HybridTiers(int durability, float speed, float pDamage, int leveltier, int enchantmentValue, Supplier<Ingredient> pRepairIngredient) {
    this.uses = durability;
    this.level = leveltier;
    this.speed = speed;
    this.damage = pDamage;
    this.enchantmentValue = enchantmentValue;
    this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
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

  @org.jetbrains.annotations.Nullable public TagKey<Block> getTag() { return TagRegistry.getTagFromTier(this); }
}
