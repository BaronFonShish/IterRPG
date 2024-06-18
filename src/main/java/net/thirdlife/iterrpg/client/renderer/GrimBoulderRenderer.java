
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.GrimBoulderEntity;
import net.thirdlife.iterrpg.client.model.Modelgrim_boulder;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GrimBoulderRenderer extends MobRenderer<GrimBoulderEntity, Modelgrim_boulder<GrimBoulderEntity>> {
	public GrimBoulderRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgrim_boulder(context.bakeLayer(Modelgrim_boulder.LAYER_LOCATION)), 0.8f);
		this.addLayer(new RenderLayer<GrimBoulderEntity, Modelgrim_boulder<GrimBoulderEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/boulder_fall.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GrimBoulderEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GrimBoulderEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/boulder_fall.png");
	}
}
