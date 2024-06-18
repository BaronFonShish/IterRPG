package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class GiantWeeperTearHitBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), (x + 0.5), (y + 1.25), (z + 0.5), 16, 0.16, 0.16, 0.16, 0.16);
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
