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

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelfire_elemental<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelfire_elemental"), "main");
	public final ModelPart head;
	public final ModelPart big_storm;
	public final ModelPart medium_storm;
	public final ModelPart small_storm;

	public Modelfire_elemental(ModelPart root) {
		this.head = root.getChild("head");
		this.big_storm = root.getChild("big_storm");
		this.medium_storm = root.getChild("medium_storm");
		this.small_storm = root.getChild("small_storm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition big_storm = partdefinition.addOrReplaceChild("big_storm", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition big_flame1 = big_storm.addOrReplaceChild("big_flame1",
				CubeListBuilder.create().texOffs(19, 1).addBox(8.0F, -6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 17).addBox(7.0F, -16.0F, 0.0F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition big_flame2 = big_storm.addOrReplaceChild("big_flame2",
				CubeListBuilder.create().texOffs(19, 1).addBox(8.0F, -6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 17).addBox(7.0F, -16.0F, 0.0F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -2.618F, 0.0F));
		PartDefinition big_flame3 = big_storm.addOrReplaceChild("big_flame3",
				CubeListBuilder.create().texOffs(19, 1).addBox(8.0F, -6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 17).addBox(7.0F, -16.0F, 0.0F, 3.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.5236F, 0.0F));
		PartDefinition medium_storm = partdefinition.addOrReplaceChild("medium_storm", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition medium_flame1 = medium_storm.addOrReplaceChild("medium_flame1",
				CubeListBuilder.create().texOffs(19, 1).addBox(9.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 17).mirror().addBox(8.0F, -7.0F, 0.0F, 3.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition medium_flame2 = medium_storm.addOrReplaceChild("medium_flame2",
				CubeListBuilder.create().texOffs(19, 1).addBox(9.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 17).mirror().addBox(8.0F, -7.0F, 0.0F, 3.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 2.618F, 0.0F));
		PartDefinition medium_flame3 = medium_storm.addOrReplaceChild("medium_flame3",
				CubeListBuilder.create().texOffs(19, 1).addBox(9.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 17).mirror().addBox(8.0F, -8.0F, 0.0F, 3.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.5236F, 0.0F));
		PartDefinition small_storm = partdefinition.addOrReplaceChild("small_storm", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition small_flame1 = small_storm.addOrReplaceChild("small_flame1",
				CubeListBuilder.create().texOffs(19, 1).addBox(3.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 17).mirror().addBox(2.0F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition small_flame2 = small_storm.addOrReplaceChild("small_flame2",
				CubeListBuilder.create().texOffs(19, 1).addBox(3.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 17).mirror().addBox(2.0F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, -2.618F, 0.0F));
		PartDefinition small_flame3 = small_storm.addOrReplaceChild("small_flame3",
				CubeListBuilder.create().texOffs(19, 1).addBox(3.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 17).mirror().addBox(2.0F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -0.5236F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		big_storm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		medium_storm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		small_storm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.small_storm.yRot = ageInTicks / -8.f;
		this.medium_storm.yRot = 6F * Mth.cos(ageInTicks / 12);
		this.big_storm.yRot = ageInTicks / 8.f;
	}
}
