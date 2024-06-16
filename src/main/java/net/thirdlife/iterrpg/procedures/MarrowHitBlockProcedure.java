package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class MarrowHitBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, y, z, 8, 1, 1, 1, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, y, z, 16, 0, 0, 0, 0.032);
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = IterRpgModEntities.DEMONSPINE.get().spawn(_serverLevel, BlockPos.containing((x + 0.5), (y + 1), (z + 0.5)), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
			}
			(entitytospawn).getPersistentData().putBoolean("friendly", true);
			(entitytospawn).getPersistentData().putDouble("damage", 2);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, y, z, 16, 0, 0, 0, 0.032);
	}
}
