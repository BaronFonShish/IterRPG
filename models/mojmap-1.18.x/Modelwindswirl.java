// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelwindswirl<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "windswirl"), "main");
	private final ModelPart top;
	private final ModelPart middle;
	private final ModelPart bottom;

	public Modelwindswirl(ModelPart root) {
		this.top = root.getChild("top");
		this.middle = root.getChild("middle");
		this.bottom = root.getChild("bottom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition top = partdefinition.addOrReplaceChild("top", CubeListBuilder.create().texOffs(0, 0).addBox(
				-9.5F, -3.5F, -9.5F, 19.0F, 9.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, 0.0F));

		PartDefinition middle = partdefinition.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(0, 28)
				.addBox(-6.5F, -2.5F, -6.5F, 13.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 14.5F, 0.0F));

		PartDefinition bottom = partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(39, 28)
				.addBox(-3.5F, -2.0F, -3.5F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 21.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		top.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		middle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
				this.top.yRot = (ageInTicks/6);
				this.middle.yRot = (ageInTicks/5);
				this.bottom.yRot = (ageInTicks/4);
	}
}