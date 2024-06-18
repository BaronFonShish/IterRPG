package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class UndergroundConditionAirProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean check = false;
		if (y <= 48 && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() instanceof LiquidBlock)) {
			return true;
		}
		return false;
	}
}
