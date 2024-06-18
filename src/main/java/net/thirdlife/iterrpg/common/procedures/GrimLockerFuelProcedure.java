package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.item.ItemStack;

public class GrimLockerFuelProcedure {
	public static boolean execute(ItemStack itemstack) {
		ItemStack item = ItemStack.EMPTY;
		ItemStack fuel = ItemStack.EMPTY;
		ItemStack bottle = ItemStack.EMPTY;
		if (itemstack.getItem() == IterRpgModItems.BOTTLE_OF_OBSIDIAN_TEARS.get()) {
			return false;
		}
		return true;
	}
}
