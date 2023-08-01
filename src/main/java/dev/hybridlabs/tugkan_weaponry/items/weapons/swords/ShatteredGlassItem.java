package dev.hybridlabs.tugkan_weaponry.items.weapons.swords;

import dev.hybridlabs.tugkan_weaponry.items.weapons.GenericWeaponrySwordItem;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ShatteredGlassItem extends GenericWeaponrySwordItem {
  public ShatteredGlassItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
    if(!pLevel.isClientSide()) playSound(pLevel, pEntityLiving);
    return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
    Level level = pAttacker.level();
    if(!level.isClientSide()) playSound(level, pAttacker);
    return super.hurtEnemy(pStack, pTarget, pAttacker);
  }
  
  public void playSound(Level level, LivingEntity entity) {
    Vec3 pos = entity.position();
    
    level.playSound(null, pos.x(), pos.y(), pos.z(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1.0f, 0.1f);
    level.playSound(null, pos.x(), pos.y(), pos.z(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1.0f, 1.0f);
    level.playSound(null, pos.x(), pos.y(), pos.z(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1.0f, 2.0f);
  }
}
