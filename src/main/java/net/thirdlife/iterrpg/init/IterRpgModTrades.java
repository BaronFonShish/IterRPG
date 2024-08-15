
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.thirdlife.iterrpg.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class IterRpgModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(IterRpgModItems.COIN.get(), 6),

				new ItemStack(Items.EMERALD), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

				new ItemStack(IterRpgModBlocks.TWIFFLE.get()), 2, 10, 0.3f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 12),

				new ItemStack(IterRpgModItems.EMPTY_RUNE.get()), 2, 5, 0.3f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 24),

				new ItemStack(IterRpgModBlocks.ARCANE_FLOWER_SEEDS.get()), 6, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 4),

				new ItemStack(IterRpgModItems.COIN.get(), 4), 10, 4, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 34),

				new ItemStack(IterRpgModBlocks.SACRED_SAPLING.get()), 2, 10, 0.15f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.FISHERMAN) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(IterRpgModItems.STARFISH.get()),

					new ItemStack(Items.EMERALD, 8), 2, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(IterRpgModItems.PEARL.get()),

					new ItemStack(Items.EMERALD, 16), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.CLERIC) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4),

					new ItemStack(IterRpgModItems.ETHER_DUST.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 4),

					new ItemStack(IterRpgModItems.ABYSSQUARTZ_SHARD.get(), 2), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.MASON) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2),

					new ItemStack(IterRpgModItems.POTSHERD.get()), 10, 4, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(IterRpgModItems.POTSHERD.get(), 4),

					new ItemStack(Items.EMERALD), 10, 5, 0.05f));
		}
	}
}
