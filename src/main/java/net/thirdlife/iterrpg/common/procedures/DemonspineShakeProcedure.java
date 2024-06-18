package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.entity.Entity;

public class DemonspineShakeProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("ascend") > 0) {
			return true;
		}
		return false;
	}
}
