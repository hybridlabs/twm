package dev.hybridlabs.tugkan_weaponry.items.weapons;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

public class KnifeItem extends SwordItem {
  private final float attackDamage;
  private final Multimap<Attribute, AttributeModifier> defaultModifiers;

  public KnifeItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, (int) attackDamageModifier, attackSpeedModifier, properties);
    this.attackDamage = attackDamageModifier + tier.getAttackDamageBonus();
    ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
    builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
    builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", attackSpeedModifier, AttributeModifier.Operation.ADDITION));
    this.defaultModifiers = builder.build();
  }

  // Had to override this because net.minecraft.world.item.SwordItem has integer as damage modifier, instead of float.
  // why tools have damage modifier as a float instead of integer. This is stupid.

  @Override
  public float getDamage() {
    return this.attackDamage;
  }

  @Override @NotNull
  public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot pEquipmentSlot) {
    return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
  }
}
