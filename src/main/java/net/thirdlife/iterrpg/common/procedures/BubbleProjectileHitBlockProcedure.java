package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class BubbleProjectileHitBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SPLASH, (x + 0.5), (y + 1), (z + 0.5), 8, 0.25, 0.25, 0.25, 0.15);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.BUBBLE_POP, (x + 0.5), (y + 1), (z + 0.5), 4, 0.25, 0.25, 0.25, 0.15);
	}
}
