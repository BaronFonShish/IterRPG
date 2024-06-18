package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

public class SpellbookReturnSpellBaseProcedure {
	public static String execute(ItemStack providedspell, double slotnumber) {
		boolean valid = false;
		ItemStack wand = ItemStack.EMPTY;
		ItemStack spell = ItemStack.EMPTY;
		ItemStack spellbook = ItemStack.EMPTY;
		double cooldown = 0;
		double slot = 0;
		String spellname = "";
		spell = providedspell;
		if (spell.is(ItemTags.create(new ResourceLocation("iter_rpg:spell_scrolls")))) {
			valid = true;
		} else {
			spellname = "Empty";
		}
		if (valid) {
			if (spell.getItem() == IterRpgModItems.SPELL_ETHERBOLT.get()) {
				spellname = Component.translatable("iterpg.spell.etherbolt").getString();
			} else if (spell.getItem() == IterRpgModItems.SPELL_HEAL.get()) {
				spellname = Component.translatable("iterpg.spell.heal").getString();
			} else if (spell.getItem() == IterRpgModItems.SPELL_IGNITE.get()) {
				spellname = Component.translatable("iterpg.spell.ignite").getString();
			} else if (spell.getItem() == IterRpgModItems.SPELL_GUST.get()) {
				spellname = Component.translatable("iterpg.spell.gust").getString();
			} else if (spell.getItem() == IterRpgModItems.SPELL_SPLASHES.get()) {
				spellname = Component.translatable("iterpg.spell.splashes").getString();
			} else if (spell.getItem() == IterRpgModItems.SPELL_CULTIVATE.get()) {
				spellname = Component.translatable("iterpg.spell.cultivate").getString();
			} else if (spell.getItem() == IterRpgModItems.SPELL_ATTRACT.get()) {
				spellname = Component.translatable("iterpg.spell.attract").getString();
			} else if (spell.getItem() == IterRpgModItems.SPELL_ETHERBLAST.get()) {
				spellname = Component.translatable("iterpg.spell.etherblast").getString();
			}
		}
		for (int index0 = 0; index0 < (int) spell.getOrCreateTag().getDouble("level"); index0++) {
			spellname = spellname + "*";
		}
		return slotnumber + ": " + spellname;
	}
}
