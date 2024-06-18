package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class CultivateReturnPowerProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("level") == 0) {
			return Component.translatable("iterpg.spell.cultivate.desc1").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 1) {
			return Component.translatable("iterpg.spell.cultivate.desc2").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 2) {
			return Component.translatable("iterpg.spell.cultivate.desc3").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 3) {
			return Component.translatable("iterpg.spell.cultivate.desc4").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 4) {
			return Component.translatable("iterpg.spell.cultivate.desc5").getString();
		}
		return Component.translatable("iterpg.spell.cultivate.desc1").getString();
	}
}
