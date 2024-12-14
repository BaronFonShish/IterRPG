package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.RockProjectileEntity;

import net.minecraft.world.entity.Entity;

public class PebbleheadHitProcedure {
	public static boolean execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return false;
		double attacktype = 0;
		double distance = 0;
		double rotation = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double attachx = 0;
		double attachy = 0;
		double attachz = 0;
		double dist = 0;
		boolean doattack = false;
		boolean found = false;
		boolean entityhost = false;
		boolean chaindisplay = false;
		if (immediatesourceentity instanceof RockProjectileEntity) {
			return false;
		}
		return true;
	}
}
