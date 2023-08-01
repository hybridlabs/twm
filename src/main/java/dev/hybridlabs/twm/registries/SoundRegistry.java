package dev.hybridlabs.twm.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.hybridlabs.twm.Main.MODID;

public class SoundRegistry {
  public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);
  
  public static final RegistryObject<SoundEvent> SOUL_HIT = SOUND_EVENTS.register("soul_hit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "soul_hit")));
  public static final RegistryObject<SoundEvent> SOUL_ATTACK = SOUND_EVENTS.register("soul_attack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "soul_attack")));
  public static final RegistryObject<SoundEvent> SOUL_DEATH = SOUND_EVENTS.register("soul_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "soul_death")));
  public static final RegistryObject<SoundEvent> KATANA_SHEATHE = SOUND_EVENTS.register("katana_sheathe", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "katana_sheathe")));
  public static final RegistryObject<SoundEvent> BLOODTHIRSTER = SOUND_EVENTS.register("the_bloodthirster", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "the_bloodthirster")));
  public static final RegistryObject<SoundEvent> BLOODTHIRSTER_DEEP = SOUND_EVENTS.register("the_bloodthirster_deep", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "the_bloodthirster_deep")));
  
  public static void init(IEventBus modEventBus) {
    SOUND_EVENTS.register(modEventBus);
  }
}
