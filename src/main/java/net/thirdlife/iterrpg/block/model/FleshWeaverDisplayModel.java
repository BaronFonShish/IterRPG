package net.thirdlife.iterrpg.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.thirdlife.iterrpg.block.display.FleshWeaverDisplayItem;

import net.minecraft.resources.ResourceLocation;

public class FleshWeaverDisplayModel extends GeoModel<FleshWeaverDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(FleshWeaverDisplayItem animatable) {
		return new ResourceLocation("iter_rpg", "animations/flesh_weaver.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FleshWeaverDisplayItem animatable) {
		return new ResourceLocation("iter_rpg", "geo/flesh_weaver.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FleshWeaverDisplayItem entity) {
		return new ResourceLocation("iter_rpg", "textures/block/flesh_weaver.png");
	}
}
