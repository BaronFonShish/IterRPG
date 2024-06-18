
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.UnboundSoulEntity;
import net.thirdlife.iterrpg.client.model.Modelunbound_soul;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class UnboundSoulRenderer extends MobRenderer<UnboundSoulEntity, Modelunbound_soul<UnboundSoulEntity>> {
	public UnboundSoulRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelunbound_soul(context.bakeLayer(Modelunbound_soul.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<UnboundSoulEntity, Modelunbound_soul<UnboundSoulEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/unbound_soul.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, UnboundSoulEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new Modelunbound_soul(Minecraft.getInstance().getEntityModels().bakeLayer(Modelunbound_soul.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(UnboundSoulEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/unbound_soul.png");
	}

	@Override
	protected boolean isBodyVisible(UnboundSoulEntity entity) {
		return false;
	}
}
