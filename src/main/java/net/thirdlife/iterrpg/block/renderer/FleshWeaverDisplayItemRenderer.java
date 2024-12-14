package net.thirdlife.iterrpg.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.thirdlife.iterrpg.block.model.FleshWeaverDisplayModel;
import net.thirdlife.iterrpg.block.display.FleshWeaverDisplayItem;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class FleshWeaverDisplayItemRenderer extends GeoItemRenderer<FleshWeaverDisplayItem> {
	public FleshWeaverDisplayItemRenderer() {
		super(new FleshWeaverDisplayModel());
	}

	@Override
	public RenderType getRenderType(FleshWeaverDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
