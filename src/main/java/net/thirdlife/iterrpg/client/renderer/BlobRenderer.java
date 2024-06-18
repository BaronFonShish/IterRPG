
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.BlobEntity;
import net.thirdlife.iterrpg.client.model.Modelblob;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BlobRenderer extends MobRenderer<BlobEntity, Modelblob<BlobEntity>> {
	public BlobRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelblob(context.bakeLayer(Modelblob.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlobEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/bubble.png");
	}
}
