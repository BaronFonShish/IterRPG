
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.CaltropThrownEntity;
import net.thirdlife.iterrpg.client.model.Modelcaltrop;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CaltropThrownRenderer extends MobRenderer<CaltropThrownEntity, Modelcaltrop<CaltropThrownEntity>> {
	public CaltropThrownRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcaltrop(context.bakeLayer(Modelcaltrop.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(CaltropThrownEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/caltrop.png");
	}
}
