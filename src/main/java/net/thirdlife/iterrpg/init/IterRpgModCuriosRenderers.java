package net.thirdlife.iterrpg.init;

import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import net.thirdlife.iterrpg.client.renderer.FesteringWingsRenderer;
import net.thirdlife.iterrpg.client.model.Modelpestering_wings;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IterRpgModCuriosRenderers {
	@SubscribeEvent
	public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
		evt.registerLayerDefinition(IterRpgModLayerDefinitions.FESTERING_WINGS, Modelpestering_wings::createBodyLayer);
	}

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent evt) {
		CuriosRendererRegistry.register(IterRpgModItems.FESTERING_WINGS.get(), FesteringWingsRenderer::new);
	}
}
