package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class ElementalSetRepairProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getDamageValue() >= 1) {
			if (Mth.nextInt(RandomSource.create(), 1, 600) == 64) {
				itemstack.setDamageValue((int) (itemstack.getDamageValue() - 1));
			}
		}
	}
}
