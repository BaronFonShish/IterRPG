
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.ChainHandleEntity;
import net.thirdlife.iterrpg.client.model.Modelchain_handle;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ChainHandleRenderer extends MobRenderer<ChainHandleEntity, Modelchain_handle<ChainHandleEntity>> {
	public ChainHandleRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelchain_handle(context.bakeLayer(Modelchain_handle.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(ChainHandleEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/chain_handle.png");
	}
}
