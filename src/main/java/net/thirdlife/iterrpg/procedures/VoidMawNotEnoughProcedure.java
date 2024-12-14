package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class VoidMawNotEnoughProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !VoidMawEnoughConditionProcedure.execute(entity);
	}
}
