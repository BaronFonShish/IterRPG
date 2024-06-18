package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.entity.Entity;

public class ScallopFriendlyConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !entity.getPersistentData().getBoolean("friendly");
	}
}
