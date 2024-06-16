package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class HookAuraProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean boulderdecide = false;
		boolean aim = false;
		boolean sightline = false;
		double offset = 0;
		double mobdecide = 0;
		double ypos = 0;
		double yfall = 0;
		double distance = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		if (entity.getPersistentData().getDouble("attackTime") >= 75) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = IterRpgModEntities.GRIMHOOK.get().spawn(_serverLevel, BlockPos.containing(x, (entity.getY() + 9), z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				(entitytospawn).getPersistentData().putDouble("xinit", (entity.getX()));
				(entitytospawn).getPersistentData().putDouble("yinit", (entity.getY() + 9));
				(entitytospawn).getPersistentData().putDouble("zinit", (entity.getZ()));
				(entitytospawn).getPersistentData().putDouble("xdest", 0);
				(entitytospawn).getPersistentData().putDouble("ydest", (-7.5));
				(entitytospawn).getPersistentData().putDouble("zdest", 0);
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, (y + 3), z, 5, 0, 2, 0, 0);
			entity.getPersistentData().putDouble("attackTime", (entity.getPersistentData().getDouble("attackTime") + 1));
		}
	}
}
