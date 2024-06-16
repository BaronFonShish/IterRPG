// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelaura_boulder<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "aura_boulder"), "main");
	private final ModelPart base;
	private final ModelPart addition;

	public Modelaura_boulder(ModelPart root) {
		this.base = root.getChild("base");
		this.addition = root.getChild("addition");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-15.0F, -0.15F, -15.0F, 30.0F, 0.0F, 30.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.9F, 0.0F));

		PartDefinition addition = partdefinition.addOrReplaceChild("addition", CubeListBuilder.create().texOffs(0, 30)
				.addBox(-10.0F, -0.5F, -10.0F, 20.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		addition.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.base.yRot = ageInTicks / 10.f;
		this.addition.yRot = ageInTicks / -10.f;
	}
}