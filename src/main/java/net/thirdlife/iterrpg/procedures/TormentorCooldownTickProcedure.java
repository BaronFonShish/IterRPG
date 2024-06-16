package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;

public class TormentorCooldownTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("cooldown") > 0) {
			itemstack.getOrCreateTag().putDouble("cooldown", (itemstack.getOrCreateTag().getDouble("cooldown") - 1));
		}
	}
}
