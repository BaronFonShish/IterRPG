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
public class Modeldemon_soul<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modeldemon_soul"), "main");
	public final ModelPart head;
	public final ModelPart jaw;

	public Modeldemon_soul(ModelPart root) {
		this.head = root.getChild("head");
		this.jaw = root.getChild("jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -3.0F, 10.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 15).addBox(-3.0F, 4.0F, -3.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 24)
						.addBox(5.0F, -1.0F, -1.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(28, 0).addBox(7.0F, -6.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 28)
						.addBox(-10.0F, -6.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 22).addBox(-10.0F, -1.0F, -1.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 14.0F, -1.0F));
		PartDefinition jaw = partdefinition.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition jaw_r1 = jaw.addOrReplaceChild("jaw_r1", CubeListBuilder.create().texOffs(16, 18).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.jaw.xRot = (15 * Mth.PI / 180) * Mth.sin(ageInTicks / 2);
	}
}
