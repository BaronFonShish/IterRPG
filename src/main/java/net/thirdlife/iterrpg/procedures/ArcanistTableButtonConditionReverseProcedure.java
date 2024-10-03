package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class ArcanistTableButtonConditionReverseProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		ItemStack initial = ItemStack.EMPTY;
		ItemStack output = ItemStack.EMPTY;
		ItemStack resource1 = ItemStack.EMPTY;
		ItemStack resource2 = ItemStack.EMPTY;
		ItemStack resource3 = ItemStack.EMPTY;
		double chance = 0;
		return !ArcanistTableButtonConditionProcedure.execute(entity);
	}
}
