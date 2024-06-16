package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.level.LevelAccessor;

public class FireElementalSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double count = 0;
		if (ElementalsSpawnConditionProcedure.execute(world, x, y, z) && IterRpgModVariables.MapVariables.get(world).unlocked_fire) {
			return true;
		}
		return false;
	}
}
