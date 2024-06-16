// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeldemonspine<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "demonspine"), "main");
	private final ModelPart spike;

	public Modeldemonspine(ModelPart root) {
		this.spike = root.getChild("spike");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition spike = partdefinition.addOrReplaceChild("spike", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition spike_r1 = spike.addOrReplaceChild("spike_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -24.0F, 0.0F, 12.0F, 35.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition spike_r2 = spike.addOrReplaceChild("spike_r2",
				CubeListBuilder.create().texOffs(24, 0).addBox(-6.0F, -24.0F, 0.0F, 12.0F, 35.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		spike.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}