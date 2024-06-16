package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class BlobTransparentProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double chance = 0;
		chance = entity.getPersistentData().getDouble("deathtime");
		if (entity.getPersistentData().getDouble("timer") >= chance * 0.75 && entity.getPersistentData().getDouble("timer") >= Mth.nextInt(RandomSource.create(), 1, (int) chance)) {
			return true;
		}
		return false;
	}
}
