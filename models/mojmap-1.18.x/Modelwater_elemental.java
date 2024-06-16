// Made with Blockbench 4.5.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelwater_elemental<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "water_elemental"), "main");
	private final ModelPart head;
	private final ModelPart big_storm;
	private final ModelPart small_bottom_storm;
	private final ModelPart small_upper_storm;

	public Modelwater_elemental(ModelPart root) {
		this.head = root.getChild("head");
		this.big_storm = root.getChild("big_storm");
		this.small_bottom_storm = root.getChild("small_bottom_storm");
		this.small_upper_storm = root.getChild("small_upper_storm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(
				-5.0F, -2.5F, -5.0F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 0.0F));

		PartDefinition big_storm = partdefinition.addOrReplaceChild("big_storm",
				CubeListBuilder.create().texOffs(1, 16)
						.addBox(-9.0F, -1.5F, -7.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(1, 16)
						.addBox(6.0F, -1.5F, -7.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(1, 16)
						.addBox(-1.5F, -1.5F, 6.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.5F, 0.0F));

		PartDefinition small_bottom_storm = partdefinition.addOrReplaceChild("small_bottom_storm",
				CubeListBuilder.create().texOffs(20, 16)
						.addBox(-1.0F, 3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 16)
						.addBox(-3.0F, -4.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 16)
						.addBox(1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition small_upper_storm = partdefinition.addOrReplaceChild("small_upper_storm",
				CubeListBuilder.create().texOffs(20, 16)
						.addBox(-7.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 16)
						.addBox(5.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		big_storm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		small_bottom_storm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		small_upper_storm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.small_upper_storm.yRot = ageInTicks/10F;
		this.small_bottom_storm.yRot = ageInTicks/-10F;
		this.big_storm.yRot = Mth.sin(ageInTicks/12F)/4F;
	}
}