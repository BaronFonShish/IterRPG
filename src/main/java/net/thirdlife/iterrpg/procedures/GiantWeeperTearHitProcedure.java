package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class GiantWeeperTearHitProcedure {
	public static void execute(LevelAccessor world, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), (immediatesourceentity.getX()), (immediatesourceentity.getY() + 0.1), (immediatesourceentity.getZ()), 16, 0.16, 0.16, 0.16, 0.16);
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
