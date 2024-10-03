package net.thirdlife.iterrpg.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

public class SpellIdentifyProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack initial = ItemStack.EMPTY;
		ItemStack output = ItemStack.EMPTY;
		ItemStack resource1 = ItemStack.EMPTY;
		ItemStack resource2 = ItemStack.EMPTY;
		ItemStack resource3 = ItemStack.EMPTY;
		double chance = 0;
		itemstack.shrink(1);
		if (!world.isClientSide() && world.getServer() != null) {
			for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("iter_rpg:gameplay/spell_roll")).getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = itemstackiterator.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
	}
}
