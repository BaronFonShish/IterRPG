// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcarcass<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "carcass"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public Modelcarcass(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-6.0F, -11.0F, -6.0F, 12.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(45, 9)
						.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(35, 0)
						.addBox(-3.0F, -10.0F, -3.375F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 22)
						.addBox(-7.0F, -8.0F, -4.375F, 14.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(40, 35)
						.addBox(-5.0F, 2.0F, -3.375F, 10.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(38, 15)
						.addBox(-6.0F, 6.0F, -3.375F, 12.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 0.375F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(0, 42)
						.addBox(-5.0F, -2.5F, -2.5F, 5.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 67)
						.addBox(-6.0F, 6.5F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.1F)),
				PartPose.offset(-7.0F, -7.5F, 0.5F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(21, 42)
				.addBox(0.0F, -2.5F, -2.5F, 5.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(7.0F, -7.5F, 0.5F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create()
				.texOffs(63, 47).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.5F, 8.0F, 0.5F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(42, 47)
				.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.5F, 8.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_arm.xRot = Mth.cos(limbSwing * 0.666F + (float) Math.PI) * limbSwingAmount -1.6F * Mth.sin(attackTime * Mth.PI);
		this.right_arm.yRot = 0.6F * Mth.sin(attackTime * Mth.PI * 2F);
		this.left_arm.xRot = Mth.cos(limbSwing * 0.666F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 0.666F) * 1.0F * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 0.666F) * -1.0F * limbSwingAmount;
	}
}