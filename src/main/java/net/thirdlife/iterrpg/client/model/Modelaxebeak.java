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

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelaxebeak<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelaxebeak"), "main");
	public final ModelPart body;
	public final ModelPart neck;
	public final ModelPart beak_upper;
	public final ModelPart beak_lower;
	public final ModelPart wing_right;
	public final ModelPart wing_left;
	public final ModelPart leg_right;
	public final ModelPart leg_left;

	public Modelaxebeak(ModelPart root) {
		this.body = root.getChild("body");
		this.neck = this.body.getChild("neck");
		this.beak_upper = this.neck.getChild("beak_upper");
		this.beak_lower = this.neck.getChild("beak_lower");
		this.wing_right = this.body.getChild("wing_right");
		this.wing_left = this.body.getChild("wing_left");
		this.leg_right = root.getChild("leg_right");
		this.leg_left = root.getChild("leg_left");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -14.0F, -14.0F, 14.0F, 17.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(35, 43).addBox(-5.0F, -17.0F, 6.0F, 10.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.0F, 3.0F));
		PartDefinition neck = body.addOrReplaceChild("neck",
				CubeListBuilder.create().texOffs(0, 43).addBox(-4.0F, -21.0F, -7.0F, 8.0F, 25.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, -1).addBox(0.0F, -25.0F, -3.0F, 0.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -7.0F, -14.0F));
		PartDefinition beak_upper = neck.addOrReplaceChild("beak_upper", CubeListBuilder.create().texOffs(76, 81).addBox(-2.0F, -4.0F, -8.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(53, 0)
				.addBox(-2.0F, -4.0F, -10.0F, 4.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(84, 66).addBox(0.0F, -9.0F, -10.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, -7.0F));
		PartDefinition beak_lower = neck.addOrReplaceChild("beak_lower", CubeListBuilder.create().texOffs(40, 65).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(9, 0)
				.addBox(-2.0F, 2.0F, -10.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(70, 40).addBox(0.0F, 4.0F, -10.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, -7.0F));
		PartDefinition wing_right = body.addOrReplaceChild("wing_right", CubeListBuilder.create().texOffs(22, 65).addBox(-2.0F, -5.0F, 0.0F, 2.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -7.0F, -10.0F));
		PartDefinition wing_left = body.addOrReplaceChild("wing_left", CubeListBuilder.create().texOffs(22, 65).mirror().addBox(0.0F, -5.0F, 0.0F, 2.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -7.0F, -10.0F));
		PartDefinition leg_right = partdefinition.addOrReplaceChild("leg_right",
				CubeListBuilder.create().texOffs(80, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 52).addBox(-4.0F, 19.0F, -8.0F, 8.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 5.0F, 2.0F));
		PartDefinition leg_left = partdefinition.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(80, 16).mirror().addBox(-2.0F, 0.0F, -1.0F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(64, 52).mirror()
				.addBox(-4.0F, 19.0F, -8.0F, 8.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 5.0F, 2.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.neck.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.neck.xRot = headPitch / (180F / (float) Math.PI) + (1.0F * Mth.sin(attackTime * Mth.PI)) + Mth.cos(limbSwing * 1.0F) * 0.25F * limbSwingAmount;
		this.body.zRot = Mth.cos(limbSwing * 0.8F) * 0.1F * limbSwingAmount;
		this.beak_lower.xRot = Mth.sin(limbSwingAmount);
		this.body.xRot = Mth.sin(limbSwing * 1.0F) * 0.05F * limbSwingAmount + (0.25F * Mth.sin(attackTime * Mth.PI));
		this.leg_left.xRot = Mth.cos(limbSwing * 0.8F) * -1.0F * limbSwingAmount;
		this.leg_right.xRot = Mth.cos(limbSwing * 0.8F) * 1.0F * limbSwingAmount;
		this.wing_right.yRot = Mth.abs(Mth.cos(limbSwing * 0.8F) * 0.5F * limbSwingAmount) * -1.0F;
		this.wing_left.yRot = Mth.abs(Mth.cos(limbSwing * 0.8F) * 0.5F * limbSwingAmount);
	}
}
