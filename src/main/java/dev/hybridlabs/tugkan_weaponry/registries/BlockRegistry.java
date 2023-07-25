package dev.hybridlabs.tugkan_weaponry.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;

public class BlockRegistry {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
  
  public static final RegistryObject<Block> BEDROCK = BLOCKS.register("bedrock", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE).strength(250.0f, 1200.0f)));
  public static final RegistryObject<Block> BEDROCK_BRICKS = BLOCKS.register("bedrock_bricks", () -> new Block(BlockBehaviour.Properties.copy(BEDROCK.get())));
  public static final RegistryObject<Block> BEDROCK_BRICKS_UNBREAKABLE = BLOCKS.register("bedrock_bricks_unbreakable", () -> new Block(BlockBehaviour.Properties.copy(BEDROCK.get()).strength(-1.0f, 3600000.0f)));
  
  public static final RegistryObject<Block> ANCIENT_DEBRIS = BLOCKS.register("ancient_debris", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.ANCIENT_DEBRIS).strength(30.0f, 1200.0f).requiresCorrectToolForDrops().lightLevel((bs) -> 15)));
  public static final RegistryObject<Block> ANCIENT_DEBRIS_DEEPSLATE = BLOCKS.register("ancient_debris_deepslate", () -> new Block(BlockBehaviour.Properties.copy(ANCIENT_DEBRIS.get())));
  public static final RegistryObject<Block> GOLD_ANCIENT_DEBRIS = BLOCKS.register("gold_ancient_debris", () -> new Block(BlockBehaviour.Properties.copy(ANCIENT_DEBRIS.get())));
  public static final RegistryObject<Block> GOLD_ANCIENT_DEBRIS_NETHERRACK = BLOCKS.register("gold_ancient_debris_netherrack", () -> new Block(BlockBehaviour.Properties.copy(ANCIENT_DEBRIS.get())));
  
  public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK).strength(5.0f, 20.0f).requiresCorrectToolForDrops()));
  public static final RegistryObject<Block> BRIGHTSTEEL_BLOCK = BLOCKS.register("brightsteel_block", () -> new Block(BlockBehaviour.Properties.copy(STEEL_BLOCK.get()).strength(200.0f, 1200.0f).requiresCorrectToolForDrops()));
  public static final RegistryObject<Block> AURUMITE_BLOCK = BLOCKS.register("aurumite_block", () -> new Block(BlockBehaviour.Properties.copy(BRIGHTSTEEL_BLOCK.get()).strength(100.0f, 1200.0f).requiresCorrectToolForDrops()));
  
  public static void init(IEventBus modEventBus) {
    BLOCKS.register(modEventBus);
  }
}
