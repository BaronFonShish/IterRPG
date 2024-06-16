
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.procedures.ScallopPearlConditionProcedure;
import net.thirdlife.iterrpg.entity.ScallopEntity;
import net.thirdlife.iterrpg.client.model.Modelmussel;

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

public class ScallopRenderer extends MobRenderer<ScallopEntity, Modelmussel<ScallopEntity>> {
	public ScallopRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmussel(context.bakeLayer(Modelmussel.LAYER_LOCATION)), 0.6f);
		this.addLayer(new RenderLayer<ScallopEntity, Modelmussel<ScallopEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("iter_rpg:textures/entities/mussel_pearl.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ScallopEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (ScallopPearlConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelmussel(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmussel.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ScallopEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/mussel.png");
	}
}
