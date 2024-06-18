
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.AuraBoulderEntity;
import net.thirdlife.iterrpg.client.model.Modelaura_boulder;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AuraBoulderRenderer extends MobRenderer<AuraBoulderEntity, Modelaura_boulder<AuraBoulderEntity>> {
	public AuraBoulderRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelaura_boulder(context.bakeLayer(Modelaura_boulder.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<AuraBoulderEntity, Modelaura_boulder<AuraBoulderEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/boulder.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, AuraBoulderEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AuraBoulderEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/boulder.png");
	}
}
