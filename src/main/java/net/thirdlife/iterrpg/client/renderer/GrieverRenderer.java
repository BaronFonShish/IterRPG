
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.GrieverEntity;
import net.thirdlife.iterrpg.client.model.Modelgriever;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GrieverRenderer extends MobRenderer<GrieverEntity, Modelgriever<GrieverEntity>> {
	public GrieverRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgriever(context.bakeLayer(Modelgriever.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(GrieverEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/griever.png");
	}
}
