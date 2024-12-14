package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class ElementalToolMendProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem())) && itemstack.getDamageValue() >= 1) {
			if (Mth.nextInt(RandomSource.create(), 1, (int) (16 * itemstack.getMaxDamage())) <= itemstack.getDamageValue()) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
				itemstack.setDamageValue((int) (itemstack.getDamageValue() - 1));
			}
		}
	}
}
