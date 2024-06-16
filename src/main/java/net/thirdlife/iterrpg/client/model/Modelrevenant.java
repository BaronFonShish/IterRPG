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

// Made with Blockbench 4.10.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelrevenant<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelrevenant"), "main");
	public final ModelPart head;
	public final ModelPart jaw;
	public final ModelPart torso;
	public final ModelPart arm_right;
	public final ModelPart arm_left;
	public final ModelPart leg_right;
	public final ModelPart leg_left;

	public Modelrevenant(ModelPart root) {
		this.head = root.getChild("head");
		this.torso = root.getChild("torso");
		this.arm_right = root.getChild("arm_right");
		this.arm_left = root.getChild("arm_left");
		this.leg_right = root.getChild("leg_right");
		this.leg_left = root.getChild("leg_left");

		this.jaw = head.getChild("jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -7.0F, -5.0F, 9.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(25, 6).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(32, 6).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, -2.5F, 0.5236F, 0.0F, 0.0F));
		PartDefinition torso = partdefinition.addOrReplaceChild("torso",
				CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(20, 19).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(24, 14)
						.addBox(-3.0F, -7.0F, -2.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(32, 26).addBox(-1.0F, -7.0F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
						.addBox(-1.0F, -15.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 11).addBox(-2.0F, -5.0F, 1.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition arm_right = partdefinition.addOrReplaceChild("arm_right",
				CubeListBuilder.create().texOffs(25, 0).addBox(-3.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(30, 33).addBox(-2.0F, 1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 26)
						.addBox(-3.0F, 4.5F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(12, 23).addBox(-5.0F, -3.5F, 0.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 1.5F, 0.0F));
		PartDefinition arm_left = partdefinition.addOrReplaceChild("arm_left",
				CubeListBuilder.create().texOffs(25, 0).mirror().addBox(0.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(30, 33).mirror().addBox(0.0F, 1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(20, 26).mirror().addBox(0.0F, 4.5F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(12, 23).mirror().addBox(1.0F, -3.5F, 0.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offset(4.0F, 1.5F, 0.0F));
		PartDefinition leg_right = partdefinition.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(0, 23).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 13.0F, 0.0F));
		PartDefinition leg_left = partdefinition.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, 13.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.jaw.xRot = (Mth.sin(ageInTicks / 12) / 20) + (30 * Mth.PI / 180);
		this.arm_right.xRot = Mth.cos(limbSwing * 0.666F + (float) Math.PI) * limbSwingAmount - 1.6F * Mth.sin(attackTime * Mth.PI);
		this.arm_right.yRot = 0.6F * Mth.sin(attackTime * Mth.PI * 2F);
		this.leg_left.xRot = Mth.cos(limbSwing * 0.666F) * -1.0F * limbSwingAmount;
		this.arm_left.xRot = Mth.cos(limbSwing * 0.666F) * limbSwingAmount;
		this.leg_right.xRot = Mth.cos(limbSwing * 0.666F) * 1.0F * limbSwingAmount;
		this.arm_right.zRot = (Mth.sin(ageInTicks / 16) / 20) + 0.1F;
		this.arm_left.zRot = (Mth.sin(ageInTicks / 16) / -20) - 0.1F;
	}
}
