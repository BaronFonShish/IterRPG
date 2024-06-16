package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModGameRules;
import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.init.IterRpgModBlocks;
import net.thirdlife.iterrpg.entity.GrimaceEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class SpireSpawnerFunctionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double mobnearby = 0;
		double mobspawn = 0;
		boolean flag = false;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5), (y + 0.5), (z + 0.5), 1, 0.32, 0.32, 0.32, 0);
		if (world.getLevelData().getGameRules().getBoolean(IterRpgModGameRules.BUILDINGDEBUG) == false) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "respawnTime") >= 40) {
				flag = false;
				{
					final Vec3 _center = new Vec3(x, (y + 3), z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
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
							flag = true;
						}
					}
				}
				if (flag) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5), (y + 0.5), (z + 0.5), 16, 0.5, 0.5, 0.5, 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL, (x + 0.5), (y + 0.5), (z + 0.5), 16, 0.5, 0.5, 0.5, 0);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("respawnTime", (-36000));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("wave", 3);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "wave") == 0) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("respawnTime", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "respawnTime") + 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "wave") > 0) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL, (x + 0.5), (y + 0.5), (z + 0.5), 1, 0.32, 0.32, 0.32, 0);
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockState _bs = IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					{
						BlockPos _bp = BlockPos.containing(x + 1, y, z);
						BlockState _bs = IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get() || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					{
						BlockPos _bp = BlockPos.containing(x - 1, y, z);
						BlockState _bs = IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y, z + 1);
						BlockState _bs = IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get() || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y, z - 1);
						BlockState _bs = IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get() || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("demoncharge", 64);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				mobnearby = 0;
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners"))) && !(entityiterator instanceof GrimaceEntity)) {
							mobnearby = mobnearby + 1;
						}
					}
				}
				if (mobnearby < 1) {
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "cooldown") == 0) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5), (y + 0.5), (z + 0.5), 16, 0.5, 0.5, 0.5, 0);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("cooldown", (Mth.nextInt(RandomSource.create(), 25, 30)));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("wave", ((new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "wave")) - 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						mobspawn = Mth.nextInt(RandomSource.create(), 1, 3);
						if (mobspawn == 1) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = IterRpgModEntities.GRIEVER.get().spawn(_level, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -1.5, 2.5), y, z + Mth.nextDouble(RandomSource.create(), -1.5, 2.5)),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement((Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.2, (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)));
								}
							}
						} else if (mobspawn == 2) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = IterRpgModEntities.MOURNSTONE.get().spawn(_level, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -1.5, 2.5), y, z + Mth.nextDouble(RandomSource.create(), -1.5, 2.5)),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement((Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.2, (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)));
								}
							}
						} else if (mobspawn == 3) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = IterRpgModEntities.WEEPER.get().spawn(_level, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -1.5, 2.5), y, z + Mth.nextDouble(RandomSource.create(), -1.5, 2.5)),
										MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement((Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.2, (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)));
								}
							}
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("cooldown", ((new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "cooldown")) - 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			}
		}
	}
}
