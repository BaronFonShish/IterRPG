// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelScab<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "scab"), "main");
	private final ModelPart mob;
	private final ModelPart tail;
	private final ModelPart stinger;
	private final ModelPart front_right_leg;
	private final ModelPart front_left_leg;
	private final ModelPart hind_right_leg;
	private final ModelPart hind_left_leg;
	private final ModelPart left_jaw;
	private final ModelPart right_jaw;

	public ModelScab(ModelPart root) {
		this.mob = root.getChild("mob");
		this.tail = mob.getChild("tail");
		this.stinger = tail.getChild("stinger");
		this.front_right_leg = mob.getChild("front_right_leg");
		this.front_left_leg = mob.getChild("front_left_leg");
		this.hind_right_leg = mob.getChild("hind_right_leg");
		this.hind_left_leg = mob.getChild("hind_left_leg");
		this.left_jaw = mob.getChild("left_jaw");
		this.right_jaw = mob.getChild("right_jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mob = partdefinition.addOrReplaceChild("mob",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -6.0F, -6.0F, 8.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(24, 18)
						.addBox(-5.0F, -8.0F, 2.0F, 10.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(5, -3)
						.mirror().addBox(0.0F, -9.0F, -7.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, -2).addBox(0.0F, -9.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition thorn_back_r1 = mob.addOrReplaceChild("thorn_back_r1",
				CubeListBuilder.create().texOffs(0, -2).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -5.0F, 8.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition thorn_2_left_r1 = mob.addOrReplaceChild("thorn_2_left_r1",
				CubeListBuilder.create().texOffs(5, -3).mirror()
						.addBox(0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, -8.0F, 5.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition thorn_2_right_r1 = mob.addOrReplaceChild("thorn_2_right_r1",
				CubeListBuilder.create().texOffs(5, -3).addBox(0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -8.0F, 5.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition thorn_left_r1 = mob.addOrReplaceChild("thorn_left_r1",
				CubeListBuilder.create().texOffs(0, -2).mirror()
						.addBox(0.0F, -3.0F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.0F, -6.0F, -2.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition thorn_right_r1 = mob.addOrReplaceChild("thorn_right_r1",
				CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -3.0F, -1.0F, 0.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -6.0F, -2.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition tail = mob.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, -16.0F,
				-6.0F, 0.0F, 17.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 8.0F));

		PartDefinition stinger = tail.addOrReplaceChild("stinger", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F,
				-2.0F, -11.0F, 0.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, -6.0F));

		PartDefinition front_right_leg = mob.addOrReplaceChild("front_right_leg", CubeListBuilder.create(),
				PartPose.offset(-4.0F, -2.0F, -3.0F));

		PartDefinition leg_r1 = front_right_leg
				.addOrReplaceChild("leg_r1",
						CubeListBuilder.create().texOffs(0, 45).addBox(0.0F, -4.0F, -11.0F, 0.0F, 8.0F, 11.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition front_left_leg = mob.addOrReplaceChild("front_left_leg", CubeListBuilder.create(),
				PartPose.offset(4.0F, -2.0F, -4.0F));

		PartDefinition leg_r2 = front_left_leg.addOrReplaceChild("leg_r2",
				CubeListBuilder.create().texOffs(0, 45).mirror()
						.addBox(0.0F, -4.0F, -11.0F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition hind_right_leg = mob.addOrReplaceChild("hind_right_leg", CubeListBuilder.create(),
				PartPose.offset(-4.0F, -1.0F, 6.0F));

		PartDefinition claw_r1 = hind_right_leg
				.addOrReplaceChild("claw_r1",
						CubeListBuilder.create().texOffs(0, 50).addBox(-6.0F, -2.0F, 0.0F, 6.0F, 5.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition hind_left_leg = mob.addOrReplaceChild("hind_left_leg", CubeListBuilder.create(),
				PartPose.offset(4.0F, -1.0F, 6.0F));

		PartDefinition claw_r2 = hind_left_leg.addOrReplaceChild("claw_r2",
				CubeListBuilder.create().texOffs(0, 50).mirror()
						.addBox(0.0F, -2.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition left_jaw = mob.addOrReplaceChild("left_jaw", CubeListBuilder.create(),
				PartPose.offset(2.0F, -1.0F, -5.0F));

		PartDefinition jaw_r1 = left_jaw.addOrReplaceChild("jaw_r1",
				CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -0.1F, -6.0F, 4.0F, 0.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, -0.2618F, 0.5236F));

		PartDefinition right_jaw = mob.addOrReplaceChild("right_jaw", CubeListBuilder.create(),
				PartPose.offset(-2.0F, -1.0F, -5.0F));

		PartDefinition jaw_r2 = right_jaw.addOrReplaceChild("jaw_r2",
				CubeListBuilder.create().texOffs(48, 0).mirror()
						.addBox(-2.0F, -0.1F, -6.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.2618F, -0.5236F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
				
			this.tail.xRot = (Mth.sin(ageInTicks / 16 + Mth.PI/4) / 18) + 0.8F * Mth.sin(attackTime * Mth.PI + 0.05F);
			this.stinger.xRot = (Mth.sin(ageInTicks / 16) / 18) + 1F * -Mth.sin(attackTime * Mth.PI);
			
			this.right_jaw.yRot = -((Mth.sin(ageInTicks / 7) / 10)*(Mth.sin(ageInTicks / 7) / 10)) * 2.5F;
			this.left_jaw.yRot = ((Mth.sin(ageInTicks / 7) / 10)*(Mth.sin(ageInTicks / 7) / 10)) * 2.5F;
			
			this.front_right_leg.zRot = Mth.sin(limbSwing * 1F) * 0.5F * limbSwingAmount;
			this.front_right_leg.yRot = Mth.cos(limbSwing * 1F) * 0.75F * limbSwingAmount;
			
			this.front_left_leg.zRot = Mth.sin(limbSwing * 1F) * 0.5F * limbSwingAmount;
			this.front_left_leg.yRot = Mth.cos(limbSwing * 1F) * 0.75F * limbSwingAmount;
			
			this.hind_right_leg.zRot = Mth.sin(limbSwing * 1F) * -0.5F * limbSwingAmount;
			this.hind_right_leg.yRot = Mth.cos(limbSwing * 1F) * -0.5F * limbSwingAmount;
			
			this.hind_left_leg.zRot = Mth.sin(limbSwing * 1F) * -0.5F * limbSwingAmount;
			this.hind_left_leg.yRot = Mth.cos(limbSwing * 1F) * -0.5F * limbSwingAmount;
			
			this.mob.zRot = Mth.sin(limbSwing * 1F) * 0.1F * limbSwingAmount;

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		mob.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}