package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.LevelAccessor;

public class TwiffleFunctionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		TwiffleNutrientsProcedure.execute(world, x, y, z);
		TwiffleMoistureProcedure.execute(world, x, y, z);
		TwiffleShareProcedure.execute(world, x, y, z);
		TwiffleGrowProcedure.execute(world, x, y, z);
	}
}
