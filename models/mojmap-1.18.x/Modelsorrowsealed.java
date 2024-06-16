// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsorrowsealed<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "sorrowsealed"), "main");
	private final ModelPart head;
	private final ModelPart chain1;
	private final ModelPart chain2;
	private final ModelPart chain3;
	private final ModelPart chain4;

	public Modelsorrowsealed(ModelPart root) {
		this.head = root.getChild("head");
		this.chain1 = root.getChild("chain1");
		this.chain2 = root.getChild("chain2");
		this.chain3 = root.getChild("chain3");
		this.chain4 = root.getChild("chain4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-32.0F, -64.0F, -32.0F, 64.0F, 64.0F, 64.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition chain1 = partdefinition.addOrReplaceChild("chain1", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition chain_r1 = chain1
				.addOrReplaceChild("chain_r1",
						CubeListBuilder.create().texOffs(0, 129).addBox(-31.6F, -55.0F, -34.0F, 68.0F, 8.0F, 68.0F,
								new CubeDeformation(1.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition chain2 = partdefinition.addOrReplaceChild("chain2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition chain_r2 = chain2
				.addOrReplaceChild("chain_r2",
						CubeListBuilder.create().texOffs(0, 129).addBox(-36.6F, -14.0F, -34.0F, 68.0F, 8.0F, 68.0F,
								new CubeDeformation(1.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition chain3 = partdefinition.addOrReplaceChild("chain3", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition chain_r3 = chain3.addOrReplaceChild("chain_r3",
				CubeListBuilder.create().texOffs(0, 129).addBox(-34.6F, -17.0F, -66.0F, 68.0F, 8.0F, 68.0F,
						new CubeDeformation(1.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.1309F, 0.0F));

		PartDefinition chain4 = partdefinition.addOrReplaceChild("chain4", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition chain_r4 = chain4.addOrReplaceChild("chain_r4",
				CubeListBuilder.create().texOffs(0, 129).addBox(-37.6F, 11.0F, -66.0F, 68.0F, 8.0F, 68.0F,
						new CubeDeformation(1.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.2182F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chain1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chain2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chain3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chain4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}