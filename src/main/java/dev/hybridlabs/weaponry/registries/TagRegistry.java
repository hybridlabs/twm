package dev.hybridlabs.weaponry.registries;

import dev.hybridlabs.weaponry.items.HybridTiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static dev.hybridlabs.weaponry.Main.MODID;

public class TagRegistry {

  public static final TagKey<Block> NEEDS_COPPER_TOOL = create(new ResourceLocation(MODID, "needs_copper_tool"));
  public static final TagKey<Block> NEEDS_STEEL_TOOL = create(new ResourceLocation(MODID, "needs_steel_tool"));
  public static final TagKey<Block> NEEDS_OBSIDIAN_EDGED_DIAMOND_TOOL = create(new ResourceLocation(MODID, "needs_obsidian_edged_diamond_tool"));
  public static final TagKey<Block> NEEDS_GILDED_NETHERITE_TOOL = create(new ResourceLocation(MODID, "needs_gilded_netherite_tool"));
  public static final TagKey<Block> NEEDS_AURUM_TOOL = create(new ResourceLocation(MODID, "needs_aurum_tool"));
  public static final TagKey<Block> NEEDS_BRIGHTSTEEL_TOOL = create(new ResourceLocation(MODID, "needs_brightsteel_tool"));

  public static TagKey<Block> getTagFromTier(HybridTiers tier) {
    return switch(tier) {
      case COPPER -> NEEDS_COPPER_TOOL;
      case STEEL -> NEEDS_STEEL_TOOL;
      case OBSIDIAN_EDGED_DIAMOND -> NEEDS_OBSIDIAN_EDGED_DIAMOND_TOOL;
      case GILDED_NETHERITE -> NEEDS_GILDED_NETHERITE_TOOL;
      case AURUM -> NEEDS_AURUM_TOOL;
      case BRIGHTSTEEL -> NEEDS_BRIGHTSTEEL_TOOL;
    };
  }
  public static TagKey<Block> create(ResourceLocation name) {
    return TagKey.create(Registries.BLOCK, name);
  }
}
