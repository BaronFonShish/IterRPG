package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class VaseBreakGenericProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		OreExpDropProcedure.execute(world, x, y, z, entity);
		VaseBatSpawnProcedure.execute(world, x, y, z, entity);
	}
}
