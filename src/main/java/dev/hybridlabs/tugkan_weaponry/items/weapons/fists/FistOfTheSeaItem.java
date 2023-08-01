package dev.hybridlabs.tugkan_weaponry.items.weapons.fists;

import dev.hybridlabs.tugkan_weaponry.items.weapons.FistItem;
import dev.hybridlabs.tugkan_weaponry.registries.TagRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class FistOfTheSeaItem extends FistItem {
  public FistOfTheSeaItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    target.playSound(SoundEvents.SHULKER_HURT_CLOSED, 1.5f, 1.5f);
    target.playSound(SoundEvents.ELDER_GUARDIAN_HURT, 1.5f, 1.2f);
    target.playSound(SoundEvents.ELDER_GUARDIAN_HURT, 1.5f, 1.0f);
    return super.hurtEnemy(stack, target, attacker);
  }
  
  @Override
  public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
    super.inventoryTick(stack, level, entity, slot, selected);
    if (selected) waterPower(level, entity);
  }
  
  private void waterPower(Level level, Entity entity) {
    if (level.isClientSide()) return;
    if (entity instanceof LivingEntity livingEntity && level.getBlockState(entity.blockPosition()).is(TagRegistry.FIST_OF_THE_SEA_POWER)) {
      livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, false, true));
    }
  }
  
  @Override
  public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
    super.appendHoverText(itemstack, world, list, flag);
    list.add(Component.translatable("item.tugkans_weaponry.fist_of_the_sea_fist.description").withStyle(ChatFormatting.GRAY));
  }
  
}
