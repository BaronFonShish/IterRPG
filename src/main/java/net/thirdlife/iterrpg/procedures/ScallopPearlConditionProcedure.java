package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.ScallopEntity;

import net.minecraft.world.entity.Entity;

public class ScallopPearlConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof ScallopEntity _datEntL0 && _datEntL0.getEntityData().get(ScallopEntity.DATA_has_pearl)) {
			return true;
		}
		return false;
	}
}
