package dev.hybridlabs.twm.items.weapons;

import net.minecraft.world.item.Tier;

public class KnifeItem extends GenericWeaponrySwordItem {
  public KnifeItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, (int) attackDamageModifier, attackSpeedModifier, properties);
  }
}
