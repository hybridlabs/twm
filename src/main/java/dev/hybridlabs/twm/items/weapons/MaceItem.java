package dev.hybridlabs.twm.items.weapons;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class MaceItem extends GenericWeaponrySwordItem {
  public MaceItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
    return super.hurtEnemy(pStack, pTarget, pAttacker);
  }
}
