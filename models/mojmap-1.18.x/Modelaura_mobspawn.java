// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelaura_mobspawn<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "aura_mobspawn"), "main");
	private final ModelPart aura;

	public Modelaura_mobspawn(ModelPart root) {
		this.aura = root.getChild("aura");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition aura = partdefinition.addOrReplaceChild("aura", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-10.5F, 0.05F, -10.5F, 21.0F, 0.0F, 21.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.7F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		aura.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.aura.yRot = ageInTicks/10F;
	}
}