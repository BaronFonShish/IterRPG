package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class WalkOnCloudProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.isSprinting() || entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 0.05, 0.1, 0.025);
		}
	}
}
