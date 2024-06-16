package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class MarrowHitEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, y, z, 8, 1, 1, 1, 0);
		if (entity.onGround()) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = IterRpgModEntities.DEMONSPINE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				(entitytospawn).getPersistentData().putBoolean("friendly", true);
				(entitytospawn).getPersistentData().putDouble("damage", 2);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, y, z, 16, 0, 0, 0, 0.032);
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, y, z, 8, 0, 0, 0, 0.032);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LAVA, x, y, z, 8, 0, 0, 0, 0.032);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) 1.16, Level.ExplosionInteraction.NONE);
			entity.setSecondsOnFire(6);
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
