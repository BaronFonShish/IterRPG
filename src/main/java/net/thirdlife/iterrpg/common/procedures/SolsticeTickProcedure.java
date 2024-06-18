package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class SolsticeTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) && itemstack.getOrCreateTag().getDouble("CustomModelData") == 1) {
			itemstack.getOrCreateTag().putDouble("CustomModelData", 0);
		}
	}
}
