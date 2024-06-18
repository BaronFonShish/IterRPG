package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

public class SkyArmorSetBonusProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double chance = 0;
		double generator_distance = 0;
		double previousRecipe = 0;
		if (entity instanceof Player) {
			if (entity.onGround()) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().putDouble("cooldown", 0);
			}
		}
	}
}
