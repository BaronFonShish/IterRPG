package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class IgniteReturnTimeProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("level") == 0) {
			return Component.translatable("iterpg.spell.ignite.time.1").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 1) {
			return Component.translatable("iterpg.spell.ignite.time.2").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 2) {
			return Component.translatable("iterpg.spell.ignite.time.3").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 3) {
			return Component.translatable("iterpg.spell.ignite.time.4").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 4) {
			return Component.translatable("iterpg.spell.ignite.time.5").getString();
		}
		return Component.translatable("iterpg.spell.ignite.time.1").getString();
	}
}
