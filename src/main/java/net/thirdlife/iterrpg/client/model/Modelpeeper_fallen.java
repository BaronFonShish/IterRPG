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

// Made with Blockbench 4.6.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelpeeper_fallen<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelpeeper_fallen"), "main");
	public final ModelPart mob;
	// mob
	public final ModelPart body;
	public final ModelPart leg_right;
	public final ModelPart leg_left;

	public Modelpeeper_fallen(ModelPart root) {
		this.mob = root.getChild("mob");
		// mob
		this.body = mob.getChild("body");
		this.leg_left = mob.getChild("leg_left");
		this.leg_right = mob.getChild("leg_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition mob = partdefinition.addOrReplaceChild("mob", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 17.0F, 4.0F, 1.5708F, 0.0F, -1.5708F));
		PartDefinition body = mob.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -15.0F, -7.0F, 14.0F, 15.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));
		PartDefinition leg_right = mob.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(0, 29).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 3.0F, 0.0F));
		PartDefinition leg_left = mob.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 3.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg_left.xRot = Mth.cos(ageInTicks / 8) / 8F;
		this.leg_right.xRot = Mth.cos(ageInTicks / 8) / -8F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mob.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
