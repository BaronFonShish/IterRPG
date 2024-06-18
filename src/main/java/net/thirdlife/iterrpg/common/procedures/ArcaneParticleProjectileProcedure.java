package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class ArcaneParticleProjectileProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ARCANE_PARTICLE.get()), x, y, z, 1, 0, 0, 0, 0.01);
		immediatesourceentity.setNoGravity(true);
	}
}
