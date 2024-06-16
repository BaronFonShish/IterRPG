// Made with Blockbench 4.6.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelair_elemental<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "air_elemental"), "main");
	private final ModelPart mob;
	// mob
	public final ModelPart head;
	public final ModelPart storm1;
	public final ModelPart storm2;
	public final ModelPart storm3;
	public final ModelPart misc_storm;
	public final ModelPart lightning_big;
	public final ModelPart lightning_small;
	public final ModelPart large_cloud_particle1;
	public final ModelPart large_cloud_particle2;

	public Modelair_elemental(ModelPart root) {
		this.mob = root.getChild("mob");
		// mob
		this.head = mob.getChild("head");
		this.storm1 = mob.getChild("storm1");
		this.storm2 = mob.getChild("storm2");
		this.storm3 = mob.getChild("storm3");
		this.misc_storm = mob.getChild("misc_storm");
		this.lightning_big = mob.getChild("lightning_big");
		this.lightning_small = mob.getChild("lightning_small");
		// storm2
		this.large_cloud_particle1 = storm2.getChild("large_cloud_particle1");
		this.large_cloud_particle2 = storm2.getChild("large_cloud_particle2");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mob = partdefinition.addOrReplaceChild("mob", CubeListBuilder.create(),
				PartPose.offset(0.0F, 29.0F, 0.0F));

		PartDefinition head = mob.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F,
				-4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition storm1 = mob.addOrReplaceChild("storm1", CubeListBuilder.create(),
				PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition large_cloud_particle3 = storm1.addOrReplaceChild("large_cloud_particle3", CubeListBuilder
				.create().texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition small_cloud_particle2 = storm1.addOrReplaceChild("small_cloud_particle2", CubeListBuilder
				.create().texOffs(0, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.0F, -1.0F, 0.0F));

		PartDefinition small_cloud_particle3 = storm1.addOrReplaceChild("small_cloud_particle3", CubeListBuilder
				.create().texOffs(0, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-6.0F, -1.0F, 0.0F));

		PartDefinition storm2 = mob.addOrReplaceChild("storm2", CubeListBuilder.create(),
				PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition large_cloud_particle1 = storm2.addOrReplaceChild("large_cloud_particle1", CubeListBuilder
				.create().texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, -1.0F, 0.0F));

		PartDefinition large_cloud_particle2 = storm2.addOrReplaceChild("large_cloud_particle2", CubeListBuilder
				.create().texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, -1.0F, 0.0F));

		PartDefinition storm3 = mob.addOrReplaceChild("storm3", CubeListBuilder.create(),
				PartPose.offset(0.0F, -22.0F, 0.0F));

		PartDefinition large_cloud_particle4 = storm3.addOrReplaceChild("large_cloud_particle4", CubeListBuilder
				.create().texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition misc_storm = mob.addOrReplaceChild("misc_storm",
				CubeListBuilder.create().texOffs(0, 4)
						.addBox(5.0F, -1.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-7.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).mirror()
						.addBox(-1.0F, 4.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition lightning_big = mob.addOrReplaceChild("lightning_big", CubeListBuilder.create(),
				PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition big_lightning1 = lightning_big.addOrReplaceChild("big_lightning1",
				CubeListBuilder.create().texOffs(17, 20).mirror()
						.addBox(-3.0F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(4.0F, -2.0F, -1.0F));

		PartDefinition big_lightning2 = lightning_big.addOrReplaceChild("big_lightning2",
				CubeListBuilder.create().texOffs(17, 17).mirror()
						.addBox(-3.0F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-5.0F, 2.0F, -1.0F));

		PartDefinition lightning_small = mob.addOrReplaceChild("lightning_small", CubeListBuilder.create(),
				PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition small_lightning1 = lightning_small.addOrReplaceChild("small_lightning1",
				CubeListBuilder.create().texOffs(1, 26).mirror()
						.addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-8.5F, -2.0F, 1.0F));

		PartDefinition small_lightning2 = lightning_small.addOrReplaceChild("small_lightning2",
				CubeListBuilder.create().texOffs(1, 23).mirror()
						.addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(8.5F, 2.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);

		this.misc_storm.yRot = (ageInTicks / 6F);
		this.storm1.yRot = (ageInTicks / -5F);
		this.storm2.yRot = (ageInTicks / 4F);
		this.large_cloud_particle1.yRot = (ageInTicks / -4F);
		this.large_cloud_particle2.yRot = (ageInTicks / -4F);
		this.storm3.yRot = (ageInTicks / 4F);

		this.lightning_big.zRot = (ageInTicks / 6F);
		this.lightning_small.zRot = (ageInTicks / -6F);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		mob.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}