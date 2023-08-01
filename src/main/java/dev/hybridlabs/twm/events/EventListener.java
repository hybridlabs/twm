package dev.hybridlabs.twm.events;

import dev.hybridlabs.twm.items.weapons.MaceItem;
import dev.hybridlabs.twm.items.weapons.swords.BloodthirsterItem;
import dev.hybridlabs.twm.items.weapons.swords.SoulmetalSwordItem;
import dev.hybridlabs.twm.registries.BlockRegistry;
import dev.hybridlabs.twm.registries.ItemRegistry;
import dev.hybridlabs.twm.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import static dev.hybridlabs.twm.Main.MODID;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = MODID)
public class EventListener {
  @SubscribeEvent
  public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
    Level level = event.getLevel();
    BlockPos bPos = event.getHitVec().getBlockPos();
    Block block = level.getBlockState(bPos).getBlock();
    Player player = event.getEntity();
    InteractionHand hand = event.getHand();
    Item usedItem = player.getItemInHand(hand).getItem();
    
    if(!level.isClientSide() && usedItem.equals(Items.FLINT) && !player.getCooldowns().isOnCooldown(Items.FLINT) && block.equals(Blocks.OBSIDIAN)) {
      flintRightClickOnObsidian(level, bPos, player, hand);
    }
  }
  
  @SubscribeEvent
  public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
    Level level = event.getLevel();
    BlockPos bPos = event.getPos();
    Block block = level.getBlockState(bPos).getBlock();
    Player player = event.getEntity();
    InteractionHand hand = event.getHand();
    Item usedItem = player.getItemInHand(hand).getItem();
  
    if(!level.isClientSide() && !player.isCreative() && usedItem instanceof PickaxeItem pickaxe) {
      if(block.equals(Blocks.BEDROCK) || block.equals(BlockRegistry.BEDROCK.get()) || block.equals(BlockRegistry.BEDROCK_BRICKS.get()) || block.equals(BlockRegistry.BEDROCK_BRICKS_UNBREAKABLE.get())) {
        replaceBedrockToBreak(level, bPos, block, pickaxe);
      }
    }
  }
  
  @SubscribeEvent
  public static void onLivingEntityHurt(LivingHurtEvent event) {
    Entity tempSourceEntity = event.getSource().getEntity();
    Entity tempTargetEntity = event.getEntity();
    
    if (tempSourceEntity instanceof LivingEntity sourceEntity && tempTargetEntity instanceof LivingEntity targetEntity) {
      Item sourceItem = sourceEntity.getMainHandItem().getItem();
      if (sourceItem instanceof MaceItem maceItem) {
        maceStun(sourceEntity, targetEntity, event.getAmount(), maceItem);
      } else if (sourceItem instanceof SoulmetalSwordItem && (targetEntity instanceof AbstractPiglin || targetEntity instanceof ZombifiedPiglin)) {
        soulmetalSwordHit(sourceEntity, targetEntity);
      } else if (sourceItem instanceof BloodthirsterItem && targetEntity.getHealth() > 0) {
        bloodthirsterLifeSteal(sourceEntity, targetEntity, event.getAmount());
      }
    }
  }
  
  public static void replaceBedrockToBreak(Level level, BlockPos blockPos, Block block, PickaxeItem item) {
    if(item.getTier().getLevel() >= 4) {
      if(block.equals(Blocks.BEDROCK)) {
        level.setBlock(blockPos, BlockRegistry.BEDROCK.get().defaultBlockState(), 3);
      } else if(block.equals(BlockRegistry.BEDROCK_BRICKS_UNBREAKABLE.get())) {
        level.setBlock(blockPos, BlockRegistry.BEDROCK_BRICKS.get().defaultBlockState(), 3);
      }
    } else {
      if(block.equals(BlockRegistry.BEDROCK.get())) {
        level.setBlock(blockPos, Blocks.BEDROCK.defaultBlockState(), 3);
      } else if(block.equals(BlockRegistry.BEDROCK_BRICKS.get())) {
        level.setBlock(blockPos, BlockRegistry.BEDROCK_BRICKS_UNBREAKABLE.get().defaultBlockState(), 3);
      }
    }
  }
  
  public static void flintRightClickOnObsidian(Level level, BlockPos blockPos, Player player, InteractionHand hand) {
    player.swing(hand);
    player.getCooldowns().addCooldown(Items.FLINT, 5);
    player.getInventory().clearOrCountMatchingItems(p -> Items.FLINT == p.getItem(), 1, player.inventoryMenu.getCraftSlots());
    
    RandomSource random = player.getRandom();
    if(random.nextInt(0, 3) == 2) {
      level.playSound(null, blockPos, SoundEvents.DEEPSLATE_BREAK, SoundSource.BLOCKS, 2.0f, 2.0f);
      
      ItemEntity itemToSpawn = new ItemEntity(level, blockPos.getX() + 0.5d, blockPos.getY() + 1.0d, blockPos.getZ() + 0.5d, ItemRegistry.OBSIDIAN_SHARD.get().getDefaultInstance());
      itemToSpawn.setPickUpDelay(10);
      level.addFreshEntity(itemToSpawn);
    } else {
      level.playSound(null, blockPos, SoundEvents.PLAYER_BIG_FALL, SoundSource.BLOCKS, 0.3f, 0.1f);
      
    }
    level.levelEvent(2001, blockPos, Block.getId(Blocks.CRYING_OBSIDIAN.defaultBlockState()));
  }
  
  public static void maceStun(LivingEntity source, LivingEntity target, float damage, MaceItem maceItem) {
    Level level = source.level();
    float itemdamage = maceItem.getDamage() + 1;
    BlockPos pos = target.blockPosition();
    
    if (damage > (itemdamage*2)) {
      if (maceItem == ItemRegistry.WOODEN_CLUB.get()) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (damage / 0.1125), 0, false, false));
        level.playSound(null, pos, SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.PLAYERS, 1.5f, 0.1f);
      } else if (maceItem == ItemRegistry.WOODEN_MACE.get()) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (damage / 0.1875), 2, false, false));
        level.playSound(null, pos, SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.PLAYERS, 1.5f, 0.1f);
      } else if (maceItem == ItemRegistry.COPPER_MACE.get()) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (damage / 0.15), 1, false, false));
        level.playSound(null, pos, SoundEvents.ENDER_DRAGON_HURT, SoundSource.PLAYERS, 1.5f, 2.0f);
      } else if (maceItem == ItemRegistry.IRON_MACE.get()) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (damage / 0.16875), 2, false, false));
        level.playSound(null, pos, SoundEvents.ENDER_DRAGON_HURT, SoundSource.PLAYERS, 1.5f, 2.0f);
      } else if (maceItem == ItemRegistry.STEEL_MACE.get()) {
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (damage / 0.1875), 3, false, false));
        level.playSound(null, pos, SoundEvents.ENDER_DRAGON_HURT, SoundSource.PLAYERS, 1.5f, 2.0f);
      }
    }
  }
  
  public static void soulmetalSwordHit(LivingEntity source, LivingEntity target) {
    Level level = source.level();
    float health = target.getHealth();
    float maxHealth = target.getMaxHealth();
    Vec3 pos = target.position();
    
    if(health > maxHealth * 0.6f) {
      target.setHealth(health - (maxHealth * 0.6f));
      level.playSound(null, pos.x(), pos.y()+2, pos.z(), SoundRegistry.SOUL_HIT.get(), SoundSource.PLAYERS, 1.0f, 1.7f);
      level.playSound(null, pos.x(), pos.y()+2, pos.z(), SoundRegistry.SOUL_ATTACK.get(), SoundSource.PLAYERS, 1.0f, 2.0f);
      
      if(level instanceof ServerLevel serverLevel) {
        serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.x()+2, pos.y(), pos.z(), 5, 0.1, 0.5, 0.1, 0.05);
        serverLevel.sendParticles(ParticleTypes.SOUL, pos.x(), pos.y()+2, pos.z(), 5, 0.1, 0.5, 0.1, 0.05);
        serverLevel.sendParticles(ParticleTypes.SOUL, pos.x(), pos.y()+2, pos.z(), 5, 0.1, 0.5, 0.1, 0.05);
      }
    } else {
      target.kill();
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.SOUL_ATTACK.get(), SoundSource.PLAYERS, 1.0f, 0.5f);
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.SOUL_ATTACK.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.SOUL_ATTACK.get(), SoundSource.PLAYERS, 1.0f, 1.5f);
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.SOUL_ATTACK.get(), SoundSource.PLAYERS, 1.0f, 2.0f);
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.SOUL_DEATH.get(), SoundSource.PLAYERS, 1.0f, 0.1f);
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.SOUL_DEATH.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.SOUL_DEATH.get(), SoundSource.PLAYERS, 1.0f, 2.0f);
      
      if(level instanceof ServerLevel serverLevel) {
        serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.x()+2, pos.y(), pos.z(), 5, 0.1, 0.5, 0.1, 0.05);
        serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.x()+2, pos.y(), pos.z(), 10, 0.1, 0.5, 0.1, 0.1);
        serverLevel.sendParticles(ParticleTypes.SOUL, pos.x()+2, pos.y(), pos.z(), 50, 0.1, 0.5, 0.1, 0.15);
        serverLevel.sendParticles(ParticleTypes.SOUL, pos.x()+2, pos.y(), pos.z(), 50, 0.1, 0.5, 0.1, 0.05);
      }
    }
  }
  
  public static void bloodthirsterLifeSteal(LivingEntity source, LivingEntity target, float damage) {
    Level level = source.level();
    Vec3 pos = target.position();
    float health = source.getHealth();
    float maxHealth = source.getMaxHealth();
    
    if(damage >= 12) {
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.BLOODTHIRSTER_DEEP.get(), SoundSource.PLAYERS, 0.5f, 1.0f);
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.BLOODTHIRSTER.get(), SoundSource.PLAYERS, 0.5f, 0.1f);
      source.setHealth(health + (1 - health/maxHealth) * damage * 0.5f);
    } else {
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.BLOODTHIRSTER_DEEP.get(), SoundSource.PLAYERS, 0.25f, 1.0f);
      level.playSound(null, pos.x()+2, pos.y(), pos.z(), SoundRegistry.BLOODTHIRSTER.get(), SoundSource.PLAYERS, 0.25f, 0.7f);
      source.setHealth(health + (1 - health/maxHealth) * damage * 0.25f);
    }
  }
}
