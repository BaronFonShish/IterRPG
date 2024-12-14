package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

public class ReturnSpellNumberProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		ItemStack wand = ItemStack.EMPTY;
		ItemStack spell = ItemStack.EMPTY;
		ItemStack spellbook = ItemStack.EMPTY;
		double cooldown = 0;
		double slot = 0;
		boolean valid = false;
		boolean book = false;
		String spellname = "";
		String spellbookaddition = "";
		spell = ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SpellItem);
		if (spell.is(ItemTags.create(new ResourceLocation("iter_rpg:spell_scrolls"))) || spell.is(ItemTags.create(new ResourceLocation("iter_rpg:primitive_spells")))) {
			valid = true;
		} else {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("iter_rpg:special_spellcasts")))) {
				spellname = Component.translatable(((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()) + ".specialspell")).getString();
			} else {
				spellname = "Empty";
			}
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
			} else if (spell.getItem() == IterRpgModItems.SPELL_EMBERS.get()) {
				spellname = Component.translatable("iterpg.spell.embers").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_SCRIBBLES.get()) {
				spellname = Component.translatable("iterpg.spell.scribbles").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_DROPLETS.get()) {
				spellname = Component.translatable("iterpg.spell.droplets").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_ZAP.get()) {
				spellname = Component.translatable("iterpg.spell.zap").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_POISON_GAS.get()) {
				spellname = Component.translatable("iterpg.spell.poison_gas").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_SHADELASH.get()) {
				spellname = Component.translatable("iterpg.spell.shade_lash").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_FLAMEBOLT.get()) {
				spellname = Component.translatable("iterpg.spell.flamebolt").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_VOIDBEAM.get()) {
				spellname = Component.translatable("iterpg.spell.voidbeam").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_FROST_SPIKE.get()) {
				spellname = Component.translatable("iterpg.spell.frost_spike").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_RECALL.get()) {
				spellname = Component.translatable("iterpg.spell.recall").getString();
			}
			if (spell.getItem() == IterRpgModItems.SPELL_MEND.get()) {
				spellname = Component.translatable("iterpg.spell.mend").getString();
			}
		}
		for (int index0 = 0; index0 < (int) spell.getOrCreateTag().getDouble("level"); index0++) {
			spellname = spellname + "*";
		}
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).spellbook) {
			spellbookaddition = Math.round((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).SelectedSpell) + ": ";
		} else {
			spellbookaddition = "";
		}
		if (entity instanceof Player _plrCldCheck46 && _plrCldCheck46.getCooldowns().isOnCooldown(spell.getItem())) {
			return spellbookaddition + "" + spellname + (" [" + Math.round(entity instanceof Player _plrCldRem47 ? _plrCldRem47.getCooldowns().getCooldownPercent(spell.getItem(), 0f) * 100 : 0) + "]");
		}
		return spellbookaddition + "" + spellname;
	}
}
