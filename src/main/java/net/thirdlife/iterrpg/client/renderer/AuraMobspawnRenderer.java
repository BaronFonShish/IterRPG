
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.AuraMobspawnEntity;
import net.thirdlife.iterrpg.client.model.Modelaura_mobspawn;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AuraMobspawnRenderer extends MobRenderer<AuraMobspawnEntity, Modelaura_mobspawn<AuraMobspawnEntity>> {
	public AuraMobspawnRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelaura_mobspawn(context.bakeLayer(Modelaura_mobspawn.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<AuraMobspawnEntity, Modelaura_mobspawn<AuraMobspawnEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/aura_mobspawn.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, AuraMobspawnEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AuraMobspawnEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/aura_mobspawn.png");
	}
}
