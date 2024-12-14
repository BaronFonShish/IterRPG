package net.thirdlife.iterrpg.block.listener;

import net.thirdlife.iterrpg.init.IterRpgModBlockEntities;
import net.thirdlife.iterrpg.block.renderer.FleshWeaverTileRenderer;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(modid = IterRpgMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(IterRpgModBlockEntities.FLESH_WEAVER.get(), context -> new FleshWeaverTileRenderer());
	}
}
