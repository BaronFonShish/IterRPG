package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.WindswirlEntity;

import net.minecraft.world.entity.Entity;

public class WindswirlReturnScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double xvec = 0;
		double yvec = 0;
		double zvec = 0;
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		double k = 0;
		return entity instanceof WindswirlEntity _datEntI ? _datEntI.getEntityData().get(WindswirlEntity.DATA_scale) : 0;
	}
}
