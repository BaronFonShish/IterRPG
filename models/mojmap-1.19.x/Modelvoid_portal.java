// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelvoid_portal<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "void_portal"), "main");
	private final ModelPart base;
	private final ModelPart rift;
	private final ModelPart vortex;

	public Modelvoid_portal(ModelPart root) {
		this.base = root.getChild("base");
		this.rift = base.getChild("rift");
		this.vortex = base.getChild("vortex");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create(),
				PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition vortex = base.addOrReplaceChild("vortex", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F,
				-7.0F, 0.0F, 14.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rift = base.addOrReplaceChild("rift", CubeListBuilder.create().texOffs(0, 14).addBox(-5.0F,
				-5.0F, 0.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -0.1F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
				this.base.yRot = netHeadYaw / (180F / (float) Math.PI);
				this.base.xRot = headPitch / (180F / (float) Math.PI);
				this.vortex.zRot = ageInTicks / 8.f;
				this.rift.zRot = ageInTicks / -8.f;
	}
}