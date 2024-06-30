package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class EmberTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMALL_FLAME, x, y, z, 1, 0, 0, 0, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 1, 0, 0, 0, 0.01);
		immediatesourceentity.setNoGravity(true);
		if (immediatesourceentity.getPersistentData().getDouble("lifetime") >= Mth.nextInt(RandomSource.create(), 15, 20)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 6, 0, 0, 0, 0.05);
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		immediatesourceentity.getPersistentData().putDouble("lifetime", (immediatesourceentity.getPersistentData().getDouble("lifetime") + 1));
		immediatesourceentity.setDeltaMovement(new Vec3(((immediatesourceentity.getDeltaMovement().x() + Mth.nextDouble(RandomSource.create(), -0.075, 0.075)) * 0.95),
				((immediatesourceentity.getDeltaMovement().y() + Mth.nextDouble(RandomSource.create(), -0.1, 0.05)) * 0.95), ((immediatesourceentity.getDeltaMovement().z() + Mth.nextDouble(RandomSource.create(), -0.075, 0.075)) * 0.95)));
	}
}
