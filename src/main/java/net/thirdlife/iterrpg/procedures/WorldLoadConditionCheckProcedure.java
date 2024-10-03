package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.configuration.IterConfigConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

import java.io.File;

@Mod.EventBusSubscriber
public class WorldLoadConditionCheckProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.minecraftforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		File configfile = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		com.google.gson.JsonObject goblins = new com.google.gson.JsonObject();
		com.google.gson.JsonObject magic = new com.google.gson.JsonObject();
		com.google.gson.JsonObject mobs = new com.google.gson.JsonObject();
		com.google.gson.JsonObject generation = new com.google.gson.JsonObject();
		com.google.gson.JsonObject functions = new com.google.gson.JsonObject();
		com.google.gson.JsonObject checkfor = new com.google.gson.JsonObject();
		boolean flag = false;
		IterRpgModVariables.MapVariables.get(world).config_abyss_quartz = IterConfigConfiguration.ABYSSQUARTZ.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_vases = IterConfigConfiguration.VASES.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_spider_eggs = IterConfigConfiguration.SPIDER_EGGS.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_geodes = IterConfigConfiguration.GEODITES.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_geodes_drop = IterConfigConfiguration.GEODE_DROP.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_spider_catacombs = IterConfigConfiguration.ARTHROPOD_CATACOMBS.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_generic_dungeons = IterConfigConfiguration.GENERIC_DUNGEONS.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_goblin_camps = IterConfigConfiguration.GOBLIN_CAMPS.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_goblin_patrols = IterConfigConfiguration.GOBLIN_PATROLS.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_sorrow_spire = IterConfigConfiguration.SORROW_SPIRE.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_elementals = IterConfigConfiguration.ELEMENTALS.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_spiderlings = IterConfigConfiguration.SPIDERS.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_giant_spiders = IterConfigConfiguration.SPIDERS.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_geodrill_time = (double) IterConfigConfiguration.GEODRILL_TIME.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_goblinspawner_time = (double) IterConfigConfiguration.GOBLIN_SPAWNER_CYCLE.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_events = IterConfigConfiguration.EVENTS.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_coins_drop = IterConfigConfiguration.COIN_DROP.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_skies_of_ruin = IterConfigConfiguration.SKIES_OF_RUIN.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).config_skies_of_ruin_repeatable = IterConfigConfiguration.SKIES_OF_RUIN_REPEATABLE.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).event_duration = (double) IterConfigConfiguration.EVENT_DURATION.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).event_mintime = (double) IterConfigConfiguration.EVENT_MINTIME.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).event_maxtime = (double) IterConfigConfiguration.EVENT_MAXTIME.get();
		IterRpgModVariables.MapVariables.get(world).syncData(world);
	}
}
