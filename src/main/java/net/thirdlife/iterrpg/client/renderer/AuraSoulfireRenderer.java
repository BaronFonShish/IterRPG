
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.AuraSoulfireEntity;
import net.thirdlife.iterrpg.client.model.Modelaura_soulfire;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AuraSoulfireRenderer extends MobRenderer<AuraSoulfireEntity, Modelaura_soulfire<AuraSoulfireEntity>> {
	public AuraSoulfireRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelaura_soulfire(context.bakeLayer(Modelaura_soulfire.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<AuraSoulfireEntity, Modelaura_soulfire<AuraSoulfireEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/soulfire_aura.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, AuraSoulfireEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AuraSoulfireEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/soulfire_aura.png");
	}
}
