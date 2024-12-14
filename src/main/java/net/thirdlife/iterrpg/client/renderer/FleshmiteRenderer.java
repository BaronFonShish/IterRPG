
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.entity.FleshmiteEntity;
import net.thirdlife.iterrpg.client.model.Modelfleshmite;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class FleshmiteRenderer extends MobRenderer<FleshmiteEntity, Modelfleshmite<FleshmiteEntity>> {
	public FleshmiteRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfleshmite(context.bakeLayer(Modelfleshmite.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(FleshmiteEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/fleshmite.png");
	}
}
