package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class VoidSetRepairProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getDamageValue() >= 1) {
			if ((entity.level().dimension()) == Level.END) {
				if (Mth.nextInt(RandomSource.create(), 1, 400) == 64) {
					itemstack.setDamageValue((int) (itemstack.getDamageValue() - 1));
				}
			}
		}
	}
}
