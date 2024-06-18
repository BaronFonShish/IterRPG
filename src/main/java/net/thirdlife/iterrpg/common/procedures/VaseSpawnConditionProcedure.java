package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class VaseSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean check = false;
		if (world.isEmptyBlock(BlockPos.containing(x, y, z)) && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() && y <= 40) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
}
