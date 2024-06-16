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

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelcaltrop<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelcaltrop"), "main");
	public final ModelPart caltrop;

	public Modelcaltrop(ModelPart root) {
		this.caltrop = root.getChild("caltrop");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition caltrop = partdefinition.addOrReplaceChild("caltrop", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition spike_r1 = caltrop.addOrReplaceChild("spike_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0529F, -0.2129F, -1.9546F));
		PartDefinition spike_r2 = caltrop.addOrReplaceChild("spike_r2", CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, -1.0F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.7053F, 1.0472F, -3.1416F));
		PartDefinition spike_r3 = caltrop.addOrReplaceChild("spike_r3", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -1.0F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0529F, -0.2129F, -1.187F));
		PartDefinition spike_r4 = caltrop.addOrReplaceChild("spike_r4", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -1.0F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.7053F, -1.0472F, 3.1416F));
		PartDefinition spike_r5 = caltrop.addOrReplaceChild("spike_r5", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -1.0F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, -1.5708F));
		PartDefinition spike_r6 = caltrop.addOrReplaceChild("spike_r6", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -1.0F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition spike_r7 = caltrop.addOrReplaceChild("spike_r7", CubeListBuilder.create().texOffs(10, 0).addBox(0.0F, -1.0F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));
		PartDefinition spike_r8 = caltrop.addOrReplaceChild("spike_r8", CubeListBuilder.create().texOffs(10, 2).addBox(0.0F, -1.0F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		caltrop.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
