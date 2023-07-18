package dev.hybridlabs.tugkan_weaponry.items.armor;

import dev.hybridlabs.tugkan_weaponry.client.models.BrightsteelArmorModel;
import dev.hybridlabs.tugkan_weaponry.items.ArmoryMaterials;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

import static dev.hybridlabs.tugkan_weaponry.Main.MODID;

public abstract class BrightsteelArmor extends ArmorItem {
  public BrightsteelArmor(Type armorType, Properties properties) {
    super(ArmoryMaterials.BRIGHTSTEEL, armorType, properties);
  }
  
  public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
    return new ResourceLocation(MODID, "textures/models/brightsteel_armor.png").toString();
  }
  
  public static class Boots extends BrightsteelArmor {
    public Boots() {
      super(Type.BOOTS, new Item.Properties());
    }
    
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      consumer.accept(new IClientItemExtensions() {
        @OnlyIn(Dist.CLIENT) @NotNull
        public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
          return new HumanoidModel<>(
            new ModelPart(Collections.emptyList(), Map.of(
                "left_leg", (new BrightsteelArmorModel.Boots<>(Minecraft.getInstance().getEntityModels().bakeLayer(BrightsteelArmorModel.Boots.LAYER_LOCATION))).LeftFoot,
                "right_leg", (new BrightsteelArmorModel.Boots<>(Minecraft.getInstance().getEntityModels().bakeLayer(BrightsteelArmorModel.Boots.LAYER_LOCATION))).RightFoot,
                "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())
            )));
        }
      });
    }
  }

  public static class Leggings extends BrightsteelArmor {
    public Leggings() {
      super(Type.LEGGINGS, new Item.Properties());
    }
    
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      consumer.accept(new IClientItemExtensions() {
        @OnlyIn(Dist.CLIENT) @NotNull
        public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
          return new HumanoidModel<>(
            new ModelPart(Collections.emptyList(), Map.of(
              "left_leg", (new BrightsteelArmorModel.Leggings<>(Minecraft.getInstance().getEntityModels().bakeLayer(BrightsteelArmorModel.Leggings.LAYER_LOCATION))).LeftLeg,
              "right_leg", (new BrightsteelArmorModel.Leggings<>(Minecraft.getInstance().getEntityModels().bakeLayer(BrightsteelArmorModel.Leggings.LAYER_LOCATION))).RightLeg,
              "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())
              )));
        }
      });
    }
    
  }

  public static class Chestplate extends BrightsteelArmor {
    public Chestplate() {
      super(Type.CHESTPLATE, new Item.Properties());
    }
    
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      consumer.accept(new IClientItemExtensions() {
        @OnlyIn(Dist.CLIENT) @NotNull
        public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
          return new HumanoidModel<>(
            new ModelPart(Collections.emptyList(), Map.of(
              "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "body", (new BrightsteelArmorModel.Chestplate<>(Minecraft.getInstance().getEntityModels().bakeLayer(BrightsteelArmorModel.Chestplate.LAYER_LOCATION))).Body,
              "right_arm", (new BrightsteelArmorModel.Chestplate<>(Minecraft.getInstance().getEntityModels().bakeLayer(BrightsteelArmorModel.Chestplate.LAYER_LOCATION))).rightArm,
              "left_arm", (new BrightsteelArmorModel.Chestplate<>(Minecraft.getInstance().getEntityModels().bakeLayer(BrightsteelArmorModel.Chestplate.LAYER_LOCATION))).leftArm
            )));
        }
      });
    }
  }

  public static class Helmet extends BrightsteelArmor {
    public Helmet() {
      super(Type.HELMET, new Item.Properties());
    }
    
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      consumer.accept(new IClientItemExtensions() {
        @OnlyIn(Dist.CLIENT) @NotNull
        public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
          return new HumanoidModel<>(
            new ModelPart(Collections.emptyList(), Map.of(
              "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "head", (new BrightsteelArmorModel.Helmet<>(Minecraft.getInstance().getEntityModels().bakeLayer(BrightsteelArmorModel.Helmet.LAYER_LOCATION))).head,
              "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
              "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())
            )));
        }
      });
    }
  }
}
