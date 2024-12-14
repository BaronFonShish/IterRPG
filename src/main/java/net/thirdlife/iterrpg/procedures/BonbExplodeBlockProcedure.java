package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class BonbExplodeBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		double damage = 0;
		double distance = 0;
		boolean hit = false;
		boolean particle = false;
		BonbExplodeProcedure.execute(world, immediatesourceentity);
	}
}
