package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;
import java.util.Map;

public class ArcanistTableButtonConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
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
			if (initial.getItem() == IterRpgModItems.UNIDENTIFIED_SPELL.get() && resource1.getItem() == Items.PAPER && resource2.getItem() == Items.INK_SAC && resource3.getItem() == ItemStack.EMPTY.getItem()) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 5) {
					return true;
				}
			}
			if (initial.is(ItemTags.create(new ResourceLocation("iter_rpg:spell_scrolls"))) && resource1.getItem() == Items.PAPER && resource2.getItem() == Items.INK_SAC && resource3.getItem() == IterRpgModItems.GIST.get()
					&& resource3.getCount() >= 5) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 5) {
					return true;
				}
			}
			if (initial.is(ItemTags.create(new ResourceLocation("iter_rpg:spell_scrolls"))) && resource1.getItem() == initial.getItem() && initial.getOrCreateTag().getDouble("level") == resource1.getOrCreateTag().getDouble("level")
					&& (initial.getOrCreateTag().getDouble("level") == 0 && resource2.getItem() == Items.LAPIS_LAZULI || initial.getOrCreateTag().getDouble("level") == 1 && resource2.getItem() == Items.DIAMOND
							|| initial.getOrCreateTag().getDouble("level") == 2 && resource2.getItem() == Items.ENDER_EYE || initial.getOrCreateTag().getDouble("level") == 3 && resource2.getItem() == IterRpgModItems.ESSENCE_OF_CREATION.get())
					&& resource3.getItem() == IterRpgModItems.GIST.get() && resource3.getCount() >= 5) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 5) {
					return true;
				}
			}
		}
		return false;
	}
}
