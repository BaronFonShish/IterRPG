package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

public class WaterElementalDripProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_DROPLET.get()), x, (y + entity.getBbHeight() / 1.25), z, 1, 0.2, 0.2, 0.2, 0);
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FALLING_WATER, x, (y + entity.getBbHeight() / 1.25), z, 1, 0.2, 0.2, 0.2, 0.01);
		}
	}
}
