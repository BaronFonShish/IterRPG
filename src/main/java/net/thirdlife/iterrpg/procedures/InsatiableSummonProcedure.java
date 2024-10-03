package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.InsatiableEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class InsatiableSummonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		boolean summon = false;
		boolean proceed = false;
		double chance = 0;
		double xrand = 0;
		double zrand = 0;
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
				&& !(!world.getEntitiesOfClass(InsatiableEntity.class, AABB.ofSize(new Vec3(x, y, z), 128, 128, 128), e -> true).isEmpty())) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -4, 4), y, z + Mth.nextDouble(RandomSource.create(), -4, 4)),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.drowned.ambient")), SoundSource.HOSTILE, 1, (float) 0.5);
				} else {
					_level.playLocalSound((x + Mth.nextDouble(RandomSource.create(), -4, 4)), y, (z + Mth.nextDouble(RandomSource.create(), -4, 4)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.drowned.ambient")),
							SoundSource.HOSTILE, 1, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -4, 4), y, z + Mth.nextDouble(RandomSource.create(), -4, 4)),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.drowned.ambient_water")), SoundSource.HOSTILE, 1, (float) 0.8);
				} else {
					_level.playLocalSound((x + Mth.nextDouble(RandomSource.create(), -4, 4)), y, (z + Mth.nextDouble(RandomSource.create(), -4, 4)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.drowned.ambient_water")),
							SoundSource.HOSTILE, 1, (float) 0.8, false);
				}
			}
			summon = false;
			for (int index0 = 0; index0 < 32; index0++) {
				if (world.getBiome(BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -16, 16), y + Mth.nextDouble(RandomSource.create(), -2, 2), z + Mth.nextDouble(RandomSource.create(), -16, 16)))
						.is(TagKey.create(Registries.BIOME, new ResourceLocation("iter_rpg:insatiable_lair")))) {
					summon = true;
				}
			}
			if (summon == true) {
				itemstack.shrink(1);
				for (int index1 = 0; index1 < 32; index1++) {
					xrand = x + Mth.nextDouble(RandomSource.create(), -10, 10);
					zrand = z + Mth.nextDouble(RandomSource.create(), -10, 10);
					if (world.getBlockState(BlockPos.containing(xrand, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xrand, (int) zrand) - 1, zrand)).canOcclude()) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = IterRpgModEntities.INSATIABLE.get().spawn(_level, BlockPos.containing(xrand, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xrand, (int) zrand), zrand), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot((float) Mth.nextDouble(RandomSource.create(), -100, 100));
								entityToSpawn.setYBodyRot((float) Mth.nextDouble(RandomSource.create(), -100, 100));
								entityToSpawn.setYHeadRot((float) Mth.nextDouble(RandomSource.create(), -100, 100));
								entityToSpawn.setXRot((float) Mth.nextDouble(RandomSource.create(), -100, 100));
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						for (int index2 = 0; index2 < 2; index2++) {
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(xrand + Mth.nextDouble(RandomSource.create(), -4, 4), world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xrand, (int) zrand),
										zrand + Mth.nextDouble(RandomSource.create(), -4, 4))));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if (!world.getLevelData().isRaining() && !world.getLevelData().isThundering()) {
							world.getLevelData().setRaining(true);
						}
						summon = false;
						break;
					}
				}
			}
		}
	}
}
