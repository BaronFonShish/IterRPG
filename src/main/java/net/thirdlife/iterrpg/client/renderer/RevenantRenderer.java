
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.entity.RevenantEntity;
import net.thirdlife.iterrpg.client.model.Modelrevenant;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.mojang.blaze3d.vertex.PoseStack;

public class RevenantRenderer extends MobRenderer<RevenantEntity, Modelrevenant<RevenantEntity>> {
	public RevenantRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelrevenant(context.bakeLayer(Modelrevenant.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(RevenantEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.95f, 0.95f, 0.95f);
	}

	@Override
	public ResourceLocation getTextureLocation(RevenantEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/revenant_new.png");
	}
}
