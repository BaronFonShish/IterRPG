// Made with Blockbench 4.6.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelmarrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "marrow"), "main");
	private final ModelPart arrow;

	public Modelmarrow(ModelPart root) {
		this.arrow = root.getChild("arrow");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition arrow = partdefinition.addOrReplaceChild("arrow",
				CubeListBuilder.create().texOffs(10, 0)
						.addBox(0.0F, -13.0F, -2.5F, 0.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition plane_r1 = arrow.addOrReplaceChild("plane_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -7.0F, -2.5F, 0.0F, 14.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		arrow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}