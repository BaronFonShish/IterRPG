// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelblob<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "blob"), "main");
	private final ModelPart bubble;

	public Modelblob(ModelPart root) {
		this.bubble = root.getChild("bubble");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bubble = partdefinition.addOrReplaceChild("bubble", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 15).mirror()
				.addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(2.0F)).mirror(false),
				PartPose.offset(0.0F, 18.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bubble.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
			this.bubble.xRot = Mth.sin(ageInTicks/8)/16;
			this.bubble.zRot = Mth.cos(ageInTicks/8)/16;
			this.bubble.yRot = Mth.sin(ageInTicks/10)/12;
	}
}