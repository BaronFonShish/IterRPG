
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.VoidPortalEntity;
import net.thirdlife.iterrpg.client.model.Modelvoid_portal;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class VoidPortalRenderer extends MobRenderer<VoidPortalEntity, Modelvoid_portal<VoidPortalEntity>> {
	public VoidPortalRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelvoid_portal(context.bakeLayer(Modelvoid_portal.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(VoidPortalEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/void_portal.png");
	}
}
