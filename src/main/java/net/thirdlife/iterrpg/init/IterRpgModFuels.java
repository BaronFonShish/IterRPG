
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class IterRpgModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == IterRpgModBlocks.SACRED_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == IterRpgModBlocks.SACRED_WOOD.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == IterRpgModBlocks.SACRED_PLANKS.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == IterRpgModBlocks.SACRED_LEAVES.get().asItem())
			event.setBurnTime(50);
		else if (itemstack.getItem() == IterRpgModBlocks.STRIPPED_SACRED_LOG.get().asItem())
			event.setBurnTime(300);
		else if (itemstack.getItem() == IterRpgModItems.MAGMANUM_CHUNK.get())
			event.setBurnTime(6400);
	}
}
