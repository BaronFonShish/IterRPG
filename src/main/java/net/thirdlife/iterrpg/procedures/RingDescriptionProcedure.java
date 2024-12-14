package net.thirdlife.iterrpg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class RingDescriptionProcedure {
	public static String execute(ItemStack itemstack) {
		return Component.translatable(("iterpg.desc." + (ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).replace("iter_rpg:", ""))).getString();
	}
}
