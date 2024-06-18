
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.SorrowsealedEntity;
import net.thirdlife.iterrpg.client.model.Modelsorrowsealed;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SorrowsealedRenderer extends MobRenderer<SorrowsealedEntity, Modelsorrowsealed<SorrowsealedEntity>> {
	public SorrowsealedRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsorrowsealed(context.bakeLayer(Modelsorrowsealed.LAYER_LOCATION)), 3f);
	}

	@Override
	public ResourceLocation getTextureLocation(SorrowsealedEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/sorrowsealed.png");
	}
}
