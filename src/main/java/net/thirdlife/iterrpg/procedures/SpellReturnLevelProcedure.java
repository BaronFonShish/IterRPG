package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class SpellReturnLevelProcedure {
	public static String execute(ItemStack itemstack) {
		return Component.translatable(("iterpg.spell.quality." + Math.round(itemstack.getOrCreateTag().getDouble("level")))).getString();
	}
}
