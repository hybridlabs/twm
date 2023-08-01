package dev.hybridlabs.tugkan_weaponry.items.weapons.swords;

import dev.hybridlabs.tugkan_weaponry.items.weapons.GenericWeaponrySwordItem;
import dev.hybridlabs.tugkan_weaponry.registries.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class SteelSwordItem extends GenericWeaponrySwordItem {
  public SteelSwordItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
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
    ServerPlayer serverPlayer = (ServerPlayer) context.getPlayer();
    
    if (serverLevel.getBlockState(pos).is(Blocks.SOUL_FIRE)) {
      serverLevel.destroyBlock(pos, true);
      serverLevel.playSound(null, pos, SoundEvents.SOUL_ESCAPE, SoundSource.BLOCKS, 1.5f, 0.1f);
      serverLevel.playSound(null, pos, SoundEvents.SOUL_ESCAPE, SoundSource.BLOCKS, 1.5f, 1.0f);
      serverLevel.playSound(null, pos, SoundEvents.SOUL_ESCAPE, SoundSource.BLOCKS, 1.5f, 2.0f);
      
      serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 5, 0.1, 0.5, 0.1, 0.05);
      serverLevel.sendParticles(ParticleTypes.SOUL, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 5, 0.1, 0.5, 0.1, 0.05);
      serverLevel.sendParticles(ParticleTypes.SOUL, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 5, 0.1, 0.5, 0.1, 0.15);
      
      swordConversion(serverLevel, serverPlayer, itemStack, context.getHand(), pos);
    }
  }
  
  private void swordConversion(ServerLevel level, ServerPlayer player, ItemStack item, InteractionHand interactionhand, BlockPos pos) {
    item.getOrCreateTag().putInt("soulcollection", (item.getOrCreateTag().getInt("soulcollection") + 1));
    
    if (item.getOrCreateTag().getInt("soulcollection") >= 32) {
      ItemStack soulSword = new ItemStack(ItemRegistry.SOULMETAL_SWORD.get());
      if (item.getTag() != null) soulSword.setTag(item.getTag().copy());
      player.setItemInHand(interactionhand, soulSword);
      player.getInventory().setChanged();
      
      level.playSound(null, pos, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD.value(), SoundSource.PLAYERS, 2.0f, 2.0f);
      level.playSound(null, pos, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD.value(), SoundSource.PLAYERS, 2.0f, 1.0f);
      level.playSound(null, pos, SoundEvents.SOUL_ESCAPE, SoundSource.BLOCKS, 1.5f, 0.1f);
      level.playSound(null, pos, SoundEvents.SOUL_ESCAPE, SoundSource.BLOCKS, 1.5f, 0.1f);
      
      level.sendParticles(ParticleTypes.SOUL, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 100, 0.1, 0.5, 0.1, 0.25);
      level.sendParticles(ParticleTypes.SOUL, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 50, 0.1, 0.5, 0.1, 0.15);
      level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 25, 0.1, 0.5, 0.1, 0.05);
      level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5), 25, 0.1, 0.5, 0.1, 0.15);
    }
  }
}
