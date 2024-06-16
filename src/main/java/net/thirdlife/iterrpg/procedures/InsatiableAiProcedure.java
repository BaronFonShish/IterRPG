package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.ScallopEntity;
import net.thirdlife.iterrpg.entity.InsatiableEntity;
import net.thirdlife.iterrpg.entity.DropletProjectileProjectileEntity;
import net.thirdlife.iterrpg.entity.CaltropThrownEntity;
import net.thirdlife.iterrpg.entity.BloatedEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class InsatiableAiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean shouldvomit = false;
		boolean divetp = false;
		boolean shouldtick = false;
		boolean shoulddive = false;
		double yiter = 0;
		double xiter = 0;
		double ziter = 0;
		double xentity = 0;
		double yentity = 0;
		double zentity = 0;
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		double decide = 0;
		double mobamount = 0;
		double power = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
				}
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() || world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude()) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + 0.25), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 0.25), z, _ent.getYRot(), _ent.getXRot());
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof CaltropThrownEntity) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 8);
				}
			}
		}
		if (entity.getPersistentData().getDouble("timer") >= entity.getPersistentData().getDouble("cooldown")) {
			entity.getPersistentData().putDouble("timer", 0);
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
				if (entity.getPersistentData().getDouble("decide") == 0) {
					entity.getPersistentData().putDouble("decide", 1);
					entity.getPersistentData().putBoolean("vomitAttack", true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4, false, false));
					if (entity instanceof InsatiableEntity) {
						((InsatiableEntity) entity).setAnimation("animation.insatiable.vomit");
					}
					entity.getPersistentData().putDouble("cooldown", 64);
				} else if (entity.getPersistentData().getDouble("decide") == 1) {
					entity.getPersistentData().putDouble("decide", 2);
					if (false || (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:dirt"))) || false || false
							|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:animals_spawnable_on")))
							|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:sand")))) {
						shoulddive = false;
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
									shoulddive = true;
								}
							}
						}
						if (shoulddive == true) {
							xentity = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX();
							yentity = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY();
							zentity = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ();
							entity.getPersistentData().putBoolean("diveState", true);
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 36, 4, false, false));
							if (entity instanceof InsatiableEntity) {
								((InsatiableEntity) entity).setAnimation("animation.insatiable.dive-in");
							}
							entity.getPersistentData().putDouble("cooldown", 80);
						}
					} else {
						entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 1.5), 0.16, (entity.getLookAngle().z * 1.5)));
						entity.getPersistentData().putDouble("decide", 2);
						entity.getPersistentData().putDouble("cooldown", 16);
					}
				} else if (entity.getPersistentData().getDouble("decide") == 2) {
					if (entity instanceof InsatiableEntity) {
						((InsatiableEntity) entity).setAnimation("animation.insatiable.throw");
					}
					entity.getPersistentData().putDouble("decide", 3);
					entity.getPersistentData().putBoolean("blobthrow", true);
					entity.getPersistentData().putDouble("cooldown", 32);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4, false, false));
				} else if (entity.getPersistentData().getDouble("decide") == 3) {
					if (entity instanceof InsatiableEntity) {
						((InsatiableEntity) entity).setAnimation("animation.insatiable.blobs");
					}
					entity.getPersistentData().putDouble("decide", 4);
					entity.getPersistentData().putBoolean("blobscatter", true);
					entity.getPersistentData().putDouble("cooldown", 64);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 64, 4, false, false));
				} else if (entity.getPersistentData().getDouble("decide") == 4) {
					entity.getPersistentData().putDouble("decide", 5);
					mobamount = 0;
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof BloatedEntity || entityiterator instanceof ScallopEntity || entityiterator instanceof Drowned) {
								mobamount = mobamount + 1;
							}
						}
					}
					if (mobamount < 3) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = IterRpgModEntities.BLOATED.get().spawn(_serverLevel, BlockPos.containing(x, (y + 0.16), z), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
							}
							(entitytospawn).setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.16, 0.16)), (Mth.nextDouble(RandomSource.create(), 0, 0.25)), (Mth.nextDouble(RandomSource.create(), -0.16, 0.16))));
						}
						for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 2); index0++) {
							if (world instanceof ServerLevel _serverLevel) {
								Entity entitytospawn = EntityType.DROWNED.spawn(_serverLevel, BlockPos.containing(x, (y + 0.16), z), MobSpawnType.MOB_SUMMONED);
								if (entitytospawn != null) {
									entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
								}
								(entitytospawn).setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.16, 0.16)), (Mth.nextDouble(RandomSource.create(), 0, 0.25)), (Mth.nextDouble(RandomSource.create(), -0.16, 0.16))));
							}
						}
					}
				} else {
					entity.getPersistentData().putDouble("decide", 0);
					entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 1.5), 0.16, (entity.getLookAngle().z * 1.5)));
					entity.getPersistentData().putDouble("cooldown", 16);
				}
			}
		}
		if (entity.getPersistentData().getBoolean("vomitAttack") == true) {
			entity.getPersistentData().putBoolean("blobthrow", false);
			entity.getPersistentData().putBoolean("blobscatter", false);
			entity.getPersistentData().putBoolean("diveState", false);
			entity.getPersistentData().putDouble("frame", (entity.getPersistentData().getDouble("frame") + 1));
			if (entity.getPersistentData().getDouble("frame") >= 17) {
				entity.getPersistentData().putDouble("frame", 0);
				entity.getPersistentData().putBoolean("vomitAttack", false);
				for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 5, 6); index1++) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new DropletProjectileProjectileEntity(IterRpgModEntities.DROPLET_PROJECTILE_PROJECTILE.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 6, 0);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) Mth.nextDouble(RandomSource.create(), 1, 2), 8);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getBoolean("diveState") == true) {
			entity.getPersistentData().putBoolean("vomitAttack", false);
			entity.getPersistentData().putBoolean("blobthrow", false);
			entity.getPersistentData().putBoolean("blobscatter", false);
			entity.getPersistentData().putDouble("frame", (entity.getPersistentData().getDouble("frame") + 1));
			if (entity.getPersistentData().getDouble("frame") == 30) {
				for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 8, 12); index2++) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback) {
								AbstractArrow entityToSpawn = new DropletProjectileProjectileEntity(IterRpgModEntities.DROPLET_PROJECTILE_PROJECTILE.get(), level);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 6, 0);
						_entityToSpawn.setPos(x, y, z);
						_entityToSpawn.shoot(0, 1, 0, (float) Mth.nextDouble(RandomSource.create(), 0.3, 0.8), 50);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
			if (entity.getPersistentData().getDouble("frame") == 32) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 32, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4, false, false));
			}
			if (entity.getPersistentData().getDouble("frame") == 36) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
							{
								Entity _ent = entity;
								_ent.teleportTo((entity.getX() + ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.75),
										((entity.getY() + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()) / 2),
										(entity.getZ() + ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.75));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entity.getX() + ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.75),
											((entity.getY() + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()) / 2),
											(entity.getZ() + ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.75), _ent.getYRot(), _ent.getXRot());
							}
						}
					}
				}
			}
			if (entity.getPersistentData().getDouble("frame") >= 48) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.INVISIBILITY);
				if (entity instanceof InsatiableEntity) {
					((InsatiableEntity) entity).setAnimation("animation.insatiable.dive-out");
				}
				for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 8, 12); index3++) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback) {
								AbstractArrow entityToSpawn = new DropletProjectileProjectileEntity(IterRpgModEntities.DROPLET_PROJECTILE_PROJECTILE.get(), level);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 6, 0);
						_entityToSpawn.setPos(x, y, z);
						_entityToSpawn.shoot(0, 1, 0, (float) Mth.nextDouble(RandomSource.create(), 0.3, 0.8), 50);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				entity.getPersistentData().putBoolean("diveState", false);
				entity.getPersistentData().putDouble("frame", 0);
			}
		}
		if (entity.getPersistentData().getBoolean("blobthrow") == true) {
			entity.getPersistentData().putBoolean("diveState", false);
			entity.getPersistentData().putBoolean("vomitAttack", false);
			entity.getPersistentData().putBoolean("blobscatter", false);
			entity.getPersistentData().putDouble("frame", (entity.getPersistentData().getDouble("frame") + 1));
			if (entity.getPersistentData().getDouble("frame") >= 12) {
				entity.getPersistentData().putDouble("frame", 0);
				entity.getPersistentData().putBoolean("blobthrow", false);
				if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = IterRpgModEntities.SCALLOP.get().spawn(_level, BlockPos.containing(x, y + 0.9, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement((entity.getLookAngle().x * 1.5), (entity.getLookAngle().y * 1.5), (entity.getLookAngle().z * 1.5));
						}
					}
				} else {
					power = 1;
					for (int index4 = 0; index4 < 5; index4++) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = IterRpgModEntities.BLOB.get().spawn(_serverLevel, BlockPos.containing(x, (y + 0.9), z), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
							}
							(entitytospawn).setDeltaMovement(new Vec3((entity.getLookAngle().x * power * Mth.nextInt(RandomSource.create(), (int) 0.85, (int) 1.15)),
									(entity.getLookAngle().y * power * Mth.nextInt(RandomSource.create(), (int) 0.85, (int) 1.15)), (entity.getLookAngle().z * power * Mth.nextInt(RandomSource.create(), (int) 0.85, (int) 1.15))));
							(entitytospawn).getPersistentData().putBoolean("IsFriendly", false);
							(entitytospawn).getPersistentData().putString("owner", (entity.getStringUUID()));
							(entitytospawn).getPersistentData().putDouble("deathtime", (Mth.nextInt(RandomSource.create(), 48, 64)));
						}
						power = power + 1;
					}
				}
			}
		}
		if (entity.getPersistentData().getBoolean("blobscatter") == true) {
			entity.getPersistentData().putBoolean("diveState", false);
			entity.getPersistentData().putBoolean("vomitAttack", false);
			entity.getPersistentData().putBoolean("blobthrow", false);
			entity.getPersistentData().putDouble("frame", (entity.getPersistentData().getDouble("frame") + 1));
			if (entity.getPersistentData().getDouble("frame") >= 28) {
				entity.getPersistentData().putDouble("frame", 0);
				entity.getPersistentData().putBoolean("blobscatter", false);
				for (int index5 = 0; index5 < 16; index5++) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entitytospawn = IterRpgModEntities.BLOB.get().spawn(_serverLevel, BlockPos.containing(x, (y + 0.9), z), MobSpawnType.MOB_SUMMONED);
						if (entitytospawn != null) {
							entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						}
						(entitytospawn).setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -1.25, 1.25)), (Mth.nextDouble(RandomSource.create(), 1, 2)), (Mth.nextDouble(RandomSource.create(), -1.25, 1.25))));
						(entitytospawn).getPersistentData().putBoolean("IsFriendly", false);
						(entitytospawn).getPersistentData().putString("owner", (entity.getStringUUID()));
						(entitytospawn).getPersistentData().putDouble("deathtime", (Mth.nextInt(RandomSource.create(), 64, 128)));
					}
				}
			}
		}
	}
}
