package dev.hybridlabs.twm.items.weapons.fists;

import dev.hybridlabs.twm.items.weapons.FistItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class GauntilusFistItem extends FistItem {
  public GauntilusFistItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    target.playSound(SoundEvents.SHULKER_HURT_CLOSED, 1.5f, 1.5f);
    return super.hurtEnemy(stack, target, attacker);
  }
}
