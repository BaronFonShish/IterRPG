package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class GrieverShakeProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("screamTime") >= 1200) {
			return false;
		}
		return true;
	}
}
