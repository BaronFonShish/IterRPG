package net.thirdlife.iterrpg.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ReturnCallensEquippedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.CALIBRATED_LENS.get(), lv).isPresent() : false) {
			return true;
		}
		return false;
	}
}
