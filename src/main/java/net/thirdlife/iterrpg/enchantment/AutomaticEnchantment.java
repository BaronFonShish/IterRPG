
package net.thirdlife.iterrpg.enchantment;

import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

public class AutomaticEnchantment extends Enchantment {
	public AutomaticEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.BOW, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient
				.of(new ItemStack(Items.BOW), new ItemStack(IterRpgModItems.DRIFTBOW.get()), new ItemStack(IterRpgModItems.FIRESTARTER.get()), new ItemStack(IterRpgModItems.BLOODBRANCH.get()), new ItemStack(IterRpgModItems.RECURVE_BOW.get()))
				.test(itemstack);
	}
}
