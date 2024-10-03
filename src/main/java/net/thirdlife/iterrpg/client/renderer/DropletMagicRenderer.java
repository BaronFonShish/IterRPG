package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.entity.DropletMagicEntity;
import net.thirdlife.iterrpg.client.model.Modeldroplet_projectile;

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

public class DropletMagicRenderer extends EntityRenderer<DropletMagicEntity> {
	private static final ResourceLocation texture = new ResourceLocation("iter_rpg:textures/entities/droplet.png");
	private final Modeldroplet_projectile model;

	public DropletMagicRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modeldroplet_projectile(context.bakeLayer(Modeldroplet_projectile.LAYER_LOCATION));
	}

	@Override
	public void render(DropletMagicEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(DropletMagicEntity entity) {
		return texture;
	}
}
