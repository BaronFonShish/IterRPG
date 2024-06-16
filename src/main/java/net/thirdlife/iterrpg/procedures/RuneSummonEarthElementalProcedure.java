package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
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

public class RuneSummonEarthElementalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean flag = false;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double max = 0;
		max = 0.0025;
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
				max = max + 0.005;
			}
		}
		{
			double _setval = (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).earth_lure + Mth.nextDouble(RandomSource.create(), 0, max);
			entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.earth_lure = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).earth_lure >= 50) {
			{
				double _setval = 40;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.earth_lure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (ElementalsSpawnConditionProcedure.execute(world, x, y, z)) {
				flag = true;
				for (int index1 = 0; index1 < 6; index1++) {
					if (flag) {
						xpos = Mth.nextInt(RandomSource.create(), -8, 8);
						zpos = Mth.nextInt(RandomSource.create(), -8, 8);
						ypos = -4;
					}
					for (int index2 = 0; index2 < 8; index2++) {
						if (flag) {
							if (world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x + xpos, y + ypos + 1, z + zpos))
									&& world.isEmptyBlock(BlockPos.containing(x + xpos, y + ypos + 2, z + zpos))) {
								flag = false;
								if (world.isClientSide())
									Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_LEAF.get()), (x + xpos), (y + ypos + 1), (z + zpos), 20, 0.8, 0.8, 0.8, 0.01);
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = IterRpgModEntities.EARTH_ELEMENTAL.get().spawn(_level, BlockPos.containing(x + xpos, y + ypos + 1, z + zpos), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
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
							}
							ypos = ypos + 1;
						}
					}
				}
			}
		}
	}
}
