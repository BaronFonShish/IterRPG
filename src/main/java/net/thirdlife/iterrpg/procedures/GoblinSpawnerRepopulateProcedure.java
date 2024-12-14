package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModGameRules;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class GoblinSpawnerRepopulateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double gobamount = 0;
		double hobgob = 0;
		double gob = 0;
		double gobwar = 0;
		double gobpoints = 0;
		double decide = 0;
		double xc = 0;
		double zc = 0;
		boolean hoblimit = false;
		if (world.getLevelData().getGameRules().getBoolean(IterRpgModGameRules.BUILDINGDEBUG) == false) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "respawnTime") >= GoblinSpawnerCycleConfigProcedure.execute(world) + new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "TimeOffset")) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 0.5), (z + 0.5), 16, 0.5, 0.5, 0.5, 0);
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("respawnTime", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("TimeOffset", (Mth.nextInt(RandomSource.create(), -320, 320)));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				gobamount = 0;
				{
					final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(96 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:goblins")))) {
							gobamount = gobamount + 1;
						}
					}
				}
				if (gobamount < 4) {
					hoblimit = true;
					gobpoints = Mth.nextInt(RandomSource.create(), 5, 7);
					for (int index0 = 0; index0 < 16; index0++) {
						if (gobpoints > 0) {
							decide = Mth.nextInt(RandomSource.create(), 1, 3);
							if (decide == 1 && gobpoints >= 2 && hoblimit) {
								hobgob = hobgob + 1;
								gobpoints = gobpoints - 2;
								hoblimit = false;
							} else if (decide == 2 && gobpoints >= 1) {
								gobwar = gobwar + 1;
								gobpoints = gobpoints - 1;
							} else if (decide == 3 && gobpoints >= 0.5) {
								gob = gob + 1;
								gobpoints = gobpoints - 0.75;
							}
						}
					}
					for (int index1 = 0; index1 < 2; index1++) {
						if (hobgob > 0) {
							xc = Mth.nextInt(RandomSource.create(), -2, 2);
							zc = Mth.nextInt(RandomSource.create(), -2, 2);
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = IterRpgModEntities.HOBGOBLIN.get().spawn(_level,
										BlockPos.containing(x + xc + 0.5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + xc + 0.5), (int) (z + zc + 0.5)), z + zc + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
									entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
									entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + xc + 0.5), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + xc + 0.5), (int) (z + zc + 0.5))), (z + zc + 0.5), 8, 0.08, 0.16, 0.08, 0.08);
							hobgob = hobgob - 1;
						}
					}
					for (int index2 = 0; index2 < 4; index2++) {
						if (gobwar > 0) {
							xc = Mth.nextInt(RandomSource.create(), -2, 2);
							zc = Mth.nextInt(RandomSource.create(), -2, 2);
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = IterRpgModEntities.GOBLIN_WARRIOR.get().spawn(_level,
										BlockPos.containing(x + xc + 0.5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + xc + 0.5), (int) (z + zc + 0.5)), z + zc + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
									entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
									entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + xc + 0.5), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + xc + 0.5), (int) (z + zc + 0.5))), (z + zc + 0.5), 8, 0.08, 0.16, 0.08, 0.08);
							gobwar = gobwar - 1;
						}
					}
					for (int index3 = 0; index3 < 6; index3++) {
						if (gob > 0) {
							xc = Mth.nextInt(RandomSource.create(), -2, 2);
							zc = Mth.nextInt(RandomSource.create(), -2, 2);
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = IterRpgModEntities.GOBLIN.get().spawn(_level,
										BlockPos.containing(x + xc + 0.5, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + xc + 0.5), (int) (z + zc + 0.5)), z + zc + 0.5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
									entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
									entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -360, 360));
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + xc + 0.5), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + xc + 0.5), (int) (z + zc + 0.5))), (z + zc + 0.5), 8, 0.08, 0.16, 0.08, 0.08);
							gob = gob - 1;
						}
					}
				}
			} else {
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
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 0.5), (z + 0.5), 1, 0.32, 0.32, 0.32, 0);
			}
		}
	}
}
