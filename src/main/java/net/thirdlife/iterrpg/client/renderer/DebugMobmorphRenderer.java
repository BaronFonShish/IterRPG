
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.DebugMobmorphEntity;
import net.thirdlife.iterrpg.client.model.Modelblob;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DebugMobmorphRenderer extends MobRenderer<DebugMobmorphEntity, Modelblob<DebugMobmorphEntity>> {
	public DebugMobmorphRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelblob(context.bakeLayer(Modelblob.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(DebugMobmorphEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/empty.png");
	}
}
