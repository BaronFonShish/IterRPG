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

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelcarcass<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelcarcass"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart right_leg;
	public final ModelPart left_leg;

	public Modelcarcass(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -11.0F, -6.0F, 12.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(45, 9).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(35, 0).addBox(-3.0F, -10.0F, -3.375F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 22).addBox(-7.0F, -8.0F, -4.375F, 14.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(82, 0)
						.addBox(-7.0F, -8.0F, -4.375F, 14.0F, 10.0F, 9.0F, new CubeDeformation(0.15F)).texOffs(40, 35).addBox(-5.0F, 2.0F, -3.375F, 10.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(94, 43)
						.addBox(-5.0F, 2.0F, -3.375F, 10.0F, 4.0F, 7.0F, new CubeDeformation(0.1F)).texOffs(38, 15).addBox(-6.0F, 6.0F, -3.375F, 12.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(90, 55)
						.addBox(-6.0F, 6.0F, -3.375F, 12.0F, 4.0F, 7.0F, new CubeDeformation(0.2F)),
				PartPose.offset(0.0F, -2.0F, 0.375F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(0, 42).addBox(-5.0F, -2.5F, -2.5F, 5.0F, 20.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(79, 22).addBox(-5.0F, -2.5F, -2.5F, 5.0F, 20.0F, 5.0F, new CubeDeformation(0.2F)),
				PartPose.offset(-7.0F, -7.5F, 0.5F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 42).mirror().addBox(0.0F, -2.5F, -2.5F, 5.0F, 20.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(79, 22).mirror()
				.addBox(0.0F, -2.5F, -2.5F, 5.0F, 20.0F, 5.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(7.0F, -7.5F, 0.5F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(21, 42).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(108, 21).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.2F)),
				PartPose.offset(-3.5F, 8.0F, 0.5F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(21, 42).mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(108, 21).mirror()
				.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offset(3.5F, 8.0F, 0.5F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_arm.xRot = Mth.cos(limbSwing * 0.666F + (float) Math.PI) * limbSwingAmount - 1.6F * Mth.sin(attackTime * Mth.PI);
		this.right_arm.yRot = 0.6F * Mth.sin(attackTime * Mth.PI * 2F);
		this.left_arm.xRot = Mth.cos(limbSwing * 0.666F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 0.666F) * 1.0F * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 0.666F) * -1.0F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
