package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class GoblinSpawnProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (y >= 50 && world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("iter_rpg:goblin_biomes")))) {
			return true;
		}
		return false;
	}
}
