package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.item.ItemStack;

public class BloodCooldownProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("charge") <= 0 && itemstack.getOrCreateTag().getDouble("CustomModelData") > 0) {
			itemstack.getOrCreateTag().putDouble("CustomModelData", (itemstack.getOrCreateTag().getDouble("CustomModelData") - 1));
			itemstack.getOrCreateTag().putDouble("charge", 5);
		} else {
			itemstack.getOrCreateTag().putDouble("charge", (itemstack.getOrCreateTag().getDouble("charge") - 1));
		}
	}
}
