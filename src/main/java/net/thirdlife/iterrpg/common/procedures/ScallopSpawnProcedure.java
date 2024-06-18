package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.entity.ScallopEntity;

import net.minecraft.world.entity.Entity;

public class ScallopSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() >= 0.9) {
			if (entity instanceof ScallopEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ScallopEntity.DATA_has_pearl, true);
		} else {
			if (entity instanceof ScallopEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ScallopEntity.DATA_has_pearl, false);
		}
	}
}
