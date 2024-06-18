
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.SpiderlingEntity;
import net.thirdlife.iterrpg.client.model.Modelspider_hatchling;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SpiderlingRenderer extends MobRenderer<SpiderlingEntity, Modelspider_hatchling<SpiderlingEntity>> {
	public SpiderlingRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspider_hatchling(context.bakeLayer(Modelspider_hatchling.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpiderlingEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/spider_hatchling.png");
	}
}
