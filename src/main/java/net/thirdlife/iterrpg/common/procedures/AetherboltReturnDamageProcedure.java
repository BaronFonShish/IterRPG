package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class AetherboltReturnDamageProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("level") == 0) {
			return Component.translatable("iterpg.spell.aetherbolt.damage.1").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 1) {
			return Component.translatable("iterpg.spell.aetherbolt.damage.2").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 2) {
			return Component.translatable("iterpg.spell.aetherbolt.damage.3").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 3) {
			return Component.translatable("iterpg.spell.aetherbolt.damage.4").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 4) {
			return Component.translatable("iterpg.spell.aetherbolt.damage.5").getString();
		}
		return Component.translatable("iterpg.spell.aetherbolt.damage.1").getString();
	}
}
