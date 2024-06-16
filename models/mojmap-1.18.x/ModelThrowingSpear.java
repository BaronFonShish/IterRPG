// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelThrowingSpear<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "throwingspear"), "main");
	private final ModelPart spear;

	public ModelThrowingSpear(ModelPart root) {
		this.spear = root.getChild("spear");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition spear = partdefinition.addOrReplaceChild("spear", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube = spear
				.addOrReplaceChild("cube",
						CubeListBuilder.create().texOffs(20, 20).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube2 = spear
				.addOrReplaceChild("cube2",
						CubeListBuilder.create().texOffs(20, 16).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 8.6F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube3 = spear
				.addOrReplaceChild("cube3",
						CubeListBuilder.create().texOffs(12, 20).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 7.2F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube4 = spear
				.addOrReplaceChild("cube4",
						CubeListBuilder.create().texOffs(6, 20).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 5.8F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube5 = spear
				.addOrReplaceChild("cube5",
						CubeListBuilder.create().texOffs(0, 20).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 4.4F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube6 = spear
				.addOrReplaceChild("cube6",
						CubeListBuilder.create().texOffs(16, 18).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube7 = spear
				.addOrReplaceChild("cube7",
						CubeListBuilder.create().texOffs(12, 16).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 1.6F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube8 = spear
				.addOrReplaceChild("cube8",
						CubeListBuilder.create().texOffs(6, 16).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube9 = spear
				.addOrReplaceChild("cube9",
						CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -1.2F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube10 = spear
				.addOrReplaceChild("cube10",
						CubeListBuilder.create().texOffs(8, 10).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -2.6F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube11 = spear
				.addOrReplaceChild("cube11",
						CubeListBuilder.create().texOffs(16, 10).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube12 = spear
				.addOrReplaceChild("cube12",
						CubeListBuilder.create().texOffs(24, 10).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -5.4F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube13 = spear
				.addOrReplaceChild("cube13",
						CubeListBuilder.create().texOffs(26, 20).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -8.2F, 0.0F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		spear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}