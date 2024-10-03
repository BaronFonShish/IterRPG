
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.entity.HydraBubbleEntity;
import net.thirdlife.iterrpg.client.model.Modelgreat_bubble;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class HydraBubbleRenderer extends MobRenderer<HydraBubbleEntity, Modelgreat_bubble<HydraBubbleEntity>> {
	public HydraBubbleRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgreat_bubble(context.bakeLayer(Modelgreat_bubble.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(HydraBubbleEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/hydra_bubble.png");
	}
}
