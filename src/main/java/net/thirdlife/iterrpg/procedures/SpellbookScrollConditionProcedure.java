package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class SpellbookScrollConditionProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:spell_scrolls")))) {
			return false;
		}
		return true;
	}
}
