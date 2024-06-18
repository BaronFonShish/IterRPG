package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SpiderlingSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("jungle"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves"))) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7) {
			return true;
		}
		return false;
	}
}
