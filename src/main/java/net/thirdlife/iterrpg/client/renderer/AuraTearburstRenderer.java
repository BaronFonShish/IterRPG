
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.AuraTearburstEntity;
import net.thirdlife.iterrpg.client.model.Modelaura_tearburst;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AuraTearburstRenderer extends MobRenderer<AuraTearburstEntity, Modelaura_tearburst<AuraTearburstEntity>> {
	public AuraTearburstRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelaura_tearburst(context.bakeLayer(Modelaura_tearburst.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<AuraTearburstEntity, Modelaura_tearburst<AuraTearburstEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/tearburst_aura.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, AuraTearburstEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AuraTearburstEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/tearburst_aura.png");
	}
}
