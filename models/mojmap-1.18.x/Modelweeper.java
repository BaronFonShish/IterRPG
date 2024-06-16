// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelweeper<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "weeper"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart arm_right;
	private final ModelPart arm_left;
	private final ModelPart leg_right;
	private final ModelPart leg_left;

	public Modelweeper(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.arm_right = root.getChild("arm_right");
		this.arm_left = root.getChild("arm_left");
		this.leg_right = root.getChild("leg_right");
		this.leg_left = root.getChild("leg_left");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-8.0F, -14.0F, -5.0F, 16.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 24).addBox(
				-5.0F, -4.0F, -3.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

		PartDefinition arm_right = partdefinition.addOrReplaceChild("arm_right", CubeListBuilder.create()
				.texOffs(28, 36).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 11.0F, 0.0F));

		PartDefinition arm_left = partdefinition.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(32, 24)
				.addBox(0.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 11.0F, 0.0F));

		PartDefinition leg_right = partdefinition.addOrReplaceChild("leg_right", CubeListBuilder.create()
				.texOffs(16, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, 17.0F, 0.0F));

		PartDefinition leg_left = partdefinition.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(0, 38)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 17.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leg_right.xRot = Mth.cos(limbSwing * 0.75F) * 1.0F * limbSwingAmount;
		this.arm_right.xRot = Mth.cos(limbSwing * 0.75F + (float) Math.PI) * limbSwingAmount + -2F * Mth.sin(attackTime * Mth.PI);
		this.arm_right.yRot = 0.75F * Mth.sin(attackTime * Mth.PI * 1.5F);
		this.leg_left.xRot = Mth.cos(limbSwing * 0.75F) * -1.0F * limbSwingAmount;
		this.arm_left.xRot = Mth.cos(limbSwing * 0.75F) * limbSwingAmount;
	}
}