
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.GrimaceEntity;
import net.thirdlife.iterrpg.client.model.Modelgrimace;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GrimaceRenderer extends MobRenderer<GrimaceEntity, Modelgrimace<GrimaceEntity>> {
	public GrimaceRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgrimace(context.bakeLayer(Modelgrimace.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(GrimaceEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/grimace.png");
	}
}
