package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class AirElementalPoofProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, (y + entity.getBbHeight() / 2), z, 1, 0.2, 0.2, 0.2, 0);
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, (y + entity.getBbHeight() / 2), z, 1, 0.2, 0.2, 0.2, 0.01);
		}
	}
}
