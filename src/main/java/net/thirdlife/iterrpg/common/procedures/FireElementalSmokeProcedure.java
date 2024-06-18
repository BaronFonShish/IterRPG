package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.common.entity.FireballProjectileProjectileEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class FireElementalSmokeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean shouldattack = false;
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		double decide = 0;
		if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + entity.getBbHeight() / 2), z, 1, 0.2, 0.5, 0.2, 0);
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, (y + entity.getBbHeight() / 2), z, 1, 0.2, 0.5, 0.2, 0.01);
		}
		WaterDamageProcedure.execute(world, entity);
		ElementalFlightBehaviourProcedure.execute(world, x, y, z, entity);
		if (entity.getPersistentData().getDouble("attack") >= 80) {
			entity.getPersistentData().putDouble("attack", 0);
			if (entity.getPersistentData().getDouble("attacktype") >= 2) {
				entity.getPersistentData().putDouble("burningground", 60);
				entity.getPersistentData().putDouble("attacktype", 0);
			} else {
				if (entity.getPersistentData().getDouble("attacktype") == 0) {
					for (int index0 = 0; index0 < 5; index0++) {
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, float damage, int knockback) {
										AbstractArrow entityToSpawn = new FireballProjectileProjectileEntity(IterRpgModEntities.FIREBALL_PROJECTILE_PROJECTILE.get(), level);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setSecondsOnFire(100);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, 5, 0);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 25);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
					}
				} else if (entity.getPersistentData().getDouble("attacktype") == 1) {
					for (int index1 = 0; index1 < 8; index1++) {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new FireballProjectileProjectileEntity(IterRpgModEntities.FIREBALL_PROJECTILE_PROJECTILE.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setSecondsOnFire(100);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 5, 0);
							_entityToSpawn.setPos((entity.getX()), (entity.getY()), (entity.getZ()));
							_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (Mth.nextDouble(RandomSource.create(), 0.5, 1)), (Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (float) 0.4, 15);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
				entity.getPersistentData().putDouble("attacktype", (entity.getPersistentData().getDouble("attacktype") + 1));
			}
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
						shouldattack = true;
					}
				}
			}
			if (shouldattack) {
				entity.getPersistentData().putDouble("attack", (entity.getPersistentData().getDouble("attack") + 1));
			}
		}
		if (entity.getPersistentData().getDouble("burningground") >= 1) {
			entity.setDeltaMovement(new Vec3((entity.getLookAngle().x / 4), (-0.25), (entity.getLookAngle().z / 4)));
			if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))
					&& world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())).isFaceSturdy(world, BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()), Direction.UP)) {
				world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Blocks.FIRE.defaultBlockState(), 3);
			}
			entity.getPersistentData().putDouble("burningground", (entity.getPersistentData().getDouble("burningground") - 1));
		}
	}
}
