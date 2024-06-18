
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.MudkinEntity;
import net.thirdlife.iterrpg.client.model.Modelmudkin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class MudkinRenderer extends MobRenderer<MudkinEntity, Modelmudkin<MudkinEntity>> {
	public MudkinRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmudkin(context.bakeLayer(Modelmudkin.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(MudkinEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/witchmud_golem.png");
	}
}
