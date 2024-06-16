// Made with Blockbench 4.5.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsea_arrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "sea_arrow"), "main");
	private final ModelPart arrow;

	public Modelsea_arrow(ModelPart root) {
		this.arrow = root.getChild("arrow");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition arrow = partdefinition.addOrReplaceChild("arrow",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-1.5F, -2.25F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(14, 0)
						.addBox(-3.5F, -4.0F, 0.0F, 7.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 5.25F, 0.0F));

		PartDefinition plane_r1 = arrow
				.addOrReplaceChild("plane_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -4.0F, 0.0F, 7.0F, 16.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		arrow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.arrow.yRot = ageInTicks / 20.f;
	}
}