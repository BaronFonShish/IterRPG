package net.thirdlife.iterrpg.init;

import net.thirdlife.iterrpg.configuration.IterConfigConfiguration;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = IterRpgMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IterRpgModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, IterConfigConfiguration.SPEC, "iterpg.toml");
		});
	}
}
