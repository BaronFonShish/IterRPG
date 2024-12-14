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
	public static void execute(LevelAccessor world, double y, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = IterRpgModEntities.DEMONSPINE.get().spawn(_serverLevel, BlockPos.containing((immediatesourceentity.getX()), (y + 1), (immediatesourceentity.getZ())), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
			}
			(entitytospawn).getPersistentData().putBoolean("friendly", true);
			(entitytospawn).getPersistentData().putDouble("damage", 2);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), (immediatesourceentity.getX()), (immediatesourceentity.getY() + 0.1), (immediatesourceentity.getZ()), 16, 0, 0, 0, 0.032);
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
