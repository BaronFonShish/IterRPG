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

public class WandReturnPowerProcedure {
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
		power = ((LivingEntity) entity).getAttribute(IterRpgModAttributes.SPELLCASTINGPOWER.get()).getValue();
		if (EnchantmentHelper.getItemEnchantmentLevel(IterRpgModEnchantments.ATTUNEMENT.get(), wand) != 0) {
			power = power * (1 + wand.getEnchantmentLevel(IterRpgModEnchantments.ATTUNEMENT.get()) / 50);
			power = power + wand.getEnchantmentLevel(IterRpgModEnchantments.ATTUNEMENT.get()) / 25;
		}
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(IterRpgModItems.ARCANE_BOUQUETE.get(), lv).isPresent() : false) {
			power = power + 0.05;
		}
		return power;
	}
}
