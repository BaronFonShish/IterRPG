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
public class ModelScab<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "model_scab"), "main");

	public final ModelPart mob;
	//root
	public final ModelPart tail;
	public final ModelPart front_right_leg;
	public final ModelPart front_left_leg;
	public final ModelPart hind_right_leg;
	public final ModelPart hind_left_leg;
	public final ModelPart left_claw;
	public final ModelPart right_claw;
	//tail
	public final ModelPart stinger;

	public ModelScab(ModelPart root) {
		this.mob = root.getChild("mob");
		//
		this.tail = mob.getChild("tail");
		this.front_right_leg = mob.getChild("front_right_leg");
		this.front_left_leg = mob.getChild("front_left_leg");
		this.hind_right_leg = mob.getChild("hind_right_leg");
		this.hind_left_leg = mob.getChild("hind_left_leg");
		this.left_claw = mob.getChild("left_claw");
		this.right_claw = mob.getChild("right_claw");
		this.stinger = tail.getChild("stinger");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition mob = partdefinition.addOrReplaceChild("mob", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -6.0F, 10.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition tail = mob.addOrReplaceChild("tail",
				CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -17.0F, -5.0F, 0.0F, 17.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 40).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -7.0F, 5.0F));
		PartDefinition stinger = tail.addOrReplaceChild("stinger", CubeListBuilder.create().texOffs(24, 11).addBox(0.0F, -2.0F, -11.0F, 0.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, -5.0F));
		PartDefinition front_right_leg = mob.addOrReplaceChild("front_right_leg", CubeListBuilder.create(), PartPose.offset(-5.0F, -3.0F, -3.0F));
		PartDefinition claw_r1 = front_right_leg.addOrReplaceChild("claw_r1", CubeListBuilder.create().texOffs(32, 7).addBox(-8.0F, -2.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));
		PartDefinition front_left_leg = mob.addOrReplaceChild("front_left_leg", CubeListBuilder.create(), PartPose.offset(5.0F, -3.0F, -3.0F));
		PartDefinition claw_r2 = front_left_leg.addOrReplaceChild("claw_r2", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -2.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));
		PartDefinition hind_right_leg = mob.addOrReplaceChild("hind_right_leg", CubeListBuilder.create(), PartPose.offset(-5.0F, -3.0F, 3.0F));
		PartDefinition claw_r3 = hind_right_leg.addOrReplaceChild("claw_r3", CubeListBuilder.create().texOffs(16, 18).addBox(-8.0F, -2.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));
		PartDefinition hind_left_leg = mob.addOrReplaceChild("hind_left_leg", CubeListBuilder.create(), PartPose.offset(5.0F, -3.0F, 3.0F));
		PartDefinition claw_r4 = hind_left_leg.addOrReplaceChild("claw_r4", CubeListBuilder.create().texOffs(32, 18).addBox(0.0F, -2.0F, 0.0F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));
		PartDefinition left_claw = mob.addOrReplaceChild("left_claw", CubeListBuilder.create().texOffs(33, 0).addBox(-3.0F, -1.0F, -6.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.1F, -6.0F));
		PartDefinition right_claw = mob.addOrReplaceChild("right_claw", CubeListBuilder.create().texOffs(25, 0).addBox(-1.0F, -1.0F, -6.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -2.1F, -6.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mob.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tail.xRot = (Mth.sin(ageInTicks / 16 + Mth.PI / 4) / 18) + 0.8F * Mth.sin(attackTime * Mth.PI + 0.05F);
		this.stinger.xRot = (Mth.sin(ageInTicks / 16) / 18) + 1F * -Mth.sin(attackTime * Mth.PI);

		this.right_claw.yRot = -((Mth.sin(ageInTicks / 7) / 10) * (Mth.sin(ageInTicks / 7) / 10)) * 2.5F;
		this.left_claw.yRot = ((Mth.sin(ageInTicks / 7) / 10) * (Mth.sin(ageInTicks / 7) / 10)) * 2.5F;

		this.front_right_leg.zRot = Mth.sin(limbSwing * 1F) * 0.5F * limbSwingAmount;
		this.front_right_leg.yRot = Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

		this.front_left_leg.zRot = Mth.sin(limbSwing * 1F) * 0.5F * limbSwingAmount;
		this.front_left_leg.yRot = Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

		this.hind_right_leg.zRot = Mth.sin(limbSwing * 1F) * -0.5F * limbSwingAmount;
		this.hind_right_leg.yRot = Mth.cos(limbSwing * 1F) * -0.5F * limbSwingAmount;

		this.hind_left_leg.zRot = Mth.sin(limbSwing * 1F) * -0.5F * limbSwingAmount;
		this.hind_left_leg.yRot = Mth.cos(limbSwing * 1F) * -0.5F * limbSwingAmount;

		this.mob.zRot = Mth.sin(limbSwing * 1F) * 0.1F * limbSwingAmount;
	}
}
