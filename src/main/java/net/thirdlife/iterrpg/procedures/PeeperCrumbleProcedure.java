package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PeeperCrumbleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 2); index0++) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 4, 0.2, 0.2, 0.2, 0.025);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.SILVERFISH.spawn(_level,
						BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -0.2, 0.2), y + Mth.nextDouble(RandomSource.create(), 0.3, 0.6), z + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 2); index1++) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ASH, x, (y + 1), z, 16, 0.3, 0.3, 0.3, 0.025);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.SPIDERLING.get().spawn(_level,
						BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -0.2, 0.2), y + Mth.nextDouble(RandomSource.create(), 0.3, 0.6), z + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
