// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelfrostspike<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "frostspike"), "main");
	private final ModelPart projectile;

	public Modelfrostspike(ModelPart root) {
		this.projectile = root.getChild("projectile");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition projectile = partdefinition.addOrReplaceChild("projectile",
				CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 7.0F, -1.5F, 3.0F, 4.0F, 3.0F,
						new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(0.0F, -5.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition blade_r1 = projectile
				.addOrReplaceChild("blade_r1",
						CubeListBuilder.create().texOffs(0, -6).addBox(0.0F, -8.0F, -3.0F, 0.0F, 16.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

		PartDefinition blade_r2 = projectile
				.addOrReplaceChild("blade_r2",
						CubeListBuilder.create().texOffs(0, -6).addBox(0.0F, -8.0F, -3.0F, 0.0F, 16.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		projectile.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}