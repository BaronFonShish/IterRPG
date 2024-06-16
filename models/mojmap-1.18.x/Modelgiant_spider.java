// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgiant_spider<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "giant_spider"), "main");

	private final ModelPart spider;
	// spider
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart leg_right1;
	public final ModelPart leg_right2;
	public final ModelPart leg_right3;
	public final ModelPart leg_right4;
	public final ModelPart leg_left1;
	public final ModelPart leg_left2;
	public final ModelPart leg_left3;
	public final ModelPart leg_left4;
	// body
	public final ModelPart brushko;
	// head
	public final ModelPart heli_left;
	public final ModelPart heli_right;

	public Modelgiant_spider(ModelPart root) {
		this.spider = root.getChild("spider");
		// spider
		this.body = spider.getChild("body");
		this.head = spider.getChild("head");
		this.leg_right1 = spider.getChild("leg_right1");
		this.leg_right2 = spider.getChild("leg_right2");
		this.leg_right3 = spider.getChild("leg_right3");
		this.leg_right4 = spider.getChild("leg_right4");
		this.leg_left1 = spider.getChild("leg_left1");
		this.leg_left2 = spider.getChild("leg_left2");
		this.leg_left3 = spider.getChild("leg_left3");
		this.leg_left4 = spider.getChild("leg_left4");
		// body
		this.brushko = body.getChild("brushko");
		// head
		this.heli_left = head.getChild("heli_left");
		this.heli_right = head.getChild("heli_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition spider = partdefinition.addOrReplaceChild("spider", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = spider.addOrReplaceChild("head", CubeListBuilder.create().texOffs(46, 0).addBox(-3.0F,
				-3.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, -4.0F));

		PartDefinition heli_left = head.addOrReplaceChild("heli_left",
				CubeListBuilder.create().texOffs(30, 32).mirror()
						.addBox(-1.45F, -2.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.2F, 2.2F, -5.0F, 0.2182F, -0.3491F, 0.3927F));

		PartDefinition heli_right = head.addOrReplaceChild("heli_right",
				CubeListBuilder.create().texOffs(30, 32).addBox(-1.55F, -2.0F, -2.0F, 3.0F, 4.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.2F, 2.2F, -5.0F, 0.2182F, 0.3491F, -0.3927F));

		PartDefinition body = spider.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-5.0F,
				-4.5F, -4.5F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, -12.0F, 0.0F));

		PartDefinition brushko = body.addOrReplaceChild("brushko", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.0F, 4.0F));

		PartDefinition body3_r1 = brushko
				.addOrReplaceChild("body3_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -11.0F, -3.0F, 14.0F, 14.0F, 18.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.5F, 1.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition leg_left1 = spider.addOrReplaceChild("leg_left1",
				CubeListBuilder.create().texOffs(64, 24).addBox(-0.75F, -1.25F, -1.3F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -11.0F, -3.7F, -0.1745F, 0.5411F, -0.3491F));

		PartDefinition leg_left1_3 = leg_left1.addOrReplaceChild("leg_left1_3",
				CubeListBuilder.create().texOffs(64, 65)
						.addBox(6.75F, -4.25F, -6.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(22, 69)
						.addBox(7.75F, 8.75F, -5.25F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 2.0F, 3.7F));

		PartDefinition leg_left2 = spider.addOrReplaceChild("leg_left2",
				CubeListBuilder.create().texOffs(64, 47).addBox(-1.25F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -11.0F, -0.5F, 0.0F, 0.1571F, -0.3491F));

		PartDefinition leg_left3_2 = leg_left2.addOrReplaceChild("leg_left3_2",
				CubeListBuilder.create().texOffs(60, 28)
						.addBox(10.25F, -4.0F, -3.5F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(30, 38)
						.addBox(11.25F, 11.0F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 2.0F, 1.5F));

		PartDefinition leg_left3 = spider.addOrReplaceChild("leg_left3",
				CubeListBuilder.create().texOffs(68, 10).addBox(-0.25F, -1.25F, -1.0F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -11.0F, 2.0F, 0.1222F, -0.1571F, -0.5236F));

		PartDefinition leg_left2_2 = leg_left3.addOrReplaceChild("leg_left2_2",
				CubeListBuilder.create().texOffs(52, 49)
						.addBox(14.75F, -2.25F, -1.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 69)
						.addBox(15.75F, 13.75F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 0.0F, -1.0F));

		PartDefinition leg_left4 = spider.addOrReplaceChild("leg_left4",
				CubeListBuilder.create().texOffs(68, 51).addBox(-1.0F, -1.25F, -0.75F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -11.0F, 3.0F, 0.3491F, -0.5672F, -0.6545F));

		PartDefinition leg_left1_2 = leg_left4.addOrReplaceChild("leg_left1_2",
				CubeListBuilder.create().texOffs(0, 49)
						.addBox(15.0F, -1.25F, 0.25F, 4.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 69)
						.addBox(16.0F, 15.75F, 1.25F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-7.0F, -1.0F, -2.0F));

		PartDefinition leg_right1 = spider.addOrReplaceChild("leg_right1",
				CubeListBuilder.create().texOffs(64, 24).mirror()
						.addBox(-9.25F, -1.25F, -1.3F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-5.0F, -11.0F, -3.7F, -0.1745F, -0.5411F, 0.3491F));

		PartDefinition leg_left1_4 = leg_right1.addOrReplaceChild("leg_left1_4",
				CubeListBuilder.create().texOffs(64, 65).mirror()
						.addBox(-10.75F, -4.25F, -6.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(22, 69).mirror()
						.addBox(-9.75F, 8.75F, -5.25F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-1.0F, 2.0F, 3.7F));

		PartDefinition leg_right2 = spider.addOrReplaceChild("leg_right2",
				CubeListBuilder.create().texOffs(64, 47).mirror()
						.addBox(-8.75F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-5.0F, -11.0F, -0.5F, 0.0F, -0.1571F, 0.3491F));

		PartDefinition leg_right3_3 = leg_right2.addOrReplaceChild("leg_right3_3",
				CubeListBuilder.create().texOffs(60, 28).mirror()
						.addBox(-14.25F, -4.0F, -3.5F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(30, 38).mirror()
						.addBox(-13.25F, 11.0F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, 2.0F, 1.5F));

		PartDefinition leg_right3 = spider.addOrReplaceChild("leg_right3",
				CubeListBuilder.create().texOffs(68, 10).mirror()
						.addBox(-8.75F, -1.25F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.0F, -11.0F, 2.0F, 0.1222F, 0.1571F, 0.5236F));

		PartDefinition leg_right_3 = leg_right3.addOrReplaceChild("leg_right_3",
				CubeListBuilder.create().texOffs(52, 49).mirror()
						.addBox(-17.75F, -2.25F, -1.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(48, 69).mirror()
						.addBox(-16.75F, 13.75F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(5.0F, 0.0F, -1.0F));

		PartDefinition leg_right4 = spider.addOrReplaceChild("leg_right4",
				CubeListBuilder.create().texOffs(68, 51).mirror()
						.addBox(-9.0F, -1.25F, -0.75F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.0F, -11.0F, 3.0F, 0.3491F, 0.5672F, 0.6545F));

		PartDefinition leg_right1_4 = leg_right4.addOrReplaceChild("leg_right1_4",
				CubeListBuilder.create().texOffs(0, 49).mirror()
						.addBox(-19.0F, -1.25F, 0.25F, 4.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(56, 69).mirror()
						.addBox(-18.0F, 15.75F, 1.25F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(7.0F, -1.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);

		this.body.xRot = Mth.sin(ageInTicks / 16 + Mth.PI/4) / 18;
		this.brushko.xRot = Mth.sin(ageInTicks / 16) / 18;

		this.heli_right.xRot = Mth.sin(ageInTicks / 14) / 16;
		this.heli_left.xRot = Mth.sin(ageInTicks / 14) / 16;

		this.leg_right1.zRot = (15 * Mth.PI / 180) + Mth.sin(limbSwing * 1F) * 0.5F * limbSwingAmount;
		this.leg_right1.yRot = (-30 * Mth.PI / 180) + Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

		this.leg_right2.zRot = (15 * Mth.PI / 180) + Mth.sin(limbSwing * 1F) * -0.5F * limbSwingAmount;
		this.leg_right2.yRot = (-9 * Mth.PI / 180) - Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

		this.leg_right3.zRot = (25 * Mth.PI / 180) + Mth.sin(limbSwing * 1F) * 0.5F * limbSwingAmount;
		this.leg_right3.yRot = (9 * Mth.PI / 180) + Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

		this.leg_right4.zRot = (30 * Mth.PI / 180) + Mth.sin(limbSwing * 1F) * -0.5F * limbSwingAmount;
		this.leg_right4.yRot = (30 * Mth.PI / 180) - Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

		this.leg_left1.zRot = (-15 * Mth.PI / 180) - Mth.sin(limbSwing * 1F) * -0.5F * limbSwingAmount;
		this.leg_left1.yRot = (30 * Mth.PI / 180) + Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

		this.leg_left2.zRot = (-15 * Mth.PI / 180) - Mth.sin(limbSwing * 1F) * 0.5F * limbSwingAmount;
		this.leg_left2.yRot = (9 * Mth.PI / 180) - Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

		this.leg_left3.zRot = (-25 * Mth.PI / 180) - Mth.sin(limbSwing * 1F) * -0.5F * limbSwingAmount;
		this.leg_left3.yRot = (-9 * Mth.PI / 180) + Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

		this.leg_left4.zRot = (-30 * Mth.PI / 180) - Mth.sin(limbSwing * 1F) * 0.5F * limbSwingAmount;
		this.leg_left4.yRot = (-30 * Mth.PI / 180) - Mth.cos(limbSwing * 1F) * 0.5F * limbSwingAmount;

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		spider.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}