package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class AuraSummonMobProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity auraselect = null;
		boolean dospawn = false;
		boolean doattack = false;
		boolean shoudattack = false;
		boolean attack = false;
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
		double amount = 0;
		double offset = 0;
		double dist = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		auraposx = x;
		auraposz = z;
		auraposy = Math.round(y - 4);
		ycheck = auraposy;
		dospawn = false;
		for (int index0 = 0; index0 < 12; index0++) {
			if (!world.getBlockState(BlockPos.containing(auraposx, auraposy, auraposz)).canOcclude() && world.getBlockState(BlockPos.containing(auraposx, auraposy - 1, auraposz)).canOcclude()) {
				ycheck = auraposy;
				dospawn = true;
			}
			if (dospawn == false) {
				auraposy = auraposy + 1;
			}
		}
		if (dospawn == true) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = IterRpgModEntities.AURA_MOBSPAWN.get().spawn(_level, BlockPos.containing(auraposx, ycheck, auraposz), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
		}
	}
}
