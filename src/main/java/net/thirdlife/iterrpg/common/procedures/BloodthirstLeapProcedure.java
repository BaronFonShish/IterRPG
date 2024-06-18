package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class BloodthirstLeapProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.onGround()) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 64);
			if (entity.isShiftKeyDown()) {
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * (-1.5)), (entity.getLookAngle().y / (-2.5) + 0.32), (entity.getLookAngle().z * (-1.5))));
			} else {
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 1.5), (entity.getLookAngle().y / 2.5 + 0.32), (entity.getLookAngle().z * 1.5)));
			}
		}
	}
}
