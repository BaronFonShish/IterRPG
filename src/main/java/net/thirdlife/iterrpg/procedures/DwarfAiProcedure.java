package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class DwarfAiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("trading") > 0) {
			entity.getPersistentData().putDouble("trading", (entity.getPersistentData().getDouble("trading") - 1));
		}
	}
}
