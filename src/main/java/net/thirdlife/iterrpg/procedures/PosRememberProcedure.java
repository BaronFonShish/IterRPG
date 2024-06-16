package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class PosRememberProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("brainX", x);
		entity.getPersistentData().putDouble("brainY", y);
		entity.getPersistentData().putDouble("brainZ", z);
	}
}
