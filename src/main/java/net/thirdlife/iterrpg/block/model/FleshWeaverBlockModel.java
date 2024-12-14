package net.thirdlife.iterrpg.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.thirdlife.iterrpg.block.entity.FleshWeaverTileEntity;

import net.minecraft.resources.ResourceLocation;

public class FleshWeaverBlockModel extends GeoModel<FleshWeaverTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(FleshWeaverTileEntity animatable) {
		return new ResourceLocation("iter_rpg", "animations/flesh_weaver.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FleshWeaverTileEntity animatable) {
		return new ResourceLocation("iter_rpg", "geo/flesh_weaver.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FleshWeaverTileEntity animatable) {
		return new ResourceLocation("iter_rpg", "textures/block/flesh_weaver.png");
	}
}
