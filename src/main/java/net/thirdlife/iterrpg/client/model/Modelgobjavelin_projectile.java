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

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelgobjavelin_projectile<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelgobjavelin_projectile"), "main");
	public final ModelPart javelin;

	public Modelgobjavelin_projectile(ModelPart root) {
		this.javelin = root.getChild("javelin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition javelin = partdefinition.addOrReplaceChild("javelin",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 2.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(4, 7).addBox(-0.5F, 0.5F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(11, 4)
						.addBox(-0.5F, -1.5F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(-0.5F, -5.5F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 0)
						.addBox(-0.5F, -9.5F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(7, 10).addBox(-0.5F, 2.5F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 10)
						.addBox(-0.5F, 2.5F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.5F, 0.0F, 0.0F, -1.5708F, 3.1416F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		javelin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
