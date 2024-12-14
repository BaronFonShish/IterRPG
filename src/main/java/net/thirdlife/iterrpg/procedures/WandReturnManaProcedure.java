package net.thirdlife.iterrpg.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.init.IterRpgModEnchantments;
import net.thirdlife.iterrpg.init.IterRpgModAttributes;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class WandReturnManaProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		ItemStack wand = ItemStack.EMPTY;
		double manacost = 0;
		double power = 0;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("iter_rpg:spellcasting_focuses")))) {
			wand = (entity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("iter_rpg:spellcasting_focuses")))) {
			wand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("iter_rpg:spellcasting_focuses")))) {
			wand = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		}
		manacost = ((LivingEntity) entity).getAttribute(IterRpgModAttributes.MANACONSUMPTION.get()).getValue();
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.ARCANE_BOUQUETE.get(), lv).isPresent() : false) {
			manacost = manacost * 0.92;
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(IterRpgModEnchantments.RIGOUR.get(), wand) != 0) {
			manacost = manacost * (1 - wand.getEnchantmentLevel(IterRpgModEnchantments.RIGOUR.get()) / 15);
		}
		return manacost;
	}
}
