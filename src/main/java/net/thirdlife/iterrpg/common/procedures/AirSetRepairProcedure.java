package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class AirSetRepairProcedure {
	public static void execute(double y, ItemStack itemstack) {
		if (itemstack.getDamageValue() >= 1) {
			if (y >= 100) {
				if (Mth.nextInt(RandomSource.create(), 1, 400) == 64) {
					itemstack.setDamageValue((int) (itemstack.getDamageValue() - 1));
				}
			}
		}
	}
}
