
package net.thirdlife.iterrpg.client.renderer;

import net.thirdlife.iterrpg.procedures.HarvestReturnScaleProcedure;
import net.thirdlife.iterrpg.entity.HarvestSpiralEntity;
import net.thirdlife.iterrpg.client.model.Modelharvest_spiral;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.mojang.blaze3d.vertex.PoseStack;

public class HarvestSpiralRenderer extends MobRenderer<HarvestSpiralEntity, Modelharvest_spiral<HarvestSpiralEntity>> {
	public HarvestSpiralRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelharvest_spiral(context.bakeLayer(Modelharvest_spiral.LAYER_LOCATION)), 0f);
	}

	@Override
	protected void scale(HarvestSpiralEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) HarvestReturnScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(HarvestSpiralEntity entity) {
		return new ResourceLocation("iter_rpg:textures/entities/harvest_spiral.png");
	}
}
