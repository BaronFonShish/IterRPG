package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class CocoonExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = IterRpgModEntities.SPIDERLING.get().spawn(_level,
					BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), 0.3, 0.7), y + Mth.nextDouble(RandomSource.create(), 0.3, 0.7), z + Mth.nextDouble(RandomSource.create(), 0.3, 0.7)), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
	}
}
