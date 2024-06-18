
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.GrimhookEntity;
import net.thirdlife.iterrpg.client.model.Modelgrimhook;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GrimhookRenderer extends MobRenderer<GrimhookEntity, Modelgrimhook<GrimhookEntity>> {
	public GrimhookRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgrimhook(context.bakeLayer(Modelgrimhook.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(GrimhookEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/grimhook.png");
	}
}
