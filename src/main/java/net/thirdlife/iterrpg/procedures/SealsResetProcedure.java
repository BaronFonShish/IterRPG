package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.level.LevelAccessor;

public class SealsResetProcedure {
	public static void execute(LevelAccessor world) {
		double distance = 0;
		double xof = 0;
		double yof = 0;
		double zof = 0;
		IterRpgModVariables.MapVariables.get(world).unlocked_earth = false;
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).unlocked_water = false;
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).unlocked_air = false;
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).unlocked_fire = false;
		IterRpgModVariables.MapVariables.get(world).syncData(world);
		IterRpgModVariables.MapVariables.get(world).unlocked_void = false;
		IterRpgModVariables.MapVariables.get(world).syncData(world);
	}
}
