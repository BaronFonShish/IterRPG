
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.FireElementalEntity;
import net.thirdlife.iterrpg.client.model.Modelfire_elemental;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FireElementalRenderer extends MobRenderer<FireElementalEntity, Modelfire_elemental<FireElementalEntity>> {
	public FireElementalRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfire_elemental(context.bakeLayer(Modelfire_elemental.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<FireElementalEntity, Modelfire_elemental<FireElementalEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/fire_elemental_emmissive.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FireElementalEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(FireElementalEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/fire_elemental.png");
	}
}
