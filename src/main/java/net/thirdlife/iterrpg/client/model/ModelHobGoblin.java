package net.thirdlife.iterrpg.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelHobGoblin<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "model_hob_goblin"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;

	public ModelHobGoblin(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leftArm = root.getChild("leftArm");
		this.rightArm = root.getChild("rightArm");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(53, 21).addBox(-5.0F, -2.0F, -8.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 23).addBox(-5.0F, -3.0F, -8.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(3.0F, -3.0F, -8.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 57).addBox(-5.0F, -9.0F, -7.0F, 10.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-9.0F, -6.0F, -2.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(5.0F, -6.0F, -2.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(43, 0)
						.addBox(-2.0F, -5.0F, -9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -6.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 45).addBox(-7.0F, 3.0F, -4.0F, 14.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.0F, -6.0F, -5.0F, 16.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-8.0F, 3.0F, -5.0F, 16.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 33).addBox(-8.0F, -7.0F, -5.0F, 16.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 1.0F));
		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm",
				CubeListBuilder.create().texOffs(68, 67).addBox(-1.0F, 7.0F, -3.4F, 7.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(53, 0).addBox(-1.0F, -4.0F, -4.4F, 9.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(84, 12)
						.addBox(-1.0F, 7.0F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(82, 35).addBox(-1.0F, -6.0F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(9.0F, -2.0F, 1.0F));
		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm",
				CubeListBuilder.create().texOffs(0, 63).addBox(-6.0F, 8.0F, -3.5F, 7.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(45, 36).addBox(-8.0F, -3.0F, -4.5F, 9.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(73, 48)
						.addBox(-8.0F, 8.0F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(29, 74).addBox(-8.0F, -5.0F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-9.0F, -3.0F, 1.0F));
		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(48, 86).addBox(-4.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 12.0F, 1.0F));
		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(23, 86).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 12.0F, 1.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.6F) * 1.0F * limbSwingAmount;
		this.rightArm.xRot = Mth.cos(limbSwing * 0.6F + (float) Math.PI) * limbSwingAmount - 2.2F * Mth.sin(attackTime * Mth.PI);
		this.rightArm.yRot = -0.2F * Mth.sin(attackTime * Mth.PI);
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6F) * limbSwingAmount - 2.2F * Mth.sin(attackTime * Mth.PI);
		this.leftArm.yRot = 0.2F * Mth.sin(attackTime * Mth.PI);;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.6F) * -1.0F * limbSwingAmount;
		this.leftArm.zRot = (Mth.sin(ageInTicks / 32) / -64) - 0.03F;
		this.rightArm.zRot = (Mth.sin(ageInTicks / 32) / 64) + 0.03F;
	}
}
