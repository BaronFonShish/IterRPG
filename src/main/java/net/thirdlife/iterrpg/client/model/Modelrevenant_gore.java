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

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelrevenant_gore<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelrevenant_gore"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart right_arm;
	public final ModelPart left_leg;
	public final ModelPart right_leg;
	public final ModelPart left_arm;

	public Modelrevenant_gore(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.right_arm = root.getChild("right_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.left_arm = root.getChild("left_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition horn_r1 = head.addOrReplaceChild("horn_r1", CubeListBuilder.create().texOffs(34, 15).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, -6.0F, 2.0F, -0.9599F, 0.0F, 0.7418F));
		PartDefinition horn_r2 = head.addOrReplaceChild("horn_r2", CubeListBuilder.create().texOffs(34, 15).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -7.0F, -2.0F, -0.5236F, 0.0F, -0.5236F));
		PartDefinition horn_r3 = head.addOrReplaceChild("horn_r3", CubeListBuilder.create().texOffs(34, 15).mirror().addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, -7.0F, -2.0F, -0.5236F, 0.0F, 0.5236F));
		PartDefinition horn_r4 = head.addOrReplaceChild("horn_r4", CubeListBuilder.create().texOffs(34, 15).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -6.0F, 2.0F, -0.9599F, 0.0F, -0.7418F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(42, 0).mirror()
				.addBox(-2.0F, 5.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-5.0F, 1.0F, 0.0F));
		PartDefinition claw_r1 = right_arm.addOrReplaceChild("claw_r1", CubeListBuilder.create().texOffs(43, 10).mirror().addBox(-1.0F, -3.0F, 0.25F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.5F, 11.0F, 0.75F, 0.0F, -0.0873F, 0.0F));
		PartDefinition claw_r2 = right_arm.addOrReplaceChild("claw_r2", CubeListBuilder.create().texOffs(43, 10).mirror().addBox(-1.0F, -3.0F, -0.25F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.5F, 11.0F, -0.75F, 0.0F, 0.0873F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(23, 32).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.1F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(25, 17).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.1F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 30).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(5.0F, 1.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_arm.xRot = Mth.cos(limbSwing * 0.666F + (float) Math.PI) * limbSwingAmount - 1.6F * Mth.sin(attackTime * Mth.PI);
		this.right_arm.yRot = 0.6F * Mth.sin(attackTime * Mth.PI * 2F);
		this.left_leg.xRot = Mth.cos(limbSwing * 0.666F) * -1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.666F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 0.666F) * 1.0F * limbSwingAmount;
		this.right_arm.zRot = (Mth.sin(ageInTicks / 16) / 20) + 0.1F;
		this.left_arm.zRot = (Mth.sin(ageInTicks / 16) / -20) - 0.1F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
