
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.SmallScallopEntity;
import net.thirdlife.iterrpg.client.model.Modeltiny_scallop;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SmallScallopRenderer extends MobRenderer<SmallScallopEntity, Modeltiny_scallop<SmallScallopEntity>> {
	public SmallScallopRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltiny_scallop(context.bakeLayer(Modeltiny_scallop.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(SmallScallopEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/tiny_scallop.png");
	}
}
