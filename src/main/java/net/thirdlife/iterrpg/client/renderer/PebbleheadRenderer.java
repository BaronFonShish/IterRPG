
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.entity.PebbleheadEntity;
import net.thirdlife.iterrpg.client.model.Modelstonehead;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PebbleheadRenderer extends MobRenderer<PebbleheadEntity, Modelstonehead<PebbleheadEntity>> {
	public PebbleheadRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstonehead(context.bakeLayer(Modelstonehead.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(PebbleheadEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/stonehead.png");
	}
}
