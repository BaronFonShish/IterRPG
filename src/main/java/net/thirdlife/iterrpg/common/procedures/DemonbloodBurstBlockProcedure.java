package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class DemonbloodBurstBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		DemonbloodBurstProcedure.execute(world, (x + 0.5), (y + 0.5), (z + 0.5), immediatesourceentity);
	}
}
