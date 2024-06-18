package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class SummonSpinesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double attack = 0;
		double timer = 0;
		double particle = 0;
		double fireforce = 0;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double yspawn = 0;
		boolean shouldtick = false;
		boolean shouldspawn = false;
		for (int index0 = 0; index0 < 8; index0++) {
			xpos = Mth.nextDouble(RandomSource.create(), -4, 4);
			ypos = -4;
			zpos = Mth.nextDouble(RandomSource.create(), -4, 4);
			shouldspawn = false;
			for (int index1 = 0; index1 < 8; index1++) {
				if (world.isEmptyBlock(BlockPos.containing(x + xpos, Math.round(y + ypos), z + zpos)) && world.getBlockState(BlockPos.containing(x + xpos, Math.round((y + ypos) - 1), z + zpos)).canOcclude()) {
					yspawn = ypos;
					shouldspawn = true;
				}
				ypos = ypos + 1;
			}
			if (shouldspawn == true) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.DEMONSPINE.get().spawn(_level, BlockPos.containing(x + xpos, Math.round(y + yspawn), z + zpos), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
	}
}
