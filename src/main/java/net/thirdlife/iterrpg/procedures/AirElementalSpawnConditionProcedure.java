package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class AirElementalSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double count = 0;
		if (y >= 150 && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
				&& (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains"))
						|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("plains"))
						|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("jagged_peaks")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("frozen_peaks"))
						|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("stony_peaks")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("meadow")))
				&& IterRpgModVariables.MapVariables.get(world).unlocked_air && ElementalsSpawnConditionProcedure.execute(world, x, y, z)) {
			return true;
		}
		return false;
	}
}
