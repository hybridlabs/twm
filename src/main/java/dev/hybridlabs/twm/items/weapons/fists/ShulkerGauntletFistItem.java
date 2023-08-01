package dev.hybridlabs.twm.items.weapons.fists;

import dev.hybridlabs.twm.items.weapons.FistItem;
import dev.hybridlabs.twm.registries.EnchantmentRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class ShulkerGauntletFistItem extends FistItem {
  public ShulkerGauntletFistItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    target.playSound(SoundEvents.SHULKER_HURT_CLOSED, 1.5f, 1.5f);
    
    doLevitating(stack, target);
    return super.hurtEnemy(stack, target, attacker);
  }
  
  private void doLevitating(ItemStack stack, LivingEntity target) {
    int enchLevel = stack.getEnchantmentLevel(EnchantmentRegistry.LEVITATING.get());
    
    if (enchLevel > 0 && !target.hasEffect(MobEffects.LEVITATION)) {
      target.playSound(SoundEvents.SHULKER_SHOOT, 1.0f, 1.0f);
      target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) (15 * Math.pow(2, enchLevel)), enchLevel - 1, false, true));
    }
  }
}
