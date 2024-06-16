// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeltiny_scallop<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "tiny_scallop"), "main");
	private final ModelPart lower_shell;
	private final ModelPart upper_shell;

	public Modeltiny_scallop(ModelPart root) {
		this.lower_shell = root.getChild("lower_shell");
		this.upper_shell = root.getChild("upper_shell");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition lower_shell = partdefinition.addOrReplaceChild("lower_shell",
				CubeListBuilder.create().texOffs(0, 10)
						.addBox(-4.0F, -0.5F, -6.5F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-2.0F, -1.5F, 1.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.5F, 2.5F));

		PartDefinition upper_shell = partdefinition.addOrReplaceChild("upper_shell", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		lower_shell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		upper_shell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {;
		this.upper_shell.xRot = 0 - Mth.abs(Mth.cos(limbSwing * Mth.PI/2F) * limbSwingAmount * 1.5F);
	}
}