package dev.hybridlabs.weaponry.registries;

import dev.hybridlabs.weaponry.items.HybridTiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.Collections;
import java.util.List;

import static dev.hybridlabs.weaponry.Main.MODID;

public class TierRegistry {
  public static void init() {
    registerTier(HybridTiers.COPPER, "copper", Tiers.STONE, Tiers.IRON);
    registerTier(HybridTiers.STEEL, "steel", Tiers.IRON, Tiers.DIAMOND);
    registerTier(HybridTiers.OBSIDIAN_EDGED_DIAMOND, "obsidian_edged_diamond", Tiers.DIAMOND, Tiers.NETHERITE);
    registerTier(HybridTiers.GILDED_NETHERITE, "gilded_netherite", Tiers.NETHERITE);
    registerTier(HybridTiers.BRIGHTSTEEL, "brightsteel", HybridTiers.GILDED_NETHERITE);
    registerTier(HybridTiers.AURUM, "aurum", HybridTiers.BRIGHTSTEEL);
  }

  public static void registerTier(Tier tier, String name, Tier after) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), Collections.emptyList());
  }

  public static void registerTier(Tier tier, String name, Tier after, Tier before) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), List.of(before));
  }
}
