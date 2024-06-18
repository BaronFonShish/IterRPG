
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.WindswirlEntity;
import net.thirdlife.iterrpg.client.model.Modelwindswirl;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class WindswirlRenderer extends MobRenderer<WindswirlEntity, Modelwindswirl<WindswirlEntity>> {
	public WindswirlRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwindswirl(context.bakeLayer(Modelwindswirl.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(WindswirlEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/windswirl.png");
	}
}
