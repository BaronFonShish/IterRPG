
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.GiantSpiderEntity;
import net.thirdlife.iterrpg.client.model.Modelgiant_spider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GiantSpiderRenderer extends MobRenderer<GiantSpiderEntity, Modelgiant_spider<GiantSpiderEntity>> {
	public GiantSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgiant_spider(context.bakeLayer(Modelgiant_spider.LAYER_LOCATION)), 1.2f);
		this.addLayer(new RenderLayer<GiantSpiderEntity, Modelgiant_spider<GiantSpiderEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/giant_spider_emmissive.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GiantSpiderEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GiantSpiderEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/giant_spider.png");
	}
}
