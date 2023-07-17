package dev.hybridlabs.tugkan_weaponry.registries;

import dev.hybridlabs.tugkan_weaponry.items.WeaponryTiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;

public class TierRegistry {
  public static void init() {
    registerTier(WeaponryTiers.COPPER, "copper", Tiers.STONE, Tiers.IRON);
    registerTier(WeaponryTiers.STEEL, "steel", Tiers.IRON, Tiers.DIAMOND);
    registerTier(WeaponryTiers.OBSIDIAN_EDGED_DIAMOND, "obsidian_edged_diamond", Tiers.DIAMOND, Tiers.NETHERITE);
    registerTier(WeaponryTiers.GILDED_NETHERITE, "gilded_netherite", Tiers.NETHERITE);
    registerTier(WeaponryTiers.BRIGHTSTEEL, "brightsteel", WeaponryTiers.GILDED_NETHERITE);
    registerTier(WeaponryTiers.AURUM, "aurum", WeaponryTiers.BRIGHTSTEEL);
  }

  public static void registerTier(Tier tier, String name, Tier after) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), List.of());
  }

  public static void registerTier(Tier tier, String name, Tier after, Tier before) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), List.of(before));
  }
}
