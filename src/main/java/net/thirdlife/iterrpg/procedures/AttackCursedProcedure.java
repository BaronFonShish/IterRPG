package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class AttackCursedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean agr = false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(IterRpgModMobEffects.CURSED.get())) {
			return true;
		}
		return false;
	}
}
