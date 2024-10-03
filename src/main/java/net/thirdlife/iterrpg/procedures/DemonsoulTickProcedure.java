package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.FlameboltEntity;
import net.thirdlife.iterrpg.entity.EmberProjEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class DemonsoulTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double xdir = 0;
		double ydir = 0;
		double zdir = 0;
		double abs = 0;
		double xort = 0;
		double yort = 0;
		double zort = 0;
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, (y + 0.25), z, 1, 0.2, 0.2, 0.2, 0.025);
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEM_FLAME.get()), x, (y + 0.25), z, 1, 0.2, 0.2, 0.2, 0.025);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.25), z, 1, 0.2, 0.2, 0.2, 0.025);
		if (entity.getPersistentData().getDouble("reload") < Mth.nextInt(RandomSource.create(), 80, 120)) {
			entity.getPersistentData().putDouble("reload", (entity.getPersistentData().getDouble("reload") + 1));
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) && (entity instanceof LivingEntity _entity ? _entity.hasLineOfSight(entityiterator) : false)) {
						entity.getPersistentData().putDouble("reload", 0);
						entity.getPersistentData().putDouble("xtarget", (entityiterator.getX()));
						entity.getPersistentData().putDouble("ytarget", (entityiterator.getY() + entityiterator.getBbHeight() * 0.75));
						entity.getPersistentData().putDouble("ztarget", (entityiterator.getZ()));
						if ((entityiterator != null ? entity.distanceTo(entityiterator) : -1) <= 8) {
							entity.getPersistentData().putDouble("charges", 10);
							entity.getPersistentData().putDouble("projectile", 1);
						} else {
							entity.getPersistentData().putDouble("charges", 1);
							entity.getPersistentData().putDouble("projectile", 2);
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("charges") > 0) {
			entity.getPersistentData().putDouble("charges", (entity.getPersistentData().getDouble("charges") - 1));
			xdir = entity.getPersistentData().getDouble("xtarget") - entity.getX();
			ydir = entity.getPersistentData().getDouble("ytarget") - (entity.getY() + entity.getBbHeight() * 0.1);
			zdir = entity.getPersistentData().getDouble("ztarget") - entity.getZ();
			abs = Math.abs(xdir) + Math.abs(ydir) + Math.abs(zdir);
			xort = xdir / abs;
			yort = ydir / abs;
			zort = zdir / abs;
			if (entity.getPersistentData().getDouble("projectile") == 1) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new EmberProjEntity(IterRpgModEntities.EMBER_PROJ.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) 0.5, 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + entity.getBbHeight() * 0.1), (entity.getZ()));
					_entityToSpawn.shoot(xort, yort, zort, (float) 0.5, 20);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new FlameboltEntity(IterRpgModEntities.FLAMEBOLT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 1, 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + entity.getBbHeight() * 0.1), (entity.getZ()));
					_entityToSpawn.shoot(xort, yort, zort, (float) 0.75, (float) 2.5);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
	}
}
