
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.procedures.DemonspineShakeProcedure;
import net.thirdlife.iterrpg.entity.DemonspineEntity;
import net.thirdlife.iterrpg.client.model.Modeldemonspine;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DemonspineRenderer extends MobRenderer<DemonspineEntity, Modeldemonspine<DemonspineEntity>> {
	public DemonspineRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldemonspine(context.bakeLayer(Modeldemonspine.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(DemonspineEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/spine.png");
	}

	@Override
	protected boolean isShaking(DemonspineEntity entity) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return DemonspineShakeProcedure.execute(entity);
	}
}
