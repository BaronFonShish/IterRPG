// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgoblin_warrior<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "goblin_warrior"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart leftArm;
	private final ModelPart rightArm;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;

	public Modelgoblin_warrior(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.leftArm = root.getChild("leftArm");
		this.rightArm = root.getChild("rightArm");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(21, 23)
						.addBox(-2.5F, -3.5F, -1.5F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(2, 15)
						.addBox(-2.5F, -3.5F, -1.5F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 16.5F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-3.5F, -7.0F, -3.0F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(32, 18)
						.addBox(-7.5F, -5.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(23, 18)
						.addBox(3.5F, -5.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 13.0F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm",
				CubeListBuilder.create().texOffs(0, 34)
						.addBox(-1.5F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.1F)),
				PartPose.offset(4.0F, 14.0F, 0.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm",
				CubeListBuilder.create().texOffs(27, 0)
						.addBox(-0.6F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(23, 10)
						.addBox(-1.6F, -1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.1F)),
				PartPose.offset(-4.0F, 14.0F, 0.0F));

		PartDefinition sword = rightArm.addOrReplaceChild("sword",
				CubeListBuilder.create().texOffs(0, 54)
						.addBox(-0.5F, 2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 54)
						.addBox(-0.5F, 1.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 54)
						.addBox(-0.5F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 54)
						.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 54)
						.addBox(-0.5F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 54)
						.addBox(-0.5F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 54)
						.addBox(-0.5F, -3.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 62)
						.addBox(-0.5F, -4.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 62)
						.addBox(-0.5F, -5.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 62)
						.addBox(-0.5F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 62)
						.addBox(-0.5F, -7.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 62)
						.addBox(-0.5F, -8.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 62)
						.addBox(-0.5F, -9.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, -9.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, -8.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, -7.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, -6.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 54)
						.addBox(-0.5F, 2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 54)
						.addBox(-0.5F, 2.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 62)
						.addBox(-0.5F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 62)
						.addBox(-0.5F, 1.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, -2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, -4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-0.5F, -5.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 62)
						.addBox(-0.5F, 2.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 62)
						.addBox(-0.5F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 62)
						.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 62)
						.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 62)
						.addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 62)
						.addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 60)
						.addBox(-0.5F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 60)
						.addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 60)
						.addBox(-0.5F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 60)
						.addBox(-0.5F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 60)
						.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 60)
						.addBox(-0.5F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 62)
						.addBox(-0.5F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 58)
						.addBox(-0.5F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 58)
						.addBox(-0.5F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 58)
						.addBox(-0.5F, -3.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 58)
						.addBox(-0.5F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 58)
						.addBox(-0.5F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 58)
						.addBox(-0.5F, -4.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 58)
						.addBox(-0.5F, -5.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 58)
						.addBox(-0.5F, -7.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
						.addBox(-0.5F, -6.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
						.addBox(-0.5F, -5.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 58)
						.addBox(-0.5F, -8.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -4.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -6.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -7.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -5.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -6.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 60)
						.addBox(-0.5F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 58)
						.addBox(-0.5F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 58)
						.addBox(-0.5F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 4.0F, -1.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(18, 34)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.5F, 20.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(9, 34)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.5F, 20.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.65F) * 1.0F * limbSwingAmount;
		this.rightArm.xRot = Mth.cos(limbSwing * 0.65F + (float) Math.PI) * limbSwingAmount + -2F * Mth.sin(attackTime * Mth.PI);
		this.rightArm.yRot = 0.75F * Mth.sin(attackTime * Mth.PI * 1.5F);
		this.leftArm.xRot = Mth.cos(limbSwing * 0.65F) * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.65F) * -1.0F * limbSwingAmount;
		this.leftArm.zRot = (Mth.sin(ageInTicks/16)/-20) - 0.1F;
		this.rightArm.zRot = (Mth.sin(ageInTicks/16)/20) + 0.1F;
	}
}