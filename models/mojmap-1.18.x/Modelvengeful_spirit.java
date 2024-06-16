// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelvengeful_spirit<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "vengeful_spirit"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightArm;
	private final ModelPart leftArm;

	public Modelvengeful_spirit(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 23)
						.addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, -10.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(41, 0)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(36, 39)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 19.0F, 5.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.5672F, 0.0F, 0.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm",
				CubeListBuilder.create().texOffs(59, 60)
						.addBox(-3.0F, -2.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(58, 25)
						.addBox(-3.0F, -2.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-5.0F, 5.0F, -1.0F, -1.3526F, 0.0F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm",
				CubeListBuilder.create().texOffs(0, 44)
						.addBox(-1.0F, -2.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(17, 44)
						.addBox(-1.0F, -2.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(5.0F, 5.0F, -1.0F, -1.309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightArm.xRot = Mth.cos(limbSwing * 0.3F + (float) Math.PI) * limbSwingAmount * -0.2F - ( float)Math.PI/2;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.3F + (float) Math.PI) * limbSwingAmount * 0.2F - (float) Math.PI/2;
		this.body.xRot = Mth.cos(ageInTicks/4F)* 0.15F;
	}
}