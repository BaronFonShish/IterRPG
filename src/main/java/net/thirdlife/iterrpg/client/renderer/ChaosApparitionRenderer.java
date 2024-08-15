
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.entity.ChaosApparitionEntity;
import net.thirdlife.iterrpg.client.model.Modeldemon_soul;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ChaosApparitionRenderer extends MobRenderer<ChaosApparitionEntity, Modeldemon_soul<ChaosApparitionEntity>> {
	public ChaosApparitionRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldemon_soul(context.bakeLayer(Modeldemon_soul.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ChaosApparitionEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/demonsoul.png");
	}

	@Override
	protected boolean isShaking(ChaosApparitionEntity entity) {
		return true;
	}
}
