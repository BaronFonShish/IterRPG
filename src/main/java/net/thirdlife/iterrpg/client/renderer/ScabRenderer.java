
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.ScabEntity;
import net.thirdlife.iterrpg.client.model.ModelScab;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ScabRenderer extends MobRenderer<ScabEntity, ModelScab<ScabEntity>> {
	public ScabRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelScab(context.bakeLayer(ModelScab.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ScabEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/scab.png");
	}
}
