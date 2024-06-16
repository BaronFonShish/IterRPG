// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgoblin<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "goblin"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public Modelgoblin(ModelPart root) {
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
						.addBox(-3.5F, -6.0F, -3.0F, 7.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(21, 0)
						.addBox(3.0F, -4.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(21, 3)
						.addBox(-6.0F, -4.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 15.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(1, 14).addBox(
				-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 17.5F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create()
				.texOffs(19, 13).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, 16.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(17, 22)
				.addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 16.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create()
				.texOffs(26, 20).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 20.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 23)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 20.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
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
		this.right_leg.xRot = Mth.cos(limbSwing * 0.65F) * 1.0F * limbSwingAmount;
		this.right_arm.xRot = Mth.cos(limbSwing * 0.65F + (float) Math.PI) * limbSwingAmount + -2F * Mth.sin(attackTime * Mth.PI);
		this.right_arm.yRot = 0.75F * Mth.sin(attackTime * Mth.PI * 1.5F);
		this.left_arm.xRot = Mth.cos(limbSwing * 0.65F) * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 0.65F) * -1.0F * limbSwingAmount;
		this.left_arm.zRot = (Mth.sin(ageInTicks/16)/-20) - 0.1F;
		this.right_arm.zRot = (Mth.sin(ageInTicks/16)/20) + 0.1F;
	}
}