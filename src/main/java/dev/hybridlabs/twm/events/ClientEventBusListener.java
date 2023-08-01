package dev.hybridlabs.twm.events;

import dev.hybridlabs.twm.client.models.BrightsteelArmorModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static dev.hybridlabs.twm.Main.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusListener {
  @SubscribeEvent
  public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
    event.registerLayerDefinition(BrightsteelArmorModel.Boots.LAYER_LOCATION, BrightsteelArmorModel.Boots::createBodyLayer);
    event.registerLayerDefinition(BrightsteelArmorModel.Leggings.LAYER_LOCATION, BrightsteelArmorModel.Leggings::createBodyLayer);
    event.registerLayerDefinition(BrightsteelArmorModel.Chestplate.LAYER_LOCATION, BrightsteelArmorModel.Chestplate::createBodyLayer);
    event.registerLayerDefinition(BrightsteelArmorModel.Helmet.LAYER_LOCATION, BrightsteelArmorModel.Helmet::createBodyLayer);
  }
}
