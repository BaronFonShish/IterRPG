package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class FireSealParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double xof = 0;
		double yof = 0;
		double zof = 0;
		if (Math.random() >= 0.6) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.FIRE_SIGIL.get()), (x + 0.5), (y + 0.5), (z + 0.5), 1, 0.4, 0.4, 0.4, 0);
		}
	}
}
