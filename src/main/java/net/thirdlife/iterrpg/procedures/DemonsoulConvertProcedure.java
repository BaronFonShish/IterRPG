package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class DemonsoulConvertProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Skeleton) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (!sourceentity.level().isClientSide())
				sourceentity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.REVENANT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, (y + 1), z, 16, 0.5, 0.5, 0.5, 0.25);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, (y + 1), z, 16, 0.5, 0.5, 0.5, 0.25);
		} else if (entity instanceof Stray) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (!sourceentity.level().isClientSide())
				sourceentity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.REVENANT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, (y + 1), z, 16, 0.5, 0.5, 0.5, 0.25);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, (y + 1), z, 16, 0.5, 0.5, 0.5, 0.25);
		} else if (entity instanceof WitherSkeleton) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (!sourceentity.level().isClientSide())
				sourceentity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, (y + 1), z, 16, 0.5, 0.5, 0.5, 0.25);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, (y + 1), z, 16, 0.5, 0.5, 0.5, 0.25);
		}
	}
}
