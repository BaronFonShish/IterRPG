package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GenericBlockBreakProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.destroyBlock(BlockPos.containing(x, y, z), false);
	}
}
