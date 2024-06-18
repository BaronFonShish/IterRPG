package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class BoulderAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean boulderdecide = false;
		double offset = 0;
		double mobdecide = 0;
		double ypos = 0;
		double yfall = 0;
		if (entity.getPersistentData().getDouble("attackTime") <= 64) {
			if (entity.getPersistentData().getDouble("AuraDelay") <= 0) {
				entity.getPersistentData().putDouble("attackTime", (entity.getPersistentData().getDouble("attackTime") + 1));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL, x, (y + entity.getPersistentData().getDouble("offset")), z, 4, (entity.getPersistentData().getDouble("offset")), 0.25, (entity.getPersistentData().getDouble("offset")), 0.025);
				entity.getPersistentData().putDouble("offset", (entity.getPersistentData().getDouble("offset") - 0.01));
				if (entity.getPersistentData().getDouble("attackTime") == 50) {
					ypos = y + 1;
					boulderdecide = false;
					for (int index0 = 0; index0 < 16; index0++) {
						if (!world.isEmptyBlock(BlockPos.containing(x, ypos, z))) {
							if (boulderdecide == false) {
								boulderdecide = true;
								yfall = ypos - 2;
							}
						} else if (boulderdecide == false) {
							ypos = ypos + 1;
						}
					}
					if (boulderdecide == false) {
						yfall = y + 16;
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = IterRpgModEntities.GRIM_BOULDER.get().spawn(_level, BlockPos.containing(x, yfall, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("AuraDelay", (entity.getPersistentData().getDouble("AuraDelay") - 1));
				offset = 2;
			}
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
