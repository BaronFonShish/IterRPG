package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;

public class PebbleheadAiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double attacktype = 0;
		double distance = 0;
		double rotation = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double attachx = 0;
		double attachy = 0;
		double attachz = 0;
		double dist = 0;
		boolean doattack = false;
		boolean found = false;
		boolean entityhost = false;
		boolean chaindisplay = false;
		if (entity.isAlive()) {
			if (entity.getPersistentData().getDouble("timer") <= -5) {
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") - 1));
			}
		}
	}
}
