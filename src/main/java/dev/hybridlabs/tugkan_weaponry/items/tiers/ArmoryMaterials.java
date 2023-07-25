package dev.hybridlabs.tugkan_weaponry.items.tiers;

import dev.hybridlabs.tugkan_weaponry.registries.ItemRegistry;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ArmoryMaterials implements StringRepresentable, ArmorMaterial {
  BRIGHTSTEEL("brightsteel", 45, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
    map.put(ArmorItem.Type.BOOTS, 4); map.put(ArmorItem.Type.LEGGINGS, 7); map.put(ArmorItem.Type.CHESTPLATE, 9); map.put(ArmorItem.Type.HELMET, 4);
  }), 20, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(ItemRegistry.BRIGHTSTEEL_INGOT.get()));
  
  public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
  private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
    map.put(ArmorItem.Type.BOOTS, 13);
    map.put(ArmorItem.Type.LEGGINGS, 15);
    map.put(ArmorItem.Type.CHESTPLATE, 16);
    map.put(ArmorItem.Type.HELMET, 11);
  });
  private final String name;
  private final int durabilityMultiplier;
  private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
  private final int enchantmentValue;
  private final SoundEvent sound;
  private final float toughness;
  private final float knockbackResistance;
  private final LazyLoadedValue<Ingredient> repairIngredient;

  private ArmoryMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionMap, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairItem) {
    this.name = name;
    this.durabilityMultiplier = durabilityMultiplier;
    this.protectionFunctionForType = protectionMap;
    this.enchantmentValue = enchantmentValue;
    this.sound = sound;
    this.toughness = toughness;
    this.knockbackResistance = knockbackResistance;
    this.repairIngredient = new LazyLoadedValue<>(repairItem);
  }

  public int getDurabilityForType(ArmorItem.Type armorItem) {
    return HEALTH_FUNCTION_FOR_TYPE.get(armorItem) * this.durabilityMultiplier;
  }

  public int getDefenseForType(ArmorItem.Type armorItem) {
    return this.protectionFunctionForType.get(armorItem);
  }

  public int getEnchantmentValue() {
    return this.enchantmentValue;
  }

  public SoundEvent getEquipSound() {
    return this.sound;
  }

  public Ingredient getRepairIngredient() {
    return this.repairIngredient.get();
  }

  public String getName() {
    return this.name;
  }

  public float getToughness() {
    return this.toughness;
  }

  /**
   * Gets the percentage of knockback resistance provided by armor of the material.
   */
  public float getKnockbackResistance() {
    return this.knockbackResistance;
  }

  public String getSerializedName() {
    return this.name;
  }
}
