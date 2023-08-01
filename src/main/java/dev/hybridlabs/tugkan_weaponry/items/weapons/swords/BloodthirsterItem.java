package dev.hybridlabs.tugkan_weaponry.items.weapons.swords;

import dev.hybridlabs.tugkan_weaponry.items.weapons.GenericWeaponrySwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BloodthirsterItem extends GenericWeaponrySwordItem {
  public BloodthirsterItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    pTooltipComponents.add(Component.translatable("item.tugkans_weaponry.bloodthirster_claymore.description").withStyle(ChatFormatting.GRAY));
  }
}
