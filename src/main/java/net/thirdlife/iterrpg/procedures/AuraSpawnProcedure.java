package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class AuraSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity auraselect = null;
		boolean dospawn = false;
		boolean doattack = false;
		boolean shoudattack = false;
		double auraposx = 0;
		double auraposz = 0;
		double auraposy = 0;
		double attackType = 0;
		double ycheck = 0;
		double specialattack = 0;
		double attacktrigger = 0;
		double ypos = 0;
		double distance = 0;
		double yfinal = 0;
		double mobcount = 0;
		double aurarand = 0;
		double repeatnum = 0;
		attackType = Mth.nextInt(RandomSource.create(), 1, 3);
		if (attackType == 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.AURA_SOULFIRE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (attackType == 2) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.AURA_TEARBURST.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (attackType == 3) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.AURA_BOULDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
