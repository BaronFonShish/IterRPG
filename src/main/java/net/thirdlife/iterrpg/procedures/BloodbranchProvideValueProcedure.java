package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class BloodbranchProvideValueProcedure {
	public static double execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return 0;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if ((entity instanceof LivingEntity _entUseTicks3 ? _entUseTicks3.getTicksUsingItem() : 0) >= 30) {
				return 3;
			} else if ((entity instanceof LivingEntity _entUseTicks4 ? _entUseTicks4.getTicksUsingItem() : 0) >= 20) {
				return 2;
			} else if ((entity instanceof LivingEntity _entUseTicks5 ? _entUseTicks5.getTicksUsingItem() : 0) >= 10) {
				return 1;
			}
			return 0;
		}
		return 0;
	}
}
