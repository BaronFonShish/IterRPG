
package net.thirdlife.iterrpg.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.thirdlife.iterrpg.procedures.PesteringWingsCooldownProcedure;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class FesteringWingsItem extends Item implements ICurioItem {
	public FesteringWingsItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		PesteringWingsCooldownProcedure.execute(slotContext.entity());
	}
}
