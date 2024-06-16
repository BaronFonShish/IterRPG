// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgriever<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "griever"), "main");
	private final ModelPart body;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public Modelgriever(ModelPart root) {
		this.body = root.getChild("body");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-4.0F, -27.0F, -2.0F, 8.0F, 27.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(25, 0).mirror()
						.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.5F, 14.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(25, 0)
				.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.5F, 14.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.left_leg.xRot = Mth.cos(limbSwing * 0.8F) * -1.6F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 0.8F) * 1.6F * limbSwingAmount;
		this.body.xRot = Mth.cos(limbSwing * 0.6F + (float) Math.PI) * limbSwingAmount * 1.6F + Mth.cos(ageInTicks/10)/10;
    }
}