package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.SeaArrowEntity;
import net.thirdlife.iterrpg.client.model.Modelsea_arrow;

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

public class SeaArrowRenderer extends EntityRenderer<SeaArrowEntity> {
	private static final ResourceLocation texture = new ResourceLocation("iter_rpg:textures/entities/sea_arrow.png");
	private final Modelsea_arrow model;

	public SeaArrowRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelsea_arrow(context.bakeLayer(Modelsea_arrow.LAYER_LOCATION));
	}

	@Override
	public void render(SeaArrowEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(SeaArrowEntity entity) {
		return texture;
	}
}
