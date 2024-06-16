package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class PearlWandProjectileProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.BUBBLE_POP, x, (y + 0.2), z, 1, 0, 0, 0, 0.05);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SPLASH, x, (y + 0.2), z, 1, 0, 0, 0, 0.05);
	}
}
