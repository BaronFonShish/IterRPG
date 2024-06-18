package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.entity.Entity;

public class HarvestReturnScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double rotation = 0;
		double distance = 0;
		return 0.1 + entity.getPersistentData().getDouble("scale") / 5;
	}
}
