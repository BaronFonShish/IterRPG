package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.Comparator;

public class EarthElementalAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean shouldtick = false;
		boolean shouldspawn = false;
		boolean flag = false;
		double attack = 0;
		double timer = 0;
		double particle = 0;
		double fireforce = 0;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double yspawn = 0;
		double attacktype = 0;
		double iteration = 0;
		ElementalFlightBehaviourProcedure.execute(world, x, y, z, entity);
		if (entity.getPersistentData().getDouble("attack") >= 80) {
			entity.getPersistentData().putDouble("attack", 0);
			if (entity.getPersistentData().getDouble("attackchosen") == 0) {
				entity.getPersistentData().putDouble("attackchosen", 1);
				attacktype = 1;
			} else if (entity.getPersistentData().getDouble("attackchosen") == 1) {
				entity.getPersistentData().putDouble("attackchosen", 2);
				attacktype = 2;
			} else if (entity.getPersistentData().getDouble("attackchosen") == 2) {
				entity.getPersistentData().putDouble("attackchosen", 0);
				attacktype = 3;
			}
			if (attacktype == 1) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_LEAF.get()), x, (y + 0.4), z, 32, 0.25, 0.25, 0.25, 0.05);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							for (int index0 = 0; index0 < 8; index0++) {
								xpos = Mth.nextDouble(RandomSource.create(), -6, 6);
								ypos = -4;
								zpos = Mth.nextDouble(RandomSource.create(), -6, 6);
								shouldspawn = false;
								for (int index1 = 0; index1 < 8; index1++) {
									if (world.isEmptyBlock(BlockPos.containing(entityiterator.getX() + xpos, entityiterator.getY() + ypos, entityiterator.getZ() + zpos))
											&& world.getBlockState(BlockPos.containing(entityiterator.getX() + xpos, Math.round((entityiterator.getY() + ypos) - 1), entityiterator.getZ() + zpos)).canOcclude()) {
										yspawn = ypos;
										shouldspawn = true;
									}
									ypos = ypos + 1;
								}
								if (shouldspawn == true) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = IterRpgModEntities.FOREST_VINES.get().spawn(_level, BlockPos.containing(entityiterator.getX() + xpos, Math.floor(entityiterator.getY() + yspawn), entityiterator.getZ() + zpos),
												MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_LEAF.get()), (entityiterator.getX() + xpos), (entityiterator.getY() + yspawn + 0.2), (entityiterator.getZ() + zpos), 6, 0.25, 0.5,
												0.25, 0.25);
								}
							}
						}
					}
				}
			} else if (attacktype == 2) {
				for (int index2 = 0; index2 < 3; index2++) {
					xpos = Mth.nextDouble(RandomSource.create(), -3, 3);
					ypos = -4;
					zpos = Mth.nextDouble(RandomSource.create(), -3, 3);
					shouldspawn = false;
					for (int index3 = 0; index3 < 8; index3++) {
						if (world.isEmptyBlock(BlockPos.containing(entity.getX() + xpos, entity.getY() + ypos, entity.getZ() + zpos))
								&& world.getBlockState(BlockPos.containing(entity.getX() + xpos, Math.round((entity.getY() + ypos) - 1), entity.getZ() + zpos)).canOcclude()) {
							yspawn = ypos;
							shouldspawn = true;
						}
						ypos = ypos + 1;
					}
					if (shouldspawn == true) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = IterRpgModEntities.EARTH_BOULDER.get().spawn(_serverLevel, BlockPos.containing((entity.getX() + xpos), (Math.floor(entity.getY() + yspawn) + 0.1), (entity.getZ() + zpos)), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
							}
							(entitytospawn).getPersistentData().putBoolean("friendly", false);
							(entitytospawn).getPersistentData().putDouble("ascend", (Mth.nextDouble(RandomSource.create(), 2.5, 4)));
							(entitytospawn).getPersistentData().putDouble("lifetime", 0);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (entity.getX() + xpos), (entity.getY() + yspawn + 0.2), (entity.getZ() + zpos), 2, 0.25, 0.5, 0.25, 0.0025);
					}
				}
			} else if (attacktype == 3) {
				flag = false;
				iteration = 0;
				for (int index4 = 0; index4 < 10; index4++) {
					if (world.getBlockState(BlockPos.containing(x, y - iteration, z)).isFaceSturdy(world, BlockPos.containing(x, y - iteration, z), Direction.UP)) {
						flag = true;
					}
					iteration = iteration + 1;
				}
				if (flag) {
					entity.getPersistentData().putDouble("slam", 1);
					entity.setDeltaMovement(new Vec3(0, 0.2, 0));
					IterRpgMod.queueServerWork(10, () -> {
						entity.setDeltaMovement(new Vec3(0, (-1), 0));
						IterRpgMod.queueServerWork(20, () -> {
							if (entity.getPersistentData().getDouble("slam") >= 1) {
								entity.getPersistentData().putDouble("slam", 2);
							}
						});
					});
				}
			}
		} else {
			shouldtick = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
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
					}.checkGamemode(entityiterator))) {
						shouldtick = true;
					}
				}
			}
			if (shouldtick == true) {
				entity.getPersistentData().putDouble("attack", (entity.getPersistentData().getDouble("attack") + 1));
			}
		}
		if (entity.getPersistentData().getDouble("slam") >= 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT, x, y, z, 2, 0.2, 0.2, 0.2, 0);
		}
		if (entity.getPersistentData().getDouble("slam") >= 2) {
			entity.setDeltaMovement(new Vec3(0, (-0.3), 0));
		}
		if (entity.getPersistentData().getDouble("slam") >= 1 && world.getBlockState(BlockPos.containing(x, y - 0.1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 0.1, z), Direction.UP)) {
			entity.getPersistentData().putDouble("slam", 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 1, 0, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT, x, y, z, 16, 1, 0, 1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 6, 1, 0.2, 1, 0.05);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ASH, x, y, z, 16, 1, 0, 1, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.calcite.break")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.calcite.break")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.break")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.rooted_dirt.break")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entity.onGround() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:elementals")))
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))) {
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), (float) 0.1, Level.ExplosionInteraction.NONE);
					}
				}
			}
		}
	}
}
