
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.EarthElementalEntity;
import net.thirdlife.iterrpg.client.model.Modelearth_elemental;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class EarthElementalRenderer extends MobRenderer<EarthElementalEntity, Modelearth_elemental<EarthElementalEntity>> {
	public EarthElementalRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelearth_elemental(context.bakeLayer(Modelearth_elemental.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(EarthElementalEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/earth_elemental.png");
	}
}
