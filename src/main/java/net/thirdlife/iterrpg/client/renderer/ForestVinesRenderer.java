
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.common.procedures.DemonspineShakeProcedure;
import net.thirdlife.iterrpg.common.entity.ForestVinesEntity;
import net.thirdlife.iterrpg.client.model.Modelforest_vines;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ForestVinesRenderer extends MobRenderer<ForestVinesEntity, Modelforest_vines<ForestVinesEntity>> {
	public ForestVinesRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelforest_vines(context.bakeLayer(Modelforest_vines.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(ForestVinesEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/forest_vines.png");
	}

	@Override
	protected boolean isShaking(ForestVinesEntity entity) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return DemonspineShakeProcedure.execute(entity);
	}
}
