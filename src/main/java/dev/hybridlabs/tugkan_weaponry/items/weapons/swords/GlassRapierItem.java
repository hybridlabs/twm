package dev.hybridlabs.tugkan_weaponry.items.weapons.swords;

import dev.hybridlabs.tugkan_weaponry.items.weapons.GenericWeaponrySwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlassRapierItem extends GenericWeaponrySwordItem {
  public GlassRapierItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
    
    return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
    
    return super.hurtEnemy(pStack, pTarget, pAttacker);
  }
  
  @Override
  public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    pTooltipComponents.add(Component.literal("May shatter when using").withStyle(ChatFormatting.GRAY));
  }
}
