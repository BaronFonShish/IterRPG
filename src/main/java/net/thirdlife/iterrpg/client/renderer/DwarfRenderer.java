
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.DwarfEntity;
import net.thirdlife.iterrpg.client.model.Modeldwarf;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DwarfRenderer extends MobRenderer<DwarfEntity, Modeldwarf<DwarfEntity>> {
	public DwarfRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldwarf(context.bakeLayer(Modeldwarf.LAYER_LOCATION)), 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(DwarfEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/dwarf.png");
	}
}
