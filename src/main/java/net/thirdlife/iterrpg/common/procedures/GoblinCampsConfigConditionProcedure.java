package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.network.IterRpgModVariables;

import net.minecraft.world.level.LevelAccessor;

import java.io.File;

public class GoblinCampsConfigConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		File configfile = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		com.google.gson.JsonObject goblins = new com.google.gson.JsonObject();
		com.google.gson.JsonObject magic = new com.google.gson.JsonObject();
		com.google.gson.JsonObject mobs = new com.google.gson.JsonObject();
		com.google.gson.JsonObject generation = new com.google.gson.JsonObject();
		com.google.gson.JsonObject functions = new com.google.gson.JsonObject();
		com.google.gson.JsonObject checkfor = new com.google.gson.JsonObject();
		boolean flag = false;
		return IterRpgModVariables.MapVariables.get(world).config_goblin_camps;
	}
}
