package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class RuneLureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean flag = false;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double max = 0;
		max = 0.025;
		if (itemstack.getItem() == IterRpgModItems.EARTH_RUNE.get()) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_forest")))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:lush")))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:has_structure/village_plains")))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_jungle")))) {
				max = max + 0.025;
			}
			for (int index0 = 0; index0 < 6; index0++) {
				xpos = Mth.nextInt(RandomSource.create(), -8, 8);
				zpos = Mth.nextInt(RandomSource.create(), -8, 8);
				ypos = Mth.nextInt(RandomSource.create(), -3, 5);
				if ((world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos))).is(BlockTags.create(new ResourceLocation("forge:earth_element")))) {
					max = max + 0.05;
				}
			}
			{
				double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).earth_lure + Mth.nextDouble(RandomSource.create(), 0, max);
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.earth_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (itemstack.getItem() == IterRpgModItems.WATER_RUNE.get()) {
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && world.getLevelData().isRaining() || world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_ocean")))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_river")))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:water")))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:has_structure/swamp_hut")))) {
				max = max + 0.025;
			}
			for (int index1 = 0; index1 < 6; index1++) {
				xpos = Mth.nextInt(RandomSource.create(), -8, 8);
				zpos = Mth.nextInt(RandomSource.create(), -8, 8);
				ypos = Mth.nextInt(RandomSource.create(), -3, 5);
				if ((world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos))).is(BlockTags.create(new ResourceLocation("forge:water_element")))) {
					max = max + 0.05;
				}
			}
			{
				double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).water_lure + Mth.nextDouble(RandomSource.create(), 0, max);
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.water_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (itemstack.getItem() == IterRpgModItems.AIR_RUNE.get()) {
			if (y >= 110 || y >= 60 && (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("jagged_peaks")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("frozen_peaks"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("stony_peaks")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("meadow")))) {
				max = max + 0.025;
			}
			for (int index2 = 0; index2 < 6; index2++) {
				xpos = Mth.nextInt(RandomSource.create(), -8, 8);
				zpos = Mth.nextInt(RandomSource.create(), -8, 8);
				ypos = Mth.nextInt(RandomSource.create(), -3, 5);
				if ((world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos))).is(BlockTags.create(new ResourceLocation("forge:air_element")))) {
					max = max + 0.05;
				}
			}
			{
				double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).air_lure + Mth.nextDouble(RandomSource.create(), 0, max);
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.air_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (itemstack.getItem() == IterRpgModItems.FIRE_RUNE.get()) {
			if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.NETHER) {
				max = max + 0.025;
			}
			for (int index3 = 0; index3 < 6; index3++) {
				xpos = Mth.nextInt(RandomSource.create(), -8, 8);
				zpos = Mth.nextInt(RandomSource.create(), -8, 8);
				ypos = Mth.nextInt(RandomSource.create(), -3, 5);
				if ((world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos))).is(BlockTags.create(new ResourceLocation("forge:fire_element")))) {
					max = max + 0.05;
				}
			}
			{
				double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).fire_lure + Mth.nextDouble(RandomSource.create(), 0, max);
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fire_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (itemstack.getItem() == IterRpgModItems.VOID_RUNE.get()) {
			if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.END
					|| (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD && y <= -48) {
				max = max + 0.025;
			}
			for (int index4 = 0; index4 < 6; index4++) {
				xpos = Mth.nextInt(RandomSource.create(), -8, 8);
				zpos = Mth.nextInt(RandomSource.create(), -8, 8);
				ypos = Mth.nextInt(RandomSource.create(), -3, 5);
				if ((world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos))).is(BlockTags.create(new ResourceLocation("forge:void_element")))) {
					max = max + 0.05;
				}
			}
			{
				double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).void_lure + Mth.nextDouble(RandomSource.create(), 0, max);
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.void_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).earth_lure >= 50
				|| (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).water_lure >= 50
				|| (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).air_lure >= 50
				|| (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).fire_lure >= 50
				|| (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).void_lure >= 50) {
			{
				double _setval = 45;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.earth_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 45;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.water_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 45;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.air_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 45;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fire_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 45;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.void_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (ElementalsSpawnConditionProcedure.execute(world, x, y, z)) {
				flag = true;
				for (int index5 = 0; index5 < 6; index5++) {
					if (flag) {
						xpos = Mth.nextInt(RandomSource.create(), -8, 8);
						zpos = Mth.nextInt(RandomSource.create(), -8, 8);
						ypos = -1;
					}
					for (int index6 = 0; index6 < 8; index6++) {
						if (flag) {
							if (!world.getBlockState(BlockPos.containing(x + xpos, y + ypos + 1, z + zpos)).canOcclude() && !world.getBlockState(BlockPos.containing(x + xpos, y + ypos + 2, z + zpos)).canOcclude()) {
								flag = false;
								if (world.isClientSide())
									Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
								{
									double _setval = 0;
									entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.earth_lure = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).water_lure / 2;
									entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.water_lure = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).air_lure / 2;
									entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.air_lure = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).fire_lure / 2;
									entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.fire_lure = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).void_lure / 2;
									entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.void_lure = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (itemstack.getItem() == IterRpgModItems.EARTH_RUNE.get()) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.EARTH_SIGIL.get()), (x + xpos), (y + ypos + 1), (z + zpos), 20, 0.8, 0.8, 0.8, 0.01);
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = IterRpgModEntities.EARTH_ELEMENTAL.get().spawn(_level, BlockPos.containing(x + xpos, y + ypos + 1, z + zpos), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
								} else if (itemstack.getItem() == IterRpgModItems.WATER_RUNE.get()) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WATER_SIGIL.get()), (x + xpos), (y + ypos + 1), (z + zpos), 20, 0.8, 0.8, 0.8, 0.01);
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = IterRpgModEntities.WATER_ELEMENTAL.get().spawn(_level, BlockPos.containing(x + xpos, y + ypos + 1, z + zpos), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
								} else if (itemstack.getItem() == IterRpgModItems.AIR_RUNE.get()) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.AIR_SIGIL.get()), (x + xpos), (y + ypos + 1), (z + zpos), 20, 0.8, 0.8, 0.8, 0.01);
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = IterRpgModEntities.AIR_ELEMENTAL.get().spawn(_level, BlockPos.containing(x + xpos, y + ypos + 1, z + zpos), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
								} else if (itemstack.getItem() == IterRpgModItems.FIRE_RUNE.get()) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.FIRE_SIGIL.get()), (x + xpos), (y + ypos + 1), (z + zpos), 20, 0.8, 0.8, 0.8, 0.01);
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = IterRpgModEntities.FIRE_ELEMENTAL.get().spawn(_level, BlockPos.containing(x + xpos, y + ypos + 1, z + zpos), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
								} else if (itemstack.getItem() == IterRpgModItems.VOID_RUNE.get()) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.VOID_SIGIL.get()), (x + xpos), (y + ypos + 1), (z + zpos), 20, 0.8, 0.8, 0.8, 0.01);
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = IterRpgModEntities.VOID_ELEMENTAL.get().spawn(_level, BlockPos.containing(x + xpos, y + ypos + 1, z + zpos), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
										}
									}
								}
							}
							ypos = ypos + 1;
						}
					}
				}
			}
		}
	}
}
