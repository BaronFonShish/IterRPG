package net.thirdlife.iterrpg.client.model;

import net.minecraft.world.entity.Entity;
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

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelchainholder<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelchainholder"), "main");
	public final ModelPart base;
	public final ModelPart chain;
	public final ModelPart segment1;
	public final ModelPart segment2;
	public final ModelPart segment3;

	public Modelchainholder(ModelPart root) {
		this.base = root.getChild("base");
		this.chain = root.getChild("chain");
		this.segment1 = root.getChild("segment1");
		this.segment2 = root.getChild("segment2");
		this.segment3 = root.getChild("segment3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition chain = partdefinition.addOrReplaceChild("chain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 21.0F, 2.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition segment1 = chain.addOrReplaceChild("segment1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition right_r1 = segment1.addOrReplaceChild("right_r1",
				CubeListBuilder.create().texOffs(32, 17).addBox(-2.0F, 5.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(36, 0).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));
		PartDefinition right_r2 = segment1.addOrReplaceChild("right_r2",
				CubeListBuilder.create().texOffs(32, 17).addBox(-2.0F, 5.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(-2.0F, 3.0F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(16, 19)
						.addBox(-2.0F, -5.0F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 0).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 27)
						.addBox(1.0F, -5.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 29).addBox(-4.0F, -5.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition segment2 = chain.addOrReplaceChild("segment2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition right_r3 = segment2.addOrReplaceChild("right_r3",
				CubeListBuilder.create().texOffs(32, 17).addBox(-2.0F, 5.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(36, 0).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));
		PartDefinition right_r4 = segment2.addOrReplaceChild("right_r4",
				CubeListBuilder.create().texOffs(32, 17).addBox(-2.0F, 5.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(-2.0F, 3.0F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(16, 19)
						.addBox(-2.0F, -5.0F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 0).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 27)
						.addBox(1.0F, -5.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 29).addBox(-4.0F, -5.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition segment3 = chain.addOrReplaceChild("segment3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -40.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition right_r5 = segment3.addOrReplaceChild("right_r5",
				CubeListBuilder.create().texOffs(32, 17).addBox(-2.0F, 5.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(36, 0).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));
		PartDefinition right_r6 = segment3.addOrReplaceChild("right_r6",
				CubeListBuilder.create().texOffs(32, 17).addBox(-2.0F, 5.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(-2.0F, 3.0F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(16, 19)
						.addBox(-2.0F, -5.0F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 0).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 27)
						.addBox(1.0F, -5.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 29).addBox(-4.0F, -5.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
