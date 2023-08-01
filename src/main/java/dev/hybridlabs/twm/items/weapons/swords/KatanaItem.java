package dev.hybridlabs.twm.items.weapons.swords;

import dev.hybridlabs.twm.items.weapons.GenericWeaponrySwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KatanaItem extends GenericWeaponrySwordItem {
  public KatanaItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    pTooltipComponents.add(Component.translatable("item.twm.katana.description").withStyle(ChatFormatting.GRAY));
  }
  
  @Override
  public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int slot, boolean selected) {
    super.inventoryTick(itemstack, level, entity, slot, selected);
    if (selected) powerOfTheWind(level, entity);
  }
  
  @Override
  public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
    katanaRightClick(pPlayer, pUsedHand);
    return super.use(pLevel, pPlayer, pUsedHand);
  }
  
  private void katanaRightClick(Player player, InteractionHand usedHand) {
    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2, false, false));
    player.getCooldowns().addCooldown(player.getItemInHand(usedHand).getItem(), 600);
  }
  
  private void powerOfTheWind(Level level, Entity entity) {
    if (level.isClientSide()) return;
    if (entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(MobEffects.MOVEMENT_SPEED)) {
      livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 59, 0, false, false));
    }
  }
}
