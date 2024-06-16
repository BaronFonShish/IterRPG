
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.procedures.DemonspineShakeProcedure;
import net.thirdlife.iterrpg.entity.EarthBoulderEntity;
import net.thirdlife.iterrpg.client.model.ModelEarthBoulder;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class EarthBoulderRenderer extends MobRenderer<EarthBoulderEntity, ModelEarthBoulder<EarthBoulderEntity>> {
	public EarthBoulderRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelEarthBoulder(context.bakeLayer(ModelEarthBoulder.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(EarthBoulderEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/earthboulder.png");
	}

	@Override
	protected boolean isShaking(EarthBoulderEntity entity) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return DemonspineShakeProcedure.execute(entity);
	}
}
