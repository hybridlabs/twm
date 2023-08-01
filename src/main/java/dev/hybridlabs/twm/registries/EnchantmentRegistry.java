package dev.hybridlabs.twm.registries;

import dev.hybridlabs.twm.items.enchantment.DisarmingEnchantment;
import dev.hybridlabs.twm.items.enchantment.LevitatingEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.twm.Main.MODID;

public class EnchantmentRegistry {
  public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);
  
  public static final RegistryObject<Enchantment> DISARMING = ENCHANTMENTS.register("disarming", () -> new DisarmingEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
  public static final RegistryObject<Enchantment> LEVITATING = ENCHANTMENTS.register("levitating", () -> new LevitatingEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
  
  public static void init(IEventBus modEventBus) {
    ENCHANTMENTS.register(modEventBus);
  }
}
