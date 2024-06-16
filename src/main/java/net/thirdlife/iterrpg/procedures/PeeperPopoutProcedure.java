package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModGameRules;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PeeperPopoutProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty() && !world.getLevelData().getGameRules().getBoolean(IterRpgModGameRules.BUILDINGDEBUG)
				&& !(world.getDifficulty() == Difficulty.PEACEFUL)) {
			if (Mth.nextInt(RandomSource.create(), 1, 16) == 8) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.POOF, (x + 0.5), (y + 0.5), (z + 0.5), 8, 0.15, 0.15, 0.15, 0.025);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.PEEPER.get().spawn(_level, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setXRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
						entityToSpawn.setDeltaMovement(0, 0.32, 0);
					}
				}
			}
		}
	}
}
