package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class MagmanumSwordTrickProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double trick = 0;
		entity.setSecondsOnFire(5);
		trick = Mth.nextInt(RandomSource.create(), 1, 3);
		if (trick == 2) {
			sourceentity.setSecondsOnFire(5);
		} else if (trick == 3) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 1, Level.ExplosionInteraction.NONE);
		}
	}
}
