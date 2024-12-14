package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.DwarfEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class DwarfSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof DwarfEntity _datEntSetI)
			_datEntSetI.getEntityData().set(DwarfEntity.DATA_profession, Mth.nextInt(RandomSource.create(), 1, 3));
		entity.getPersistentData().putDouble("tradetimer", 12000);
	}
}
