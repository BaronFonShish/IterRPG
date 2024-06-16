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

// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeldwarf<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modeldwarf"), "main");
	// dwarf (whole)
	public final ModelPart upper_body;
	// upper_body list
	public final ModelPart body;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	// body list
	public final ModelPart nose;
	// legs
	public final ModelPart right_leg;
	public final ModelPart left_leg;

	public Modeldwarf(ModelPart root) {
		// root
		this.upper_body = root.getChild("upper_body");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		// upper_body
		this.body = upper_body.getChild("body");
		this.right_arm = upper_body.getChild("right_arm");
		this.left_arm = upper_body.getChild("left_arm");
		// body
		this.nose = body.getChild("nose");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition upper_body = partdefinition.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));
		PartDefinition body = upper_body.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -18.0F, -6.0F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 30).addBox(-6.0F, -18.0F, -6.0F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition nose = body.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(52, 0).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, -7.0F));
		PartDefinition right_arm = upper_body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 60).addBox(-4.0F, -2.0F, -3.0F, 4.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -8.0F, 0.0F));
		PartDefinition left_arm = upper_body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 60).mirror().addBox(0.0F, -2.0F, -3.0F, 4.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -8.0F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(20, 60).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(20, 60).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(3.0F, 18.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 96);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		upper_body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.upper_body.xRot = (headPitch / (180F / (float) Math.PI)) / 1.2F;
		this.right_arm.xRot = Mth.cos(limbSwing * 0.7F + (float) Math.PI) * limbSwingAmount - 1.6F * Mth.sin(attackTime * Mth.PI);
		this.right_arm.zRot = (Mth.sin(ageInTicks / 16) / 16) + 0.125F;
		this.right_arm.yRot = 0.6F * Mth.sin(attackTime * Mth.PI * 2F);
		this.left_arm.xRot = Mth.cos(limbSwing * 0.7F) * limbSwingAmount;
		this.left_arm.zRot = (Mth.sin(ageInTicks / 16) / -16) - 0.125F;
		this.left_leg.xRot = Mth.cos(limbSwing * 0.7F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 0.7F) * 1.0F * limbSwingAmount;
		this.nose.xRot = Mth.cos(ageInTicks / 32) / 16;
		this.nose.zRot = Mth.sin(ageInTicks / 24) / 16;
	}
}
