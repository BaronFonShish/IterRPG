package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class RockHitProcedure {
	public static void execute(LevelAccessor world, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		double damage = 0;
		double distance = 0;
		boolean hit = false;
		boolean particle = false;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ASH, (immediatesourceentity.getX()), (immediatesourceentity.getY() + 0.1), (immediatesourceentity.getZ()), 4, 0, 0, 0, 0.025);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CRIT, (immediatesourceentity.getX()), (immediatesourceentity.getY() + 0.1), (immediatesourceentity.getZ()), 4, 0, 0, 0, 0.025);
	}
}
