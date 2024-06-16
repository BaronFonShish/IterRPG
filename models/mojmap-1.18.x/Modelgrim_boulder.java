// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgrim_boulder<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "grim_boulder"), "main");
	private final ModelPart body;

	public Modelgrim_boulder(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(96, 0)
				.addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition chains_r1 = body.addOrReplaceChild("chains_r1",
				CubeListBuilder.create().texOffs(10, 81).addBox(-8.5F, -4.0F, -8.5F, 17.0F, 8.0F, 17.0F,
						new CubeDeformation(0.12F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0436F, -1.5708F));

		PartDefinition chains_r2 = body.addOrReplaceChild("chains_r2",
				CubeListBuilder.create().texOffs(0, 81).addBox(-8.5F, -4.0F, -8.5F, 17.0F, 8.0F, 17.0F,
						new CubeDeformation(0.11F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5272F));

		PartDefinition chains_r3 = body
				.addOrReplaceChild("chains_r3",
						CubeListBuilder.create().texOffs(8, 81).addBox(-8.5F, -4.0F, -8.5F, 17.0F, 8.0F, 17.0F,
								new CubeDeformation(0.1F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
				this.body.xRot = ageInTicks / 10.f;
				this.body.yRot = ageInTicks / 10.f;
				this.body.zRot = ageInTicks / 10.f;

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}