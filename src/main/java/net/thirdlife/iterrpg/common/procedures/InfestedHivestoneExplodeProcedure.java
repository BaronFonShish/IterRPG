package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class InfestedHivestoneExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 2); index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.SPIDERLING.get().spawn(_level,
						BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), 0.2, 0.8), y + Mth.nextDouble(RandomSource.create(), 0.2, 0.8), z + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level,
						BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), 0.2, 0.8), y + Mth.nextDouble(RandomSource.create(), 0.2, 0.8), z + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else {
			for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 2); index1++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.SILVERFISH.spawn(_level,
							BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), 0.2, 0.8), y + Mth.nextDouble(RandomSource.create(), 0.2, 0.8), z + Mth.nextDouble(RandomSource.create(), 0.2, 0.8)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
	}
}
