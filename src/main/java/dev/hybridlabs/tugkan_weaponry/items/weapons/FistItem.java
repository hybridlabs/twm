package dev.hybridlabs.tugkan_weaponry.items.weapons;

import dev.hybridlabs.tugkan_weaponry.items.weapons.fists.FistOfTheSeaItem;
import dev.hybridlabs.tugkan_weaponry.items.weapons.fists.ShulkerGauntletFistItem;
import dev.hybridlabs.tugkan_weaponry.registries.EnchantmentRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class FistItem extends GenericWeaponrySwordItem {
  public FistItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    target.playSound(SoundEvents.SHULKER_HURT_CLOSED, 1.5f, 0.7f);
    
    doDisarming(stack, target, attacker);
    return super.hurtEnemy(stack, target, attacker);
  }
  
  private void doDisarming(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    int enchLevel = stack.getEnchantmentLevel(EnchantmentRegistry.DISARMING.get());
    RandomSource random = attacker.getRandom();
    if(enchLevel > 0 && !target.hasEffect(MobEffects.WEAKNESS) && target.getHealth() >= target.getMaxHealth() * 0.5 && random.nextInt(7) > 4) {
      target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int) (15 * Math.pow(2, enchLevel)), 99, false, true));
      
      target.playSound(SoundEvents.PLAYER_ATTACK_CRIT, 1.5f, 2.0f);
      if(stack.getItem() instanceof FistOfTheSeaItem) target.playSound(SoundEvents.ELDER_GUARDIAN_CURSE, 1.5f, 1.0f);
      else if(stack.getItem() instanceof ShulkerGauntletFistItem) {
        target.playSound(SoundEvents.SHULKER_HURT, 1.5f, 2.0f);
        target.playSound(SoundEvents.SHULKER_HURT, 1.5f, 1.5f);
        target.playSound(SoundEvents.SHULKER_HURT, 1.5f, 1.0f);
      }
      
      target.swing(InteractionHand.MAIN_HAND);
      target.swing(InteractionHand.OFF_HAND);
    }
  }
}
