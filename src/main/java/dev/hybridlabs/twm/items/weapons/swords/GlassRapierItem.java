package dev.hybridlabs.twm.items.weapons.swords;

import dev.hybridlabs.twm.items.weapons.GenericWeaponrySwordItem;
import dev.hybridlabs.twm.registries.ItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlassRapierItem extends GenericWeaponrySwordItem {
  public GlassRapierItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
    if(!(pAttacker instanceof Player player && player.isCreative())) breakRapier(pStack, pAttacker);
    return super.hurtEnemy(pStack, pTarget, pAttacker);
  }
  
  @Override
  public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    pTooltipComponents.add(Component.translatable("item.twm.glass_rapier.description").withStyle(ChatFormatting.GRAY));
  }
  
  public void breakRapier(ItemStack item, LivingEntity attacker) {
    RandomSource random = attacker.getRandom();
    Vec3 pos = attacker.position();
    Level level = attacker.level();
    
    if(random.nextInt(0, 100 + item.getEnchantmentLevel(Enchantments.UNBREAKING) * 100) == 1) {
      level.playSound(null, pos.x(), pos.y(), pos.z(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1.0f, 0.1f);
      level.playSound(null, pos.x(), pos.y(), pos.z(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1.0f, 1.0f);
      level.playSound(null, pos.x(), pos.y(), pos.z(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1.0f, 2.0f);
      
      ItemStack newItem = ItemRegistry.SHATTERED_GLASS.get().getDefaultInstance();
      ItemStack itemMainHand = attacker.getItemInHand(InteractionHand.MAIN_HAND);
      ItemStack itemOffHand = attacker.getItemInHand(InteractionHand.OFF_HAND);
      
      if(itemOffHand.getItem() instanceof GlassRapierItem) {
        newItem.setTag(itemOffHand.getTag());
        attacker.setItemInHand(InteractionHand.OFF_HAND, newItem);
      } else {
        newItem.setTag(itemMainHand.getTag());
        attacker.setItemInHand(InteractionHand.MAIN_HAND, newItem);
      }
    }
  }
}
