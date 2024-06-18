package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class ReleaseSpiderlingsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 4); index0++) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 6, 0.2, 0.2, 0.2, 0.025);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.SPIDERLING.get().spawn(_level,
						BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -0.32, 0.32), y + Mth.nextDouble(RandomSource.create(), 0.16, 0.32), z + Mth.nextDouble(RandomSource.create(), -0.32, 0.32)), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
