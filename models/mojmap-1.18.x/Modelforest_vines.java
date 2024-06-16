// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelforest_vines<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "forest_vines"), "main");
	private final ModelPart the;

	public Modelforest_vines(ModelPart root) {
		this.the = root.getChild("the");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition the = partdefinition.addOrReplaceChild("the", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition vine_r1 = the.addOrReplaceChild("vine_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -10.5F, 0.0F, 16.0F, 21.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition vine_r2 = the.addOrReplaceChild("vine_r2",
				CubeListBuilder.create().texOffs(0, 21).addBox(-8.0F, -10.5F, 0.0F, 16.0F, 21.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		the.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}