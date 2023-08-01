package dev.hybridlabs.twm.registries;

import com.mojang.serialization.Codec;
import dev.hybridlabs.twm.loot_modifiers.AddItem;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.twm.Main.MODID;

public class LootModifierRegistry {
  public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MODID);
  
  public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM = LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItem.CODEC);
  
  public static void init(IEventBus modEventBus) {
    LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
  }
}
