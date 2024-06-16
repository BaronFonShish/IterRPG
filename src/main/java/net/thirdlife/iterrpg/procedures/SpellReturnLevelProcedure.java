package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class SpellReturnLevelProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("level") == 0) {
			return Component.translatable("iterpg.spell.level.basic").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 1) {
			return Component.translatable("iterpg.spell.level.advanced").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 2) {
			return Component.translatable("iterpg.spell.level.expert").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 3) {
			return Component.translatable("iterpg.spell.level.fabled").getString();
		} else if (itemstack.getOrCreateTag().getDouble("level") == 4) {
			return Component.translatable("iterpg.spell.level.primeval").getString();
		}
		return Component.translatable("iterpg.spell.level.basic").getString();
	}
}
