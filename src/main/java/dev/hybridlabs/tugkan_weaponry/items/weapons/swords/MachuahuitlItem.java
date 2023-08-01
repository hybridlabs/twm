package dev.hybridlabs.tugkan_weaponry.items.weapons.swords;

import dev.hybridlabs.tugkan_weaponry.Main;
import dev.hybridlabs.tugkan_weaponry.items.weapons.GenericWeaponrySwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Map;

public class MachuahuitlItem extends GenericWeaponrySwordItem {
  public static final Component message1 = Component.translatable("multiplayer.player.joined", "Nef").withStyle(ChatFormatting.YELLOW);
  public static final Component message2 = Component.literal("<Nef> Did I not tell you not to use mending on the Machuahuitl?").withStyle(ChatFormatting.WHITE);
  public static final Component message3 = Component.literal("<Nef> Good luck").withStyle(ChatFormatting.WHITE);
  public static final Component message4 = Component.translatable("multiplayer.player.left", "Nef").withStyle(ChatFormatting.YELLOW);
  
  public MachuahuitlItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
    super(tier, attackDamageModifier, attackSpeedModifier, properties);
  }
  
  @Override
  public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
    easterEggOnMending(pStack, pAttacker);
    return super.hurtEnemy(pStack, pTarget, pAttacker);
  }
  
  public void easterEggOnMending(ItemStack item, LivingEntity attacker) {
    Level level = attacker.level();
    Vec3 pos = attacker.position();
    
    if(!level.isClientSide() && item.getEnchantmentLevel(Enchantments.MENDING) > 0) {
      Map<Enchantment, Integer> enchantments = item.getAllEnchantments();
      enchantments.remove(Enchantments.MENDING);
      EnchantmentHelper.setEnchantments(enchantments, item);
      
      attacker.addEffect(new MobEffectInstance(MobEffects.HUNGER, 72000, 9, false, false));
      attacker.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 12000, 0, false, false));
      level.playSound(null, pos.x(), pos.y(), pos.z(), SoundEvents.ELDER_GUARDIAN_CURSE, SoundSource.PLAYERS, 2, 1);
      
      MinecraftServer server = level.getServer();
      PlayerList playerList = server.getPlayerList();
      Main.queueServerWork(100, () -> {
        for(ServerPlayer player: playerList.getPlayers()) player.sendSystemMessage(message1);
        Main.queueServerWork(200, () -> {
          for(ServerPlayer player: playerList.getPlayers()) player.sendSystemMessage(message2);
          Main.queueServerWork(60, () -> {
            for(ServerPlayer player: playerList.getPlayers()) player.sendSystemMessage(message3);
            Main.queueServerWork(100, () -> {
              for(ServerPlayer player: playerList.getPlayers()) player.sendSystemMessage(message4);
            });
          });
        });
      });
      
    }
  }
}
