package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.HomingBubbleEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

public class HydrabubbleTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean doexplode = false;
		double rotation = 0;
		double distance = 0;
		double explosionpower = 0;
		double power = 0;
		entity.setNoGravity(true);
		doexplode = false;
		entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDouble("time") + 1));
		entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("xvec") * entity.getPersistentData().getDouble("speed") * (1 - entity.getPersistentData().getDouble("time") / entity.getPersistentData().getDouble("lifetime"))),
				(entity.getPersistentData().getDouble("yvec") * entity.getPersistentData().getDouble("speed") * (1 - entity.getPersistentData().getDouble("time") / entity.getPersistentData().getDouble("lifetime"))),
				(entity.getPersistentData().getDouble("zvec") * entity.getPersistentData().getDouble("speed") * (1 - entity.getPersistentData().getDouble("time") / entity.getPersistentData().getDouble("lifetime")))));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FALLING_WATER, x, y, z, 1, 0.25, 0.25, 0.25, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WATER_SIGIL.get()), x, y, z, 1, 0.25, 0.25, 0.25, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_DROPLET.get()), x, y, z, 1, 0.25, 0.25, 0.25, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.BUBBLE, x, y, z, 1, 0.25, 0.25, 0.25, 0);
		if (entity.getPersistentData().getDouble("time") >= entity.getPersistentData().getDouble("lifetime") / 2) {
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, float damage, int knockback) {
						AbstractArrow entityToSpawn = new HomingBubbleEntity(IterRpgModEntities.HOMING_BUBBLE.get(), level);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, (float) (2.5 * entity.getPersistentData().getDouble("power")), 0);
				_entityToSpawn.setPos(x, y, z);
				_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (float) 0.5, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity.getPersistentData().getDouble("time") >= entity.getPersistentData().getDouble("lifetime")) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) 0.1, Level.ExplosionInteraction.NONE);
			for (int index0 = 0; index0 < Math.round(25 * entity.getPersistentData().getDouble("power")); index0++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback) {
							AbstractArrow entityToSpawn = new HomingBubbleEntity(IterRpgModEntities.HOMING_BUBBLE.get(), level);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, (float) (5 * entity.getPersistentData().getDouble("power")), 0);
					_entityToSpawn.setPos(x, y, z);
					_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
