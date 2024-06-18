
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.MournstoneEntity;
import net.thirdlife.iterrpg.client.model.Modelmournstone;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MournstoneRenderer extends MobRenderer<MournstoneEntity, Modelmournstone<MournstoneEntity>> {
	public MournstoneRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmournstone(context.bakeLayer(Modelmournstone.LAYER_LOCATION)), 0.6f);
		this.addLayer(new RenderLayer<MournstoneEntity, Modelmournstone<MournstoneEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/mournstone_emmissive.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MournstoneEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(MournstoneEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/mournstone.png");
	}
}
