package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class EarthElementalSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double count = 0;
		if ((world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("jungle"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("forest"))) && y <= 60 && ElementalsSpawnConditionProcedure.execute(world, x, y, z) && IterRpgModVariables.MapVariables.get(world).unlocked_earth) {
			return true;
		}
		return false;
	}
}
