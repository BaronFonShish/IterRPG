package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.common.entity.WeeperEntity;
import net.thirdlife.iterrpg.common.entity.MournstoneEntity;
import net.thirdlife.iterrpg.common.entity.HomingTearEntity;
import net.thirdlife.iterrpg.common.entity.GrieverEntity;
import net.thirdlife.iterrpg.common.entity.AuraMobspawnEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.Comparator;

public class SorrowsealedAIProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity auraselect = null;
		boolean dospawn = false;
		boolean doattack = false;
		boolean shoudattack = false;
		boolean attack = false;
		double auraposx = 0;
		double auraposz = 0;
		double auraposy = 0;
		double attackType = 0;
		double ycheck = 0;
		double specialattack = 0;
		double attacktrigger = 0;
		double ypos = 0;
		double distance = 0;
		double yfinal = 0;
		double mobcount = 0;
		double aurarand = 0;
		double repeatnum = 0;
		double amount = 0;
		double offset = 0;
		double dist = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double dist2 = 0;
		{
			final Vec3 _center = new Vec3(x, (y + 2), z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof Player) && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies")))) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 2);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, (y + 2), z, 16, 3, 3, 3, 0);
					entityiterator.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -2, 2)), 0.025, (Mth.nextDouble(RandomSource.create(), -2, 2))));
				}
			}
		}
		if (entity.getPersistentData().getDouble("attackCooldown") >= 100) {
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getPersistentData().getDouble("brainX")), (entity.getPersistentData().getDouble("brainY")), (entity.getPersistentData().getDouble("brainZ")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("brainX")), (entity.getPersistentData().getDouble("brainY")), (entity.getPersistentData().getDouble("brainZ")), _ent.getYRot(), _ent.getXRot());
			}
			if (entity.getPersistentData().getDouble("attacktype") > 5) {
				entity.getPersistentData().putDouble("attacktype", 0);
			} else {
				entity.getPersistentData().putDouble("attacktype", (entity.getPersistentData().getDouble("attacktype") + 1));
			}
			if (entity.getPersistentData().getDouble("attacktype") == 1) {
				shoudattack = true;
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player && (new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entityiterator) || new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
								}
								return false;
							}
						}.checkGamemode(entityiterator)) || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies")))) {
							if (shoudattack == true) {
								shoudattack = false;
								for (int index0 = 0; index0 < 16; index0++) {
									AuraSummonFireProcedure.execute(world, (entityiterator.getX() + Mth.nextDouble(RandomSource.create(), -5, 5)), (entityiterator.getY()), (entityiterator.getZ() + Mth.nextDouble(RandomSource.create(), -5, 5)));
								}
								AuraSummonFireProcedure.execute(world, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
							}
						}
					}
				}
				entity.getPersistentData().putDouble("attackCooldown", 20);
			} else if (entity.getPersistentData().getDouble("attacktype") == 2) {
				shoudattack = true;
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player && (new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entityiterator) || new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
								}
								return false;
							}
						}.checkGamemode(entityiterator)) || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies")))) {
							if (shoudattack == true) {
								shoudattack = false;
								AuraSummonTearProcedure.execute(world, (entityiterator.getX() + 1.25), (entityiterator.getY()), (entityiterator.getZ() + 1.25));
								AuraSummonTearProcedure.execute(world, (entityiterator.getX() - 1.25), (entityiterator.getY()), (entityiterator.getZ() + 1.25));
								AuraSummonTearProcedure.execute(world, (entityiterator.getX() - 1.25), (entityiterator.getY()), (entityiterator.getZ() - 1.25));
								AuraSummonTearProcedure.execute(world, (entityiterator.getX() + 1.25), (entityiterator.getY()), (entityiterator.getZ() - 1.25));
							}
						}
					}
				}
				entity.getPersistentData().putDouble("attackCooldown", 0);
			} else if (entity.getPersistentData().getDouble("attacktype") == 3) {
				mobcount = 0;
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof GrieverEntity || entityiterator instanceof WeeperEntity || entityiterator instanceof MournstoneEntity || entityiterator instanceof AuraMobspawnEntity) {
							mobcount = mobcount + 1;
						}
					}
				}
				shoudattack = true;
				if (mobcount >= 3) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player && (new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
									} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
									}
									return false;
								}
							}.checkGamemode(entityiterator) || new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
									} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
									}
									return false;
								}
							}.checkGamemode(entityiterator)) || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies")))) {
								if (shoudattack == true) {
									shoudattack = false;
									dist = 0;
									for (int index1 = 0; index1 < 16; index1++) {
										AuraSummonFireProcedure.execute(world, (entityiterator.getX() + Math.sin(dist) * 4), (entityiterator.getY()), (entityiterator.getZ() + Math.cos(dist) * 4));
										dist = dist + Math.PI / 8;
									}
									for (int index2 = 0; index2 < 16; index2++) {
										AuraSummonFireProcedure.execute(world, (entityiterator.getX() + Math.sin(dist) * 6), (entityiterator.getY()), (entityiterator.getZ() + Math.cos(dist) * 6));
										dist = dist + Math.PI / 8;
									}
									for (int index3 = 0; index3 < 16; index3++) {
										AuraSummonFireProcedure.execute(world, (entityiterator.getX() + Math.sin(dist) * 8), (entityiterator.getY()), (entityiterator.getZ() + Math.cos(dist) * 8));
										dist = dist + Math.PI / 8;
									}
								}
							}
						}
					}
				} else {
					shoudattack = true;
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player && (new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
									} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
									}
									return false;
								}
							}.checkGamemode(entityiterator) || new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
									} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
									}
									return false;
								}
							}.checkGamemode(entityiterator)) || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies")))) {
								if (shoudattack == true) {
									shoudattack = false;
									dist = 0;
									for (int index4 = 0; index4 < 3; index4++) {
										AuraSummonMobProcedure.execute(world, (entityiterator.getX() + Math.sin(dist) * 2), (entityiterator.getY()), (entityiterator.getZ() + Math.cos(dist) * 2));
										dist = dist + Math.PI / 1.5;
									}
								}
							}
						}
					}
				}
				entity.getPersistentData().putDouble("attackCooldown", (-40));
			} else if (entity.getPersistentData().getDouble("attacktype") == 4) {
				shoudattack = true;
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player && (new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entityiterator) || new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
								}
								return false;
							}
						}.checkGamemode(entityiterator)) || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies")))) {
							if (shoudattack == true) {
								shoudattack = false;
								dist = 0;
								dist2 = 5;
								for (int index5 = 0; index5 < 4; index5++) {
									for (int index6 = 0; index6 < 8; index6++) {
										AuraSummonHookProcedure.execute(world, (x + Math.sin(dist) * dist2), y, (z + Math.cos(dist) * dist2));
										dist = dist + Math.PI / 4;
									}
									dist2 = dist2 + 2;
								}
							}
						}
					}
				}
				entity.getPersistentData().putDouble("attackCooldown", 0);
			} else if (entity.getPersistentData().getDouble("attacktype") == 5) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback) {
								AbstractArrow entityToSpawn = new HomingTearEntity(IterRpgModEntities.HOMING_TEAR.get(), level);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 2);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.01, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				entity.getPersistentData().putDouble("attackCooldown", 50);
			}
		}
		doattack = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player && (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entityiterator) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
						}
						return false;
					}
				}.checkGamemode(entityiterator)) || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies")))) {
					doattack = true;
				}
			}
		}
		if (doattack) {
			entity.getPersistentData().putDouble("attackCooldown", (entity.getPersistentData().getDouble("attackCooldown") + 1));
			entity.getPersistentData().putDouble("bonusAttack", (entity.getPersistentData().getDouble("bonusAttack") + 1));
		}
		if (entity.getPersistentData().getDouble("bonusAttack") >= Mth.nextInt(RandomSource.create(), 100, 500)) {
			entity.getPersistentData().putDouble("bonusAttack", 0);
			for (int index7 = 0; index7 < 4; index7++) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback) {
								AbstractArrow entityToSpawn = new HomingTearEntity(IterRpgModEntities.HOMING_TEAR.get(), level);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 2);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.5, 20);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		}
	}
}
