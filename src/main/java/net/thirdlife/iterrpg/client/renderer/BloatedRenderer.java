
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.BloatedEntity;
import net.thirdlife.iterrpg.client.model.Modelbloated;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BloatedRenderer extends MobRenderer<BloatedEntity, Modelbloated<BloatedEntity>> {
	public BloatedRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbloated(context.bakeLayer(Modelbloated.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BloatedEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/drowned.png");
	}
}
