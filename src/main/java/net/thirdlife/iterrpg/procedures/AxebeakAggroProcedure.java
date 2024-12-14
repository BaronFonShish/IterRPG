package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class AxebeakAggroProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _lvl0 && _lvl0.isDay() || world.getBrightness(LightLayer.SKY, BlockPos.containing(x, y, z)) >= 12) {
			return true;
		}
		return false;
	}
}
