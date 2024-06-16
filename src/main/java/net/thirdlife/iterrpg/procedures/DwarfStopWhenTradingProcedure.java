package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class DwarfStopWhenTradingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("trading") > 0) {
			return false;
		}
		return true;
	}
}
