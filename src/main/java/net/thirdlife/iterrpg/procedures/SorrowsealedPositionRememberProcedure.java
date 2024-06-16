package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class SorrowsealedPositionRememberProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("brainX", (entity.getX()));
		entity.getPersistentData().putDouble("brainY", (entity.getY()));
		entity.getPersistentData().putDouble("brainZ", (entity.getZ()));
	}
}
