// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsolsphere<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "solsphere"), "main");
	private final ModelPart base;
	private final ModelPart crown;

	public Modelsolsphere(ModelPart root) {
		this.base = root.getChild("base");
		
		this.crown = base.getChild("crown");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition crown = base.addOrReplaceChild("crown", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition y_pack = crown.addOrReplaceChild("y_pack", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition flametongue_r1 = y_pack
				.addOrReplaceChild("flametongue_r1",
						CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition flametongue_r2 = y_pack
				.addOrReplaceChild("flametongue_r2",
						CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition flametongue_r3 = y_pack.addOrReplaceChild("flametongue_r3",
				CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition flametongue_r4 = y_pack
				.addOrReplaceChild("flametongue_r4",
						CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition flametongue_r5 = y_pack.addOrReplaceChild("flametongue_r5",
				CubeListBuilder.create().texOffs(-4, 24).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));

		PartDefinition flametongue_r6 = y_pack
				.addOrReplaceChild("flametongue_r6",
						CubeListBuilder.create().texOffs(-4, 24).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition flametongue_r7 = y_pack.addOrReplaceChild("flametongue_r7",
				CubeListBuilder.create().texOffs(-4, 24).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 3.1416F));

		PartDefinition flametongue_r8 = y_pack
				.addOrReplaceChild("flametongue_r8",
						CubeListBuilder.create().texOffs(-4, 24).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition z_pack = crown.addOrReplaceChild("z_pack", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition flametongue_r9 = z_pack.addOrReplaceChild("flametongue_r9",
				CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition flametongue_r10 = z_pack
				.addOrReplaceChild("flametongue_r10",
						CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition flametongue_r11 = z_pack.addOrReplaceChild("flametongue_r11",
				CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 3.1416F));

		PartDefinition flametongue_r12 = z_pack.addOrReplaceChild("flametongue_r12",
				CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 1.5708F));

		PartDefinition flametongue_r13 = z_pack.addOrReplaceChild("flametongue_r13",
				CubeListBuilder.create().texOffs(-4, 24).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -2.3562F));

		PartDefinition flametongue_r14 = z_pack.addOrReplaceChild("flametongue_r14",
				CubeListBuilder.create().texOffs(-4, 19).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -0.7854F));

		PartDefinition flametongue_r15 = z_pack.addOrReplaceChild("flametongue_r15",
				CubeListBuilder.create().texOffs(-4, 19).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 2.3562F));

		PartDefinition flametongue_r16 = z_pack.addOrReplaceChild("flametongue_r16",
				CubeListBuilder.create().texOffs(-4, 24).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.7854F));

		PartDefinition x_pack = crown.addOrReplaceChild("x_pack", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition flametongue_r17 = x_pack.addOrReplaceChild("flametongue_r17",
				CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition flametongue_r18 = x_pack
				.addOrReplaceChild("flametongue_r18",
						CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition flametongue_r19 = x_pack.addOrReplaceChild("flametongue_r19",
				CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, -1.5708F));

		PartDefinition flametongue_r20 = x_pack.addOrReplaceChild("flametongue_r20",
				CubeListBuilder.create().texOffs(-3, 29).addBox(3.0F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 1.5708F));

		PartDefinition flametongue_r21 = x_pack.addOrReplaceChild("flametongue_r21",
				CubeListBuilder.create().texOffs(-4, 19).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.7854F, -1.5708F));

		PartDefinition flametongue_r22 = x_pack.addOrReplaceChild("flametongue_r22",
				CubeListBuilder.create().texOffs(-4, 24).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 1.5708F));

		PartDefinition flametongue_r23 = x_pack.addOrReplaceChild("flametongue_r23",
				CubeListBuilder.create().texOffs(-4, 24).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, -1.5708F));

		PartDefinition flametongue_r24 = x_pack.addOrReplaceChild("flametongue_r24",
				CubeListBuilder.create().texOffs(-4, 19).addBox(3.0F, 0.0F, -2.0F, 9.0F, 0.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.base.yRot = ageInTicks / 10.f;
		this.crown.yRot = ageInTicks / 10.f;
	}
}