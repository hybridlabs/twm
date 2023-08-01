package dev.hybridlabs.twm.items.enchantment;

import dev.hybridlabs.twm.items.weapons.FistItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DisarmingEnchantment extends Enchantment {
  public DisarmingEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] applicableSlots) {
    super(rarity, category, applicableSlots);
  }
  
  @Override
  public int getMaxLevel() {
    return 3;
  }
  
  @Override
  public boolean canApplyAtEnchantingTable(ItemStack stack) {
    return stack.getItem() instanceof FistItem;
  }
}
