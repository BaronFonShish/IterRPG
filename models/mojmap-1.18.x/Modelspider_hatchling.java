// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelspider_hatchling<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "spider_hatchling"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart right_leg_1;
	private final ModelPart right_leg_2;
	private final ModelPart right_leg_3;
	private final ModelPart right_leg_4;
	private final ModelPart left_leg_1;
	private final ModelPart left_leg_2;
	private final ModelPart left_leg_3;
	private final ModelPart left_leg_4;

	public Modelspider_hatchling(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.right_leg_1 = root.getChild("right_leg_1");
		this.right_leg_2 = root.getChild("right_leg_2");
		this.right_leg_3 = root.getChild("right_leg_3");
		this.right_leg_4 = root.getChild("right_leg_4");
		this.left_leg_1 = root.getChild("left_leg_1");
		this.left_leg_2 = root.getChild("left_leg_2");
		this.left_leg_3 = root.getChild("left_leg_3");
		this.left_leg_4 = root.getChild("left_leg_4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(
				-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.5F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 13)
						.addBox(-2.0F, -2.5F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 18)
						.addBox(-2.5F, 0.5F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 13)
						.addBox(0.5F, 0.5F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 19.5F, -3.0F));

		PartDefinition right_leg_1 = partdefinition.addOrReplaceChild("right_leg_1",
				CubeListBuilder.create().texOffs(16, 23).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, 21.5F, -2.5F, -0.6109F, 0.0F, 1.0472F));

		PartDefinition right_leg_2 = partdefinition.addOrReplaceChild("right_leg_2",
				CubeListBuilder.create().texOffs(12, 22).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, 21.5F, -0.5F, -0.1745F, 0.0F, 1.0472F));

		PartDefinition right_leg_3 = partdefinition.addOrReplaceChild("right_leg_3",
				CubeListBuilder.create().texOffs(8, 22).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, 21.5F, 1.5F, 0.1745F, 0.0F, 1.0472F));

		PartDefinition right_leg_4 = partdefinition.addOrReplaceChild("right_leg_4",
				CubeListBuilder.create().texOffs(4, 22).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, 21.5F, 3.5F, 0.6109F, 0.0F, 1.0472F));

		PartDefinition left_leg_1 = partdefinition.addOrReplaceChild("left_leg_1",
				CubeListBuilder.create().texOffs(23, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, 21.5F, -2.5F, -0.6109F, 0.0F, -1.0472F));

		PartDefinition left_leg_2 = partdefinition.addOrReplaceChild("left_leg_2",
				CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, 21.5F, -0.5F, -0.1745F, 0.0F, -1.0472F));

		PartDefinition left_leg_3 = partdefinition.addOrReplaceChild("left_leg_3",
				CubeListBuilder.create().texOffs(19, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, 21.5F, 1.5F, 0.1745F, 0.0F, -1.0472F));

		PartDefinition left_leg_4 = partdefinition.addOrReplaceChild("left_leg_4",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, 21.5F, 3.5F, 0.6109F, 0.0F, -1.0472F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_leg_1.zRot = (60 * Mth.PI/180) + Mth.sin(limbSwing * 2.0F) * 0.75F * limbSwingAmount;
		this.right_leg_1.xRot = (-35 * Mth.PI/180) + Mth.cos(limbSwing * 2.0F) * 0.5F * limbSwingAmount;
		
		this.right_leg_2.zRot = (60 * Mth.PI/180) + Mth.sin(limbSwing * 2.0F) * -0.75F * limbSwingAmount;
		this.right_leg_2.xRot = (-10 * Mth.PI/180) + Mth.cos(limbSwing * 2.0F) * -0.5F * limbSwingAmount;
		
		this.right_leg_3.zRot = (60 * Mth.PI/180) + Mth.sin(limbSwing * 2.0F) * 0.75F * limbSwingAmount;
		this.right_leg_3.xRot = (10 * Mth.PI/180) + Mth.cos(limbSwing * 2.0F) * 0.5F * limbSwingAmount;
		
		this.right_leg_4.zRot = (60 * Mth.PI/180) + Mth.sin(limbSwing * 2.0F) * -0.75F * limbSwingAmount;	
		this.right_leg_4.xRot = (35 * Mth.PI/180) + Mth.cos(limbSwing * 2.0F) * -0.5F * limbSwingAmount;
		
		this.left_leg_1.zRot = (-60 * Mth.PI/180) + Mth.sin(limbSwing * 2.0F) * -0.75F * limbSwingAmount;
		this.left_leg_1.xRot = (-35 * Mth.PI/180) + Mth.cos(limbSwing * 2.0F) * 0.5F * limbSwingAmount;
		
		this.left_leg_2.zRot = (-60 * Mth.PI/180) + Mth.sin(limbSwing * 2.0F) * 0.75F * limbSwingAmount;
		this.left_leg_2.xRot = (-10 * Mth.PI/180) + Mth.cos(limbSwing * 2.0F) * -0.5F * limbSwingAmount;
		
		this.left_leg_3.zRot = (-60 * Mth.PI/180) + Mth.sin(limbSwing * 2.0F) * -0.75F * limbSwingAmount;
		this.left_leg_3.xRot = (10 * Mth.PI/180) + Mth.cos(limbSwing * 2.0F) * 0.5F * limbSwingAmount;
		
		this.left_leg_4.zRot = (-60 * Mth.PI/180) + Mth.sin(limbSwing * 2.0F) * 0.75F * limbSwingAmount;
		this.left_leg_4.xRot = (35 * Mth.PI/180) + Mth.cos(limbSwing * 2.0F) * -0.5F * limbSwingAmount;
	}
}