package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.item.ItemStack;

public class CoinPouchCoinConditionProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getItem() == IterRpgModItems.COIN.get() || itemstack.getItem() == IterRpgModBlocks.COIN_PILE.get().asItem() || itemstack.getItem() == IterRpgModBlocks.COIN_BLOCK.get().asItem()) {
			return false;
		}
		return true;
	}
}
