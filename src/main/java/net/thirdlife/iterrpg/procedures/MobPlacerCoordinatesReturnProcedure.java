package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class MobPlacerCoordinatesReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("x: " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("xcord"))) + ""
				+ ("y: " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("ycord")))
				+ ("z: " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("zcord")));
	}
}
