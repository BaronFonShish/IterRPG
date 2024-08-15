package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.entity.FlameboltEntity;
import net.thirdlife.iterrpg.client.model.Modelflamebolt;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FlameboltRenderer extends EntityRenderer<FlameboltEntity> {
	private static final ResourceLocation texture = new ResourceLocation("iter_rpg:textures/entities/flamebolt.png");
	private final Modelflamebolt model;

	public FlameboltRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelflamebolt(context.bakeLayer(Modelflamebolt.LAYER_LOCATION));
	}

	@Override
	public void render(FlameboltEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(FlameboltEntity entity) {
		return texture;
	}
}
