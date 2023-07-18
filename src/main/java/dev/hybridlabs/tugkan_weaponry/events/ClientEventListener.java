package dev.hybridlabs.tugkan_weaponry.events;

import dev.hybridlabs.tugkan_weaponry.client.models.BrightsteelArmorModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventListener {
  @SubscribeEvent
  public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
    event.registerLayerDefinition(BrightsteelArmorModel.Boots.LAYER_LOCATION, BrightsteelArmorModel.Boots::createBodyLayer);
    event.registerLayerDefinition(BrightsteelArmorModel.Leggings.LAYER_LOCATION, BrightsteelArmorModel.Leggings::createBodyLayer);
    event.registerLayerDefinition(BrightsteelArmorModel.Chestplate.LAYER_LOCATION, BrightsteelArmorModel.Chestplate::createBodyLayer);
    event.registerLayerDefinition(BrightsteelArmorModel.Helmet.LAYER_LOCATION, BrightsteelArmorModel.Helmet::createBodyLayer);
  }
}
