package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class FireballParticleProjectileProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, (y + 0.2), z, 1, 0, 0, 0, 0.001);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.2), z, 1, 0, 0, 0, 0.001);
		if (entity.isInWater()) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.2), z, 4, 0, 0, 0, 0.001);
		}
	}
}
