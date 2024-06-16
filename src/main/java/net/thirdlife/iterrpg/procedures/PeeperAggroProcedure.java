package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class PeeperAggroProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("aggro") >= 128) {
			return true;
		}
		return false;
	}
}
