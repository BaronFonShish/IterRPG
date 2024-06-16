// Made with Blockbench 4.6.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelchain_handle<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "chain_handle"), "main");
	private final ModelPart block;

	public Modelchain_handle(ModelPart root) {
		this.block = root.getChild("block");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition block = partdefinition.addOrReplaceChild("block",
				CubeListBuilder.create().texOffs(0, 10)
						.addBox(-2.0F, -2.0F, -4.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(14, 10)
						.addBox(-2.0F, -2.0F, 1.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		block.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}