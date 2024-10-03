package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class HydraSpecialSpellProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = IterRpgModEntities.HYDRA_BUBBLE.get().spawn(_serverLevel, BlockPos.containing(x, (y + 1.5), z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
			}
			(entitytospawn).getPersistentData().putDouble("lifetime", (WandReturnPowerProcedure.execute(entity) * 100));
			(entitytospawn).setDeltaMovement(new Vec3((entity.getLookAngle().x / 4), (entity.getLookAngle().y / 4), (entity.getLookAngle().z / 4)));
			(entitytospawn).setNoGravity(true);
			(entitytospawn).getPersistentData().putDouble("speed", 0.25);
			(entitytospawn).getPersistentData().putDouble("xvec", (entity.getLookAngle().x));
			(entitytospawn).getPersistentData().putDouble("yvec", (entity.getLookAngle().y));
			(entitytospawn).getPersistentData().putDouble("zvec", (entity.getLookAngle().z));
		}
	}
}
