
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.GoblinEntity;
import net.thirdlife.iterrpg.client.model.Modelgoblin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GoblinRenderer extends MobRenderer<GoblinEntity, Modelgoblin<GoblinEntity>> {
	public GoblinRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoblin(context.bakeLayer(Modelgoblin.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/goblin.png");
	}
}
