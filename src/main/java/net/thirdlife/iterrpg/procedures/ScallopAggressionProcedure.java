package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.ScallopEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class ScallopAggressionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double failchance = 0;
		if (entity.getPersistentData().getDouble("aggression") > 0) {
			entity.getPersistentData().putDouble("aggression", (entity.getPersistentData().getDouble("aggression") - 1));
		}
		if (entity.getPersistentData().getDouble("pearlgrow") > Mth.nextInt(RandomSource.create(), 120000, 200000)) {
			if (entity instanceof ScallopEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ScallopEntity.DATA_has_pearl, true);
			entity.getPersistentData().putDouble("pearlgrow", 0);
		} else {
			entity.getPersistentData().putDouble("pearlgrow", (entity.getPersistentData().getDouble("pearlgrow") + 1));
		}
	}
}
