package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.GiantSpiderEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class EventSpawnTurnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double decide = 0;
		if ((IterRpgModVariables.MapVariables.get(world).OverworldEvent).equals("iterpg.event.end_rift")) {
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && !(world instanceof Level _lvl1 && _lvl1.isDay())) {
				decide = Mth.nextInt(RandomSource.create(), 1, 2);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.PORTAL_SPARK_PARTICLE.get()), x, (y + 1), z, 8, 0.25, 1, 0.25, 0);
				if (decide == 2) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ENDERMAN.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if ((IterRpgModVariables.MapVariables.get(world).OverworldEvent).equals("iterpg.event.insect_season")) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("frozen_peaks")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("windswept_gravelly_hills"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("windswept_hills")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("stony_peaks"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("jagged_peaks"))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.SILVERFISH.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else if (y <= 48) {
				decide = Mth.nextInt(RandomSource.create(), 1, 7);
				if (decide == 7) {
					if (!(!world.getEntitiesOfClass(GiantSpiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 150, 150, 150), e -> true).isEmpty())) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = IterRpgModEntities.GIANT_SPIDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				} else if ((decide) > (0) && (decide) < (3)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				} else if ((decide) > (3) && (decide) < (5)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				} else {
					for (int index0 = 0; index0 < 2; index0++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = IterRpgModEntities.SPIDERLING.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			} else {
				decide = Mth.nextInt(RandomSource.create(), 1, 10);
				if (decide == 10) {
					if (!(!world.getEntitiesOfClass(GiantSpiderEntity.class, AABB.ofSize(new Vec3(x, y, z), 150, 150, 150), e -> true).isEmpty())) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = IterRpgModEntities.GIANT_SPIDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.CAVE_SPIDER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				} else if (decide == 9) {
					for (int index1 = 0; index1 < 2; index1++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = IterRpgModEntities.SPIDERLING.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
							}
						}
					}
				} else if (decide == 8 || decide == 7) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.BEE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.SPIDER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT, x, (y + 1), z, 8, 0.25, 0.5, 0.25, 0);
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
