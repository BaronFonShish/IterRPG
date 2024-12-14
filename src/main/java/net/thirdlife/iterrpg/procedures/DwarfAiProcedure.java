package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;
import net.thirdlife.iterrpg.init.IterRpgModBlocks;
import net.thirdlife.iterrpg.entity.DwarfEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class DwarfAiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String order = "";
		double price = 0;
		double iteration = 0;
		double chance = 0;
		if (entity.getPersistentData().getDouble("tradetimer") < 12000) {
			entity.getPersistentData().putDouble("tradetimer", (entity.getPersistentData().getDouble("tradetimer") + 1));
		} else {
			entity.getPersistentData().putDouble("tradetimer", 0);
			if ((entity instanceof DwarfEntity _datEntI ? _datEntI.getEntityData().get(DwarfEntity.DATA_profession) : 0) == 1) {
				chance = Mth.nextInt(RandomSource.create(), 1, 16);
				if ((chance) > ((1 - 0.5)) && (chance) < ((5 + 0.5))) {
					entity.getPersistentData().putDouble("price1", 1);
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Blocks.COBBLESTONE.asItem()).toString()));
					entity.getPersistentData().putDouble("limit1", (Mth.nextInt(RandomSource.create(), 20, 40)));
				} else if ((chance) > ((5 - 0.5)) && (chance) < ((10 + 0.5))) {
					entity.getPersistentData().putDouble("price1", 1);
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Blocks.COBBLED_DEEPSLATE.asItem()).toString()));
					entity.getPersistentData().putDouble("limit1", (Mth.nextInt(RandomSource.create(), 20, 40)));
				} else if ((chance) > ((10 - 0.5)) && (chance) < ((12 + 0.5))) {
					entity.getPersistentData().putDouble("price1", 1);
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Blocks.GRANITE.asItem()).toString()));
					entity.getPersistentData().putDouble("limit1", (Mth.nextInt(RandomSource.create(), 16, 35)));
				} else if ((chance) > ((12 - 0.5)) && (chance) < ((14 + 0.5))) {
					entity.getPersistentData().putDouble("price1", 1);
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Blocks.ANDESITE.asItem()).toString()));
					entity.getPersistentData().putDouble("limit1", (Mth.nextInt(RandomSource.create(), 16, 35)));
				} else if ((chance) > ((14 - 0.5)) && (chance) < ((16 + 0.5))) {
					entity.getPersistentData().putDouble("price1", 1);
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Blocks.DIORITE.asItem()).toString()));
					entity.getPersistentData().putDouble("limit1", (Mth.nextInt(RandomSource.create(), 16, 35)));
				}
				chance = Mth.nextInt(RandomSource.create(), 1, 18);
				if ((chance) > ((1 - 0.5)) && (chance) < ((5 + 0.5))) {
					entity.getPersistentData().putDouble("price2", 1);
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(Blocks.TUFF.asItem()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 12, 20)));
				}
				if ((chance) > ((5 - 0.5)) && (chance) < ((10 + 0.5))) {
					entity.getPersistentData().putDouble("price2", 1);
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(Blocks.CALCITE.asItem()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 12, 20)));
				}
				if ((chance) > ((10 - 0.5)) && (chance) < ((12 + 0.5))) {
					entity.getPersistentData().putDouble("price2", 1);
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(Blocks.SMOOTH_BASALT.asItem()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 12, 20)));
				}
				if ((chance) > ((12 - 0.5)) && (chance) < ((14 + 0.5))) {
					entity.getPersistentData().putDouble("price2", 1);
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(Blocks.GRAVEL.asItem()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 12, 20)));
				}
				if ((chance) > ((14 - 0.5)) && (chance) < ((16 + 0.5))) {
					entity.getPersistentData().putDouble("price2", 1);
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(Blocks.CLAY.asItem()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 8, 12)));
				}
				if ((chance) > ((16 - 0.5)) && (chance) < ((18 + 0.5))) {
					entity.getPersistentData().putDouble("price2", 1);
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(Blocks.COARSE_DIRT.asItem()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 8, 12)));
				}
				chance = Mth.nextInt(RandomSource.create(), 1, 24);
				if ((chance) > ((1 - 0.5)) && (chance) < ((8 + 0.5))) {
					entity.getPersistentData().putDouble("price3", 1);
					entity.getPersistentData().putString("trade3", (ForgeRegistries.ITEMS.getKey(Items.COAL).toString()));
					entity.getPersistentData().putDouble("limit3", (Mth.nextInt(RandomSource.create(), 16, 24)));
				}
				if ((chance) > ((8 - 0.5)) && (chance) < ((14 + 0.5))) {
					entity.getPersistentData().putDouble("price3", (Mth.nextInt(RandomSource.create(), 1, 3)));
					entity.getPersistentData().putString("trade3", (ForgeRegistries.ITEMS.getKey(Items.RAW_IRON).toString()));
					entity.getPersistentData().putDouble("limit3", (Mth.nextInt(RandomSource.create(), 12, 18)));
				}
				if ((chance) > ((14 - 0.5)) && (chance) < ((20 + 0.5))) {
					entity.getPersistentData().putDouble("price3", 1);
					entity.getPersistentData().putString("trade3", (ForgeRegistries.ITEMS.getKey(Items.RAW_COPPER).toString()));
					entity.getPersistentData().putDouble("limit3", (Mth.nextInt(RandomSource.create(), 16, 24)));
				}
				if ((chance) > ((20 - 0.5)) && (chance) < ((24 + 0.5))) {
					entity.getPersistentData().putDouble("price3", (Mth.nextInt(RandomSource.create(), 2, 3)));
					entity.getPersistentData().putString("trade3", (ForgeRegistries.ITEMS.getKey(Items.RAW_GOLD).toString()));
					entity.getPersistentData().putDouble("limit3", (Mth.nextInt(RandomSource.create(), 8, 12)));
				}
				chance = Mth.nextInt(RandomSource.create(), 1, 24);
				if ((chance) > ((1 - 0.5)) && (chance) < ((8 + 0.5))) {
					entity.getPersistentData().putDouble("price4", (Mth.nextInt(RandomSource.create(), 1, 2)));
					entity.getPersistentData().putString("trade4", (ForgeRegistries.ITEMS.getKey(Items.REDSTONE).toString()));
					entity.getPersistentData().putDouble("limit4", (Mth.nextInt(RandomSource.create(), 12, 20)));
				}
				if ((chance) > ((8 - 0.5)) && (chance) < ((14 + 0.5))) {
					entity.getPersistentData().putDouble("price4", (Mth.nextInt(RandomSource.create(), 1, 2)));
					entity.getPersistentData().putString("trade4", (ForgeRegistries.ITEMS.getKey(Items.LAPIS_LAZULI).toString()));
					entity.getPersistentData().putDouble("limit4", (Mth.nextInt(RandomSource.create(), 12, 20)));
				}
				if ((chance) > ((14 - 0.5)) && (chance) < ((19 + 0.5))) {
					entity.getPersistentData().putDouble("price4", (Mth.nextInt(RandomSource.create(), 1, 2)));
					entity.getPersistentData().putString("trade4", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.ABYSSQUARTZ_SHARD.get()).toString()));
					entity.getPersistentData().putDouble("limit4", (Mth.nextInt(RandomSource.create(), 8, 16)));
				}
				if ((chance) > ((19 - 0.5)) && (chance) < ((24 + 0.5))) {
					entity.getPersistentData().putDouble("price4", (Mth.nextInt(RandomSource.create(), 1, 2)));
					entity.getPersistentData().putString("trade4", (ForgeRegistries.ITEMS.getKey(Items.AMETHYST_SHARD).toString()));
					entity.getPersistentData().putDouble("limit4", (Mth.nextInt(RandomSource.create(), 6, 12)));
				}
				chance = Mth.nextInt(RandomSource.create(), 1, 32);
				if ((chance) > ((1 - 0.5)) && (chance) < ((12 + 0.5))) {
					entity.getPersistentData().putDouble("price5", (Mth.nextInt(RandomSource.create(), 4, 6)));
					entity.getPersistentData().putString("trade5", (ForgeRegistries.ITEMS.getKey(Items.EMERALD).toString()));
					entity.getPersistentData().putDouble("limit5", (Mth.nextInt(RandomSource.create(), 6, 10)));
				}
				if ((chance) > ((12 - 0.5)) && (chance) < ((18 + 0.5))) {
					entity.getPersistentData().putDouble("price5", (Mth.nextInt(RandomSource.create(), 12, 16)));
					entity.getPersistentData().putString("trade5", (ForgeRegistries.ITEMS.getKey(Items.DIAMOND).toString()));
					entity.getPersistentData().putDouble("limit5", (Mth.nextInt(RandomSource.create(), 2, 6)));
				}
				if ((chance) > ((18 - 0.5)) && (chance) < ((22 + 0.5))) {
					entity.getPersistentData().putDouble("price5", (Mth.nextInt(RandomSource.create(), 2, 4)));
					entity.getPersistentData().putString("trade5", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.STONE_GEODE.get()).toString()));
					entity.getPersistentData().putDouble("limit5", (Mth.nextInt(RandomSource.create(), 1, 4)));
				}
				if ((chance) > ((22 - 0.5)) && (chance) < ((26 + 0.5))) {
					entity.getPersistentData().putDouble("price5", (Mth.nextInt(RandomSource.create(), 3, 5)));
					entity.getPersistentData().putString("trade5", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.DEEPSLATE_GEODE.get()).toString()));
					entity.getPersistentData().putDouble("limit5", (Mth.nextInt(RandomSource.create(), 1, 4)));
				}
				if ((chance) > ((26 - 0.5)) && (chance) < ((29 + 0.5))) {
					entity.getPersistentData().putDouble("price5", (Mth.nextInt(RandomSource.create(), 16, 32)));
					entity.getPersistentData().putString("trade5", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.SPAWNER_FRAGMENT.get()).toString()));
					entity.getPersistentData().putDouble("limit5", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((30 - 0.5)) && (chance) < ((31 + 0.5))) {
					entity.getPersistentData().putDouble("price5", (Mth.nextInt(RandomSource.create(), 50, 75)));
					entity.getPersistentData().putString("trade5", (ForgeRegistries.ITEMS.getKey(IterRpgModBlocks.GEODITE.get().asItem()).toString()));
					entity.getPersistentData().putDouble("limit5", 1);
				}
				if ((chance) > ((31 - 0.5)) && (chance) < ((32 + 0.5))) {
					entity.getPersistentData().putDouble("price5", (Mth.nextInt(RandomSource.create(), 60, 90)));
					entity.getPersistentData().putString("trade5", (ForgeRegistries.ITEMS.getKey(IterRpgModBlocks.DEEPSLATE_GEODITE.get().asItem()).toString()));
					entity.getPersistentData().putDouble("limit5", 1);
				}
			}
			if ((entity instanceof DwarfEntity _datEntI ? _datEntI.getEntityData().get(DwarfEntity.DATA_profession) : 0) == 2) {
				iteration = 1;
				chance = Mth.nextInt(RandomSource.create(), 1, 19);
				if ((chance) > ((1 - 0.5)) && (chance) < ((6 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 1);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.ROTTEN_FLESH).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 4, 8)));
				}
				if ((chance) > ((6 - 0.5)) && (chance) < ((10 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 1);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.BONE).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 4, 8)));
				}
				if ((chance) > ((10 - 0.5)) && (chance) < ((14 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 1);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.STRING).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 4, 6)));
				}
				if ((chance) > ((14 - 0.5)) && (chance) < ((19 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 2, 3)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.GUNPOWDER).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 4, 6)));
				}
				iteration = 2;
				chance = Mth.nextInt(RandomSource.create(), 1, 19);
				if ((chance) > ((1 - 0.5)) && (chance) < ((6 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 1);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.ROTTEN_FLESH).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 4, 8)));
				}
				if ((chance) > ((6 - 0.5)) && (chance) < ((10 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 1);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.BONE).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 4, 8)));
				}
				if ((chance) > ((10 - 0.5)) && (chance) < ((14 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 1);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.STRING).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 4, 6)));
				}
				if ((chance) > ((14 - 0.5)) && (chance) < ((19 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 2, 3)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.GUNPOWDER).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 4, 6)));
				}
				iteration = 3;
				chance = Mth.nextInt(RandomSource.create(), 1, 12);
				if ((chance) > ((1 - 0.5)) && (chance) < ((5 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 1, 2)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.SPIDER_EYE).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 2, 8)));
				}
				if ((chance) > ((5 - 0.5)) && (chance) < ((8 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 5, 8)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(IterRpgModItems.SPIDER_SILK.get()).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 1, 4)));
				}
				if ((chance) > ((8 - 0.5)) && (chance) < ((12 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 8, 12)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.ENDER_PEARL).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
			}
			if ((entity instanceof DwarfEntity _datEntI ? _datEntI.getEntityData().get(DwarfEntity.DATA_profession) : 0) == 3) {
				chance = Mth.nextInt(RandomSource.create(), 1, 20);
				if ((chance) > ((1 - 0.5)) && (chance) < ((4 + 0.5))) {
					entity.getPersistentData().putDouble("price1", (Mth.nextInt(RandomSource.create(), 2, 5)));
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Items.IRON_HELMET).toString()));
					entity.getPersistentData().putDouble("limit1", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((4 - 0.5)) && (chance) < ((8 + 0.5))) {
					entity.getPersistentData().putDouble("price1", (Mth.nextInt(RandomSource.create(), 4, 8)));
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Items.IRON_CHESTPLATE).toString()));
					entity.getPersistentData().putDouble("limit1", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((8 - 0.5)) && (chance) < ((12 + 0.5))) {
					entity.getPersistentData().putDouble("price1", (Mth.nextInt(RandomSource.create(), 3, 7)));
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Items.IRON_LEGGINGS).toString()));
					entity.getPersistentData().putDouble("limit1", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((12 - 0.5)) && (chance) < ((16 + 0.5))) {
					entity.getPersistentData().putDouble("price1", (Mth.nextInt(RandomSource.create(), 2, 4)));
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Items.IRON_BOOTS).toString()));
					entity.getPersistentData().putDouble("limit1", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((16 - 0.5)) && (chance) < ((17 + 0.5))) {
					entity.getPersistentData().putDouble("price1", (Mth.nextInt(RandomSource.create(), 3, 5) * 3));
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Items.CHAINMAIL_HELMET).toString()));
					entity.getPersistentData().putDouble("limit1", 1);
				}
				if ((chance) > ((17 - 0.5)) && (chance) < ((18 + 0.5))) {
					entity.getPersistentData().putDouble("price1", (Mth.nextInt(RandomSource.create(), 4, 8) * 3));
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Items.CHAINMAIL_CHESTPLATE).toString()));
					entity.getPersistentData().putDouble("limit1", 1);
				}
				if ((chance) > ((18 - 0.5)) && (chance) < ((19 + 0.5))) {
					entity.getPersistentData().putDouble("price1", (Mth.nextInt(RandomSource.create(), 4, 7) * 3));
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Items.CHAINMAIL_LEGGINGS).toString()));
					entity.getPersistentData().putDouble("limit1", 1);
				}
				if ((chance) > ((19 - 0.5)) && (chance) < ((20 + 0.5))) {
					entity.getPersistentData().putDouble("price1", (Mth.nextInt(RandomSource.create(), 2, 4) * 3));
					entity.getPersistentData().putString("trade1", (ForgeRegistries.ITEMS.getKey(Items.CHAINMAIL_BOOTS).toString()));
					entity.getPersistentData().putDouble("limit1", 1);
				}
				iteration = 2;
				chance = Mth.nextInt(RandomSource.create(), 1, 32);
				if ((chance) > ((1 - 0.5)) && (chance) < ((4 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 2, 4)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(Items.IRON_SWORD).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((4 - 0.5)) && (chance) < ((6 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 6, 12)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(Items.DIAMOND_SWORD).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((6 - 0.5)) && (chance) < ((10 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 2, 3)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.IRON_DAGGER.get()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((10 - 0.5)) && (chance) < ((14 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 6, 9)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.DIAMOND_DAGGER.get()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((14 - 0.5)) && (chance) < ((18 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 2, 5)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.IRON_SPEAR.get()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((18 - 0.5)) && (chance) < ((20 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 7, 15)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.DIAMOND_SPEAR.get()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((20 - 0.5)) && (chance) < ((24 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 2, 4)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.IRON_SCYTHE.get()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((24 - 0.5)) && (chance) < ((26 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 6, 12)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.DIAMOND_SCYTHE.get()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((26 - 0.5)) && (chance) < ((30 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 4, 8)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.IRON_FLAIL.get()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				if ((chance) > ((30 - 0.5)) && (chance) < ((32 + 0.5))) {
					entity.getPersistentData().putDouble("price2", (Mth.nextInt(RandomSource.create(), 12, 24)));
					entity.getPersistentData().putString("trade2", (ForgeRegistries.ITEMS.getKey(IterRpgModItems.DIAMOND_FLAIL.get()).toString()));
					entity.getPersistentData().putDouble("limit2", (Mth.nextInt(RandomSource.create(), 1, 2)));
				}
				iteration = 3;
				chance = Mth.nextInt(RandomSource.create(), 1, 24);
				if ((chance) > ((1 - 0.5)) && (chance) < ((6 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 2);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.FLINT_AND_STEEL).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), 1);
				}
				if ((chance) > ((7 - 0.5)) && (chance) < ((12 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 8, 16)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(IterRpgModBlocks.DRILL.get().asItem()).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), 1);
				}
				if ((chance) > ((13 - 0.5)) && (chance) < ((16 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 2);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.MINECART).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), 1);
				}
				if ((chance) > ((17 - 0.5)) && (chance) < ((20 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 2);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.COMPASS).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), 1);
				}
				if ((chance) > ((21 - 0.5)) && (chance) < ((24 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 3);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(Items.CLOCK).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), 1);
				}
				iteration = 4;
				chance = Mth.nextInt(RandomSource.create(), 1, 14);
				if (chance == 1) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 20, 25)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(IterRpgModItems.DEEPSTEEL_SWORD.get()).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), 1);
				}
				if (chance == 2) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 20, 25)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(IterRpgModItems.DEEPSTEEL_PICKAXE.get()).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), 1);
				}
				if (chance == 3) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 20, 25)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(IterRpgModItems.DEEPSTEEL_AXE.get()).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), 1);
				}
				if ((chance) > ((4 - 0.5)) && (chance) < ((10 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 5, 10)));
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(IterRpgModItems.DEEPSTEEL_INGOT.get()).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 1, 4)));
				}
				if ((chance) > ((11 - 0.5)) && (chance) < ((14 + 0.5))) {
					entity.getPersistentData().putDouble(("price" + Math.round(iteration)), 1);
					entity.getPersistentData().putString(("trade" + Math.round(iteration)), (ForgeRegistries.ITEMS.getKey(IterRpgModItems.GOBSTEEL_SCRAP.get()).toString()));
					entity.getPersistentData().putDouble(("limit" + Math.round(iteration)), (Mth.nextInt(RandomSource.create(), 6, 8)));
				}
			}
		}
	}
}
