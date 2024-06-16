package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class MobspawnAuraProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double offset = 0;
		double mobdecide = 0;
		if (entity.getPersistentData().getDouble("attackTime") >= 50) {
			mobdecide = Mth.nextInt(RandomSource.create(), 1, 3);
			if (mobdecide == 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.GRIEVER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			if (mobdecide == 2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.MOURNSTONE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			if (mobdecide == 3) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = IterRpgModEntities.WEEPER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + entity.getPersistentData().getDouble("offset")), z, 8, 0.25, (0 + entity.getPersistentData().getDouble("offset") / 2), 0.25, 0.025);
			entity.getPersistentData().putDouble("offset", (entity.getPersistentData().getDouble("offset") + 0.025));
			entity.getPersistentData().putDouble("attackTime", (entity.getPersistentData().getDouble("attackTime") + 1));
		}
	}
}
