package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class GoblinsCampRememberProcedure {
	public static void execute(double x, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("xcord", x);
		entity.getPersistentData().putDouble("zcord", z);
	}
}
