package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class GiantSpiderSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7
				&& (y <= 16 || world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("forge:giant_spider_biomes"))))) {
			return true;
		}
		return false;
	}
}
