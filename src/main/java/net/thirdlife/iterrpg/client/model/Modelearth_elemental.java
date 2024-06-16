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

// Made with Blockbench 4.5.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelearth_elemental<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelearth_elemental"), "main");
	public final ModelPart head;
	public final ModelPart small_storm;
	public final ModelPart medium_storm;
	public final ModelPart big_storm;

	public Modelearth_elemental(ModelPart root) {
		this.head = root.getChild("head");
		this.small_storm = root.getChild("small_storm");
		this.medium_storm = root.getChild("medium_storm");
		this.big_storm = root.getChild("big_storm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition branch_left_r1 = head.addOrReplaceChild("branch_left_r1", CubeListBuilder.create().texOffs(14, 16).addBox(0.0F, -3.5F, 0.0F, 7.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, -2.5F, 0.0F, 0.0F, -0.48F, 0.0F));
		PartDefinition branch_right_r1 = head.addOrReplaceChild("branch_right_r1", CubeListBuilder.create().texOffs(14, 16).mirror().addBox(-7.0F, -3.5F, 0.0F, 7.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.0F, -2.5F, 0.0F, 0.0F, 0.48F, 0.0F));
		PartDefinition small_storm = partdefinition.addOrReplaceChild("small_storm", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition small_particle1 = small_storm.addOrReplaceChild("small_particle1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 6.0F, 0.0F));
		PartDefinition small_particle2 = small_storm.addOrReplaceChild("small_particle2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 6.0F, 0.0F));
		PartDefinition small_particle3 = small_storm.addOrReplaceChild("small_particle3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -6.0F, 0.0F));
		PartDefinition small_particle4 = small_storm.addOrReplaceChild("small_particle4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -6.0F, 0.0F));
		PartDefinition medium_storm = partdefinition.addOrReplaceChild("medium_storm", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition medium_particle1 = medium_storm.addOrReplaceChild("medium_particle1", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, 0.0F, 0.0F));
		PartDefinition medium_particle2 = medium_storm.addOrReplaceChild("medium_particle2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.5F, 0.0F, 0.0F));
		PartDefinition medium_particle3 = medium_storm.addOrReplaceChild("medium_particle3", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.5F, 0.0F));
		PartDefinition medium_particle4 = medium_storm.addOrReplaceChild("medium_particle4", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition big_storm = partdefinition.addOrReplaceChild("big_storm", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition big_particle1 = big_storm.addOrReplaceChild("big_particle1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(11.5F, -3.0F, 0.0F));
		PartDefinition big_particle2 = big_storm.addOrReplaceChild("big_particle2", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -11.5F));
		PartDefinition big_particle3 = big_storm.addOrReplaceChild("big_particle3", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.5F, 3.0F, 0.0F));
		PartDefinition big_particle4 = big_storm.addOrReplaceChild("big_particle4", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 11.5F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		small_storm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		medium_storm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		big_storm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.small_storm.zRot = ageInTicks / 10F;
		this.medium_storm.xRot = ageInTicks / 10F;
		this.medium_storm.zRot = ageInTicks / -10F;
		this.big_storm.yRot = ageInTicks / 10F;
	}
}
