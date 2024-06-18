package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.entity.Entity;

public class EarthBoulderSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		double k = 0;
		entity.getPersistentData().putDouble("ascend", 3.5);
		entity.getPersistentData().putDouble("lifetime", 0);
	}
}
