package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GoblinCampsConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() instanceof LiquidBlock || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() instanceof LiquidBlock
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() instanceof LiquidBlock) && GoblinCampsConfigConditionProcedure.execute(world)) {
			return true;
		}
		return false;
	}
}
