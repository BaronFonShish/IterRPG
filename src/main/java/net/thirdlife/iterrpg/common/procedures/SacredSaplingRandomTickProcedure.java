package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SacredSaplingRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() >= 0.875) {
			SacredSaplingGrowProcedure.execute(world, x, y, z);
		}
	}
}
