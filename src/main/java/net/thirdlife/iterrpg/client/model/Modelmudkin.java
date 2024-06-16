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
public class Modelmudkin<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelmudkin"), "main");
	public final ModelPart body;
	public final ModelPart right_leg;
	public final ModelPart left_leg;

	public Modelmudkin(ModelPart root) {
		this.body = root.getChild("body");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -19.0F, -8.0F, 16.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 0.0F));
		PartDefinition plamt_r1 = body.addOrReplaceChild("plamt_r1", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, -8.5F, -8.0F, 0.0F, 17.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -27.5F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition plamt_r2 = body.addOrReplaceChild("plamt_r2", CubeListBuilder.create().texOffs(33, 19).mirror().addBox(0.0F, -8.5F, -8.0F, 0.0F, 17.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -27.5F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 52).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 17.0F, 0.5F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(4.5F, 17.0F, 0.5F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.body.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.body.zRot = headPitch / (180F / (float) Math.PI) + Mth.cos(limbSwing * 1F) * 0.25F * limbSwingAmount;
		this.body.xRot = 0.75F * Mth.sin(attackTime * Mth.PI);
	}
}
