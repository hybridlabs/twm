package dev.hybridlabs.tugkan_weaponry.items.weapons.swords;

import dev.hybridlabs.tugkan_weaponry.items.weapons.GenericWeaponrySwordItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class SoulmetalSwordItem extends GenericWeaponrySwordItem {
  public SoulmetalSwordItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public InteractionResult useOn(UseOnContext pContext) {
    super.useOn(pContext);
    swordUsedOnSoulFire(pContext);
    return InteractionResult.SUCCESS;
  }
  
  private void swordUsedOnSoulFire(UseOnContext context) {
    Level level = context.getLevel();
    if (level.isClientSide()) return;
    ServerLevel serverLevel = (ServerLevel) level;
    BlockPos pos = context.getClickedPos();
    ItemStack itemStack = context.getItemInHand();
    
    if (serverLevel.getBlockState(pos).is(Blocks.SOUL_FIRE)) {
      serverLevel.destroyBlock(pos, true);
      serverLevel.playSound(null, pos, SoundEvents.SOUL_ESCAPE, SoundSource.BLOCKS, 1.5f, 0.1f);
      serverLevel.playSound(null, pos, SoundEvents.SOUL_ESCAPE, SoundSource.BLOCKS, 1.5f, 1.0f);
      serverLevel.playSound(null, pos, SoundEvents.SOUL_ESCAPE, SoundSource.BLOCKS, 1.5f, 2.0f);
      
      serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 5, 0.1, 0.5, 0.1, 0.05);
      serverLevel.sendParticles(ParticleTypes.SOUL, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 5, 0.1, 0.5, 0.1, 0.05);
      serverLevel.sendParticles(ParticleTypes.SOUL, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 5, 0.1, 0.5, 0.1, 0.15);
      
      if (itemStack.getDamageValue() > itemStack.getMaxDamage() * 0.25) {
        itemStack.setDamageValue((int) (itemStack.getDamageValue() - itemStack.getMaxDamage() * 0.25));
      } else {
        itemStack.setDamageValue(0);
      }
      
    }
  }
}
