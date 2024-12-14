
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.entity.AxebeakEntity;
import net.thirdlife.iterrpg.client.model.Modelaxebeak;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class AxebeakRenderer extends MobRenderer<AxebeakEntity, Modelaxebeak<AxebeakEntity>> {
	public AxebeakRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelaxebeak(context.bakeLayer(Modelaxebeak.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AxebeakEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/axebeak.png");
	}
}
