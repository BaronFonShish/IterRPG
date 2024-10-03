// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgreat_bubble<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "great_bubble"), "main");
	private final ModelPart bubble;

	public Modelgreat_bubble(ModelPart root) {
		this.bubble = root.getChild("bubble");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bubble = partdefinition.addOrReplaceChild("bubble", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-7.5F, -7.5F, -7.5F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bubble.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bubble.yRot = ageInTicks / 15.f;
		this.bubble.zRot = ageInTicks / 15.f;
		this.bubble.xRot = ageInTicks / 15.f;
	}
}