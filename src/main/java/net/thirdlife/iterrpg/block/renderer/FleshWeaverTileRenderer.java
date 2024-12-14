package net.thirdlife.iterrpg.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.thirdlife.iterrpg.block.model.FleshWeaverBlockModel;
import net.thirdlife.iterrpg.block.entity.FleshWeaverTileEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class FleshWeaverTileRenderer extends GeoBlockRenderer<FleshWeaverTileEntity> {
	public FleshWeaverTileRenderer() {
		super(new FleshWeaverBlockModel());
	}

	@Override
	public RenderType getRenderType(FleshWeaverTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
