package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class CoinTimerProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean agr = false;
		if (entity.getPersistentData().getDouble("otcup") >= 1 && entity.getPersistentData().getDouble("war") <= 1) {
			return false;
		}
		return true;
	}
}
