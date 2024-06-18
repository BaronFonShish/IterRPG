
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.entity.SolsphereEntity;
import net.thirdlife.iterrpg.client.model.Modelsolsphere;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SolsphereRenderer extends MobRenderer<SolsphereEntity, Modelsolsphere<SolsphereEntity>> {
	public SolsphereRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsolsphere(context.bakeLayer(Modelsolsphere.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(SolsphereEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/solsphere.png");
	}
}
