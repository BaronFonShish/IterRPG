
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.HobgoblinEntity;
import net.thirdlife.iterrpg.client.model.ModelHobGoblin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class HobgoblinRenderer extends MobRenderer<HobgoblinEntity, ModelHobGoblin<HobgoblinEntity>> {
	public HobgoblinRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelHobGoblin(context.bakeLayer(ModelHobGoblin.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HobgoblinEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/hobgoblin.png");
	}
}
