package net.thirdlife.iterrpg.client.model;

import net.minecraft.world.entity.Mob;
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

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelfleshmite<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("iter_rpg", "modelfleshmite"), "main");
	public final ModelPart Mob;
	public final ModelPart front;
	public final ModelPart upper_jaw;
	public final ModelPart bottom_jaw;
	public final ModelPart middle;
	public final ModelPart end;

	public Modelfleshmite(ModelPart root) {
		this.Mob = root.getChild("Mob");
		this.front = Mob.getChild("front");
		this.upper_jaw = front.getChild("upper_jaw");
		this.bottom_jaw = front.getChild("bottom_jaw");
		this.middle = front.getChild("middle");
		this.end = middle.getChild("end");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Mob = partdefinition.addOrReplaceChild("Mob", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition front = Mob.addOrReplaceChild("front", CubeListBuilder.create().texOffs(16, 12).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -2.0F));
		PartDefinition upper_jaw = front.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -2.0F));
		PartDefinition bottom_jaw = front.addOrReplaceChild("bottom_jaw", CubeListBuilder.create().texOffs(14, 20).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -2.0F));
		PartDefinition middle = front.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));
		PartDefinition end = middle.addOrReplaceChild("end",
				CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 0).addBox(-2.0F, 0.0F, 2.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 5.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Mob.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Mob.yRot = Mth.sin(ageInTicks * 0.75F) * (2F * Mth.PI / 180) * (limbSwingAmount * 2F + 1);
		this.upper_jaw.xRot = Mth.sin(ageInTicks * 1F) * (5F * Mth.PI / 180);
		this.bottom_jaw.xRot = Mth.sin(ageInTicks * 1F) * (-5F * Mth.PI / 180);
		this.middle.yRot = Mth.cos(ageInTicks * 0.75F) * (2F * Mth.PI / 180) * (limbSwingAmount * 2F + 1);
		this.end.yRot = Mth.sin(ageInTicks * 0.75F) * (2F * Mth.PI / 180) * (limbSwingAmount * 2F + 1);
	}
}
