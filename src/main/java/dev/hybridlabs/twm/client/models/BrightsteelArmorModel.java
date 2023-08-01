package dev.hybridlabs.twm.client.models;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import static dev.hybridlabs.twm.Main.MODID;

public class BrightsteelArmorModel <T extends LivingEntity> extends HumanoidModel<T> {
  public final ModelPart LeftFoot;
  public final ModelPart LeftLeg;
  public final ModelPart RightFoot;
  public final ModelPart RightLeg;
  public final ModelPart Body;
  public final ModelPart LeftArm;
  public final ModelPart RightArm;
  public final ModelPart Head;
  
  public BrightsteelArmorModel(ModelPart root) {
    super(root);
    this.LeftFoot = root.getChild("left_foot");
    this.LeftLeg = root.getChild("left_leg");
    this.RightFoot = root.getChild("right_foot");
    this.RightLeg = root.getChild("right_leg");
    this.Body = root.getChild("body");
    this.LeftArm = root.getChild("left_arm");
    this.RightArm = root.getChild("right_arm");
    this.Head = root.getChild("head");
  }
  
  public static class Boots<T extends LivingEntity> extends BrightsteelArmorModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "brightsteel_armor_boots"), "main");
    public Boots(ModelPart root) {
      super(root);
    }
    
    public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(108, 51).addBox(-1.6F, 6.6F, -3.0F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.6F)), PartPose.offset(1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(108, 51).mirror().addBox(-2.4F, 6.6F, -3.0F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.6F)).mirror(false), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
      return LayerDefinition.create(meshdefinition, 128, 128);
    }
  }
  
  public static class Leggings<T extends LivingEntity> extends BrightsteelArmorModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "brightsteel_armor_leggings"), "main");
    public Leggings(ModelPart root) {
      super(root);
    }
    
    public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("left_foot", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(110, 84).addBox(-1.9F, -1.1F, -2.5F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("right_foot", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(110, 84).mirror().addBox(-2.1F, -1.1F, -2.5F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(-1.9F, 12.0F, 0.0F));
      partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
      return LayerDefinition.create(meshdefinition, 128, 128);
    }
  }
  
  public static class Chestplate<T extends LivingEntity> extends BrightsteelArmorModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "brightsteel_armor_chestplate"), "main");
    public Chestplate(ModelPart root) {
      super(root);
    }
    
    public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("left_foot", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("right_foot", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
      PartDefinition chestplate = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 104).addBox(-4.0F, 6.8F, -2.5F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.49F))
        .texOffs(0, 114).addBox(-5.0F, -0.5F, -3.5F, 10.0F, 7.0F, 7.0F, new CubeDeformation(-0.1F))
        .texOffs(36, 102).mirror().addBox(-5.0F, 8.0F, -3.5F, 10.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
        .texOffs(35, 89).addBox(-5.0F, 9.0F, -3.5F, 10.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition chestplate1 = chestplate.addOrReplaceChild("chestplate1", CubeListBuilder.create().texOffs(56, 110).mirror().addBox(0.3F, 0.3F, 0.3F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.7F)).mirror(false), PartPose.offsetAndRotation(-4.3F, 9.6F, -2.8F, 0.0F, 0.0F, 0.1745F));
      PartDefinition chestplate2 = chestplate.addOrReplaceChild("chestplate2", CubeListBuilder.create().texOffs(56, 110).addBox(-2.3F, 0.3F, 0.3F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.7F)), PartPose.offsetAndRotation(4.3F, 9.6F, -2.8F, 0.0F, 0.0F, -0.1745F));
      PartDefinition chestplateleft = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(57, 120).addBox(2.9F, 1.575F, -2.5F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.25F))
        .texOffs(35, 110).mirror().addBox(-0.1F, -2.5F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition chestplateleft1 = chestplateleft.addOrReplaceChild("chestplateleft1", CubeListBuilder.create().texOffs(0, 96).addBox(0.0F, -2.0F, 0.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, -1.5F, -3.0F, 0.0F, 0.0F, 0.3927F));
      PartDefinition chestplateleft2 = chestplateleft.addOrReplaceChild("chestplateleft2", CubeListBuilder.create().texOffs(21, 100).mirror().addBox(0.0F, -2.0F, 0.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9F, 0.575F, -3.0F, 0.0F, 0.0F, 0.7854F));
      PartDefinition chestplateright = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(57, 120).mirror().addBox(-4.9F, 1.575F, -2.5F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.25F)).mirror(false)
        .texOffs(35, 110).addBox(-4.9F, -2.5F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition chestplateright1 = chestplateright.addOrReplaceChild("chestplateright1", CubeListBuilder.create().texOffs(0, 96).mirror().addBox(-4.0F, -2.0F, 0.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.9F, -1.5F, -3.0F, 0.0F, 0.0F, -0.3927F));
      PartDefinition chestplateright2 = chestplateright.addOrReplaceChild("chestplateright2", CubeListBuilder.create().texOffs(21, 100).addBox(-5.0F, -2.0F, 0.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 0.575F, -3.0F, 0.0F, 0.0F, -0.7854F));
      partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
      return LayerDefinition.create(meshdefinition, 128, 128);
    }
  }
  
  public static class Helmet<T extends LivingEntity> extends BrightsteelArmorModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "brightsteel_armor_helmet"), "main");
    public Helmet(ModelPart root) {
      super(root);
    }
    
    public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("left_foot", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("right_foot", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
      partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
      PartDefinition helmet = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(17, 17).addBox(4.0F, -9.0F, -2.0F, 1.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
        .texOffs(0, 10).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
        .texOffs(0, 17).addBox(-1.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
        .texOffs(0, 17).addBox(-5.0F, -9.0F, -2.0F, 1.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
        .texOffs(0, 0).addBox(-4.0F, -9.0F, -2.0F, 8.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
        .texOffs(27, 10).addBox(-4.0F, -7.0F, 3.0F, 8.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
      PartDefinition helmet1 = helmet.addOrReplaceChild("helmet1", CubeListBuilder.create().texOffs(10, 17).addBox(-4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
        .texOffs(27, 19).addBox(-4.0F, -4.0F, 3.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
        .texOffs(54, 0).addBox(-4.0F, -4.0F, 2.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, -6.0F, -0.3491F, 0.0F, 0.0F));
      PartDefinition helmet2 = helmet.addOrReplaceChild("helmet2", CubeListBuilder.create().texOffs(52, 9).mirror().addBox(0.0F, 0.0F, -10.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false)
        .texOffs(52, 9).addBox(9.0F, 0.0F, -10.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-5.0F, -8.5622F, 0.634F, 1.0472F, 0.0F, 0.0F));
      PartDefinition helmet3 = helmet.addOrReplaceChild("helmet3", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, 0.0F, -1.0F, 10.0F, 3.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-5.0F, -3.0F, 5.0F, 0.5236F, 0.0F, 0.0F));
      partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
      return LayerDefinition.create(meshdefinition, 128, 128);
    }
  }
}
