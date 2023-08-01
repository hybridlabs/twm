package dev.hybridlabs.twm.items.weapons.fists;

import dev.hybridlabs.twm.items.weapons.FistItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class TerrapottaFistItem extends FistItem {
  public TerrapottaFistItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    return super.hurtEnemy(stack, target, attacker);
  }
}
