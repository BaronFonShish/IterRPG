
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.procedures.CarcassReturnInjuredProcedure;
import net.thirdlife.iterrpg.procedures.CarcassReturnArmoredProcedure;
import net.thirdlife.iterrpg.entity.CarcassEntity;
import net.thirdlife.iterrpg.client.model.Modelcarcass;

import net.minecraft.world.level.Level;
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

public class CarcassRenderer extends MobRenderer<CarcassEntity, Modelcarcass<CarcassEntity>> {
	public CarcassRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcarcass(context.bakeLayer(Modelcarcass.LAYER_LOCATION)), 0.6f);
		this.addLayer(new RenderLayer<CarcassEntity, Modelcarcass<CarcassEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/carcass-bones.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CarcassEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CarcassReturnArmoredProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelcarcass(Minecraft.getInstance().getEntityModels().bakeLayer(Modelcarcass.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CarcassEntity, Modelcarcass<CarcassEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/carcass-injured.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CarcassEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CarcassReturnInjuredProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelcarcass(Minecraft.getInstance().getEntityModels().bakeLayer(Modelcarcass.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(CarcassEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/carcass-naked.png");
	}
}
