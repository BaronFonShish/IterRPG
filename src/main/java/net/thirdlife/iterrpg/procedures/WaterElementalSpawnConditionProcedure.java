package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class WaterElementalSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double count = 0;
		if ((world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_ocean"))) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
				|| (Blocks.GRASS.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z)) || Blocks.SEAGRASS.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z))
						|| Blocks.SUGAR_CANE.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z)) || Blocks.CACTUS.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z)))
						&& world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && world.getLevelData().isRaining() && Math.random() >= 0.75)
				&& (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD && IterRpgModVariables.MapVariables.get(world).unlocked_water && ElementalsSpawnConditionProcedure.execute(world, x, y, z)) {
			return true;
		}
		return false;
	}
}
