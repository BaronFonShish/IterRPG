package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class MarrowParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0);
	}
}
