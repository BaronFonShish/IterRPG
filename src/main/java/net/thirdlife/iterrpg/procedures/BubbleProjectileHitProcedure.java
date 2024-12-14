package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class BubbleProjectileHitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SPLASH, (immediatesourceentity.getX()), (immediatesourceentity.getY() + 0.1), (immediatesourceentity.getZ()), 8, 0.1, 0.1, 0.1, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.BUBBLE_POP, (immediatesourceentity.getX()), (immediatesourceentity.getY() + 0.1), (immediatesourceentity.getZ()), 4, 0.1, 0.1, 0.1, 0.01);
		entity.clearFire();
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
