
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.entity.EventSpawnEntity;
import net.thirdlife.iterrpg.client.model.Modelblob;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class EventSpawnRenderer extends MobRenderer<EventSpawnEntity, Modelblob<EventSpawnEntity>> {
	public EventSpawnRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelblob(context.bakeLayer(Modelblob.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(EventSpawnEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/empty.png");
	}
}
