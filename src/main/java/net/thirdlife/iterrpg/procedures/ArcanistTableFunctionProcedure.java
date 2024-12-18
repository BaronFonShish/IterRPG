package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;
import java.util.Map;

public class ArcanistTableFunctionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack initial = ItemStack.EMPTY;
		ItemStack output = ItemStack.EMPTY;
		ItemStack resource1 = ItemStack.EMPTY;
		ItemStack resource2 = ItemStack.EMPTY;
		ItemStack resource3 = ItemStack.EMPTY;
		double chance = 0;
		initial = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
		output = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY);
		resource1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY);
		resource2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY);
		resource3 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY);
		if (output.getItem() == ItemStack.EMPTY.getItem()) {
			if (initial.getItem() == IterRpgModItems.UNIDENTIFIED_SPELL.get()) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 5) {
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(0)).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					if (!world.isClientSide() && world.getServer() != null) {
						for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("iter_rpg:gameplay/spell_roll"))
								.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = itemstackiterator.copy();
								_setstack.setCount(1);
								((Slot) _slots.get(4)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
							if (Math.random() < (1) / ((float) 5)) {
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("level",
										1);
							} else {
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("level",
										0);
							}
						}
					}
				}
			}
			if (initial.is(ItemTags.create(new ResourceLocation("iter_rpg:spell_scrolls"))) && resource1.getItem() == IterRpgModItems.ENCHANTED_PAGE.get() && resource2.getItem() == IterRpgModItems.INK_BOTTLE.get()
					&& resource3.getItem() == IterRpgModItems.GIST.get() && resource3.getCount() >= 3) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 5) {
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(1)).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(2)).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(3)).remove(3);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = initial.copy();
						_setstack.setCount(1);
						((Slot) _slots.get(4)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("level", 0);
				}
			}
			if (initial.is(ItemTags.create(new ResourceLocation("iter_rpg:spell_scrolls"))) && !initial.is(ItemTags.create(new ResourceLocation("iter_rpg:spell_no_leveling"))) && resource1.getItem() == initial.getItem()
					&& initial.getOrCreateTag().getDouble("level") == resource1.getOrCreateTag().getDouble("level") && (initial.getOrCreateTag().getDouble("level") == 0 && resource2.getItem() == Items.LAPIS_LAZULI
							|| initial.getOrCreateTag().getDouble("level") == 1 && resource2.getItem() == Items.DIAMOND || initial.getOrCreateTag().getDouble("level") == 2 && resource2.getItem() == IterRpgModItems.ESSENCE_OF_CREATION.get())
					&& resource3.getItem() == IterRpgModItems.GIST.get() && resource3.getCount() >= 3) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 5) {
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = initial.copy();
						_setstack.setCount(1);
						((Slot) _slots.get(4)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("level",
							(initial.getOrCreateTag().getDouble("level") + 1));
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(0)).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(1)).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(2)).remove(1);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(3)).remove(3);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}
}
