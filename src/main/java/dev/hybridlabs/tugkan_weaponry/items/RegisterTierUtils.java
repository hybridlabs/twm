package dev.hybridlabs.tugkan_weaponry.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;

public class RegisterTierUtils {
  public static void registerTier(Tier tier, String name, Tier after) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), List.of());
  }
  
  public static void registerTier(Tier tier, String name, Tier after, Tier before) {
    TierSortingRegistry.registerTier(tier, new ResourceLocation(MODID, name), List.of(after), List.of(before));
  }
}
