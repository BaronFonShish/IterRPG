
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.WeeperEntity;
import net.thirdlife.iterrpg.client.model.Modelweeper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class WeeperRenderer extends MobRenderer<WeeperEntity, Modelweeper<WeeperEntity>> {
	public WeeperRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelweeper(context.bakeLayer(Modelweeper.LAYER_LOCATION)), 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(WeeperEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/weeper.png");
	}
}
