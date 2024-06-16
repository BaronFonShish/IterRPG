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
public class Modelmournstone<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelmournstone"), "main");

	public final ModelPart the;
	// the
	public final ModelPart body;
	public final ModelPart chains;
	// body
	public final ModelPart head;
	public final ModelPart hanging_chains;
	// hanging_chains
	public final ModelPart hanging_chain1;
	public final ModelPart hanging_chain2;
	public final ModelPart hanging_chain3;

	public Modelmournstone(ModelPart root) {
		this.the = root.getChild("the");
		// the
		this.body = the.getChild("body");
		this.chains = the.getChild("chains");
		// body
		this.head = body.getChild("head");
		this.hanging_chains = body.getChild("hanging_chains");
		//hanging_chains
		this.hanging_chain1 = hanging_chains.getChild("hanging_chain1");
		this.hanging_chain2 = hanging_chains.getChild("hanging_chain2");
		this.hanging_chain3 = hanging_chains.getChild("hanging_chain3");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition the = partdefinition.addOrReplaceChild("the", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition body = the.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -33.0F, 0.0F));
		PartDefinition phantom = head.addOrReplaceChild("phantom", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hanging_chains = body.addOrReplaceChild("hanging_chains", CubeListBuilder.create(), PartPose.offset(0.0F, -25.0F, 0.0F));
		PartDefinition hanging_chain1 = hanging_chains.addOrReplaceChild("hanging_chain1", CubeListBuilder.create().texOffs(5, 40).addBox(0.0F, 0.0F, -1.5F, 0.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition chain_r1 = hanging_chain1.addOrReplaceChild("chain_r1", CubeListBuilder.create().texOffs(5, 37).addBox(0.0F, -8.0F, -1.5F, 0.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition hanging_chain2 = hanging_chains.addOrReplaceChild("hanging_chain2", CubeListBuilder.create().texOffs(5, 46).mirror().addBox(0.0F, 0.0F, -1.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-4.0F, 0.0F, 4.0F));
		PartDefinition chain_r2 = hanging_chain2.addOrReplaceChild("chain_r2", CubeListBuilder.create().texOffs(5, 42).addBox(0.0F, -9.0F, -1.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition hanging_chain3 = hanging_chains.addOrReplaceChild("hanging_chain3", CubeListBuilder.create().texOffs(5, 47).mirror().addBox(0.0F, 0.0F, -1.5F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(4.0F, 0.0F, -3.0F));
		PartDefinition chain_r3 = hanging_chain3.addOrReplaceChild("chain_r3", CubeListBuilder.create().texOffs(5, 43).addBox(0.0F, -9.0F, -1.5F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition chains = the.addOrReplaceChild("chains", CubeListBuilder.create(), PartPose.offset(0.0F, -33.0F, 0.0F));
		PartDefinition chains_r1 = chains.addOrReplaceChild("chains_r1", CubeListBuilder.create().texOffs(0, 99).addBox(-13.0F, -1.5F, -13.0F, 26.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, -3.1416F, 0.829F, 0.0436F));
		PartDefinition chains_r2 = chains.addOrReplaceChild("chains_r2", CubeListBuilder.create().texOffs(0, 99).addBox(-13.0F, -0.5F, -13.0F, 26.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 3.1416F, 0.5672F, -0.2182F));
		PartDefinition chains_r3 = chains.addOrReplaceChild("chains_r3", CubeListBuilder.create().texOffs(0, 99).addBox(-13.0F, -1.5F, -13.0F, 26.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.5F, 0.0F, 3.1416F, 0.0F, 0.0873F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = ageInTicks / 20F + Mth.sin(attackTime * Mth.PI);
		this.hanging_chains.yRot = ageInTicks / 20F + Mth.sin(attackTime * Mth.PI);
		this.chains.yRot = ageInTicks / -20F - Mth.sin(attackTime * Mth.PI);
		this.hanging_chain2.xRot = (-10 * Mth.PI / 180) - Mth.sin(ageInTicks / 8) / 6;
		this.hanging_chain3.xRot = (15 * Mth.PI / 180) + Mth.sin(ageInTicks / 6) / 4;

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		the.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
