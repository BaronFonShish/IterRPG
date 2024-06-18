package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class AuraAssignProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double offset = 0;
		entity.getPersistentData().putDouble("AuraDelay", (Mth.nextInt(RandomSource.create(), 12, 20)));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL, x, (y + 0.25), z, 12, 0.25, 0.2, 0.25, 0.05);
	}
}
