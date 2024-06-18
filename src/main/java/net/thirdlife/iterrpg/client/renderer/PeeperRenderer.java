
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.PeeperEntity;
import net.thirdlife.iterrpg.client.model.Modelpeeper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PeeperRenderer extends MobRenderer<PeeperEntity, Modelpeeper<PeeperEntity>> {
	public PeeperRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpeeper(context.bakeLayer(Modelpeeper.LAYER_LOCATION)), 0.8f);
	}

	@Override
	public ResourceLocation getTextureLocation(PeeperEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/peeper.png");
	}
}
