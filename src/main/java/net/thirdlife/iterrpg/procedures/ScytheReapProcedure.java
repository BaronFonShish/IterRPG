package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

public class ScytheReapProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		BlockState crop = Blocks.AIR.defaultBlockState();
		double xstart = 0;
		double zstart = 0;
		double yconst = 0;
		double repeatamount = 0;
		double xorig = 0;
		if (blockstate.getBlock() == Blocks.WHEAT && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 7
				|| blockstate.getBlock() == Blocks.CARROTS && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip7 ? blockstate.getValue(_getip7) : -1) == 7
				|| blockstate.getBlock() == Blocks.POTATOES && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip11 ? blockstate.getValue(_getip11) : -1) == 7
				|| blockstate.getBlock() == Blocks.BEETROOTS && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip15 ? blockstate.getValue(_getip15) : -1) == 3
				|| blockstate.getBlock() == Blocks.NETHER_WART && ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip19
						? (world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getValue(_getip19)
						: -1) == 3) {
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.OFF_HAND, true);
			}
			if (itemstack.getItem() == IterRpgModItems.WOODEN_SCYTHE.get() || itemstack.getItem() == IterRpgModItems.STONE_SCYTHE.get()) {
				xstart = 0;
				zstart = 0;
				repeatamount = 1;
			}
			if (itemstack.getItem() == IterRpgModItems.IRON_SCYTHE.get() || itemstack.getItem() == IterRpgModItems.AMETRINE_SCYTHE.get() || itemstack.getItem() == IterRpgModItems.GOLDEN_SCYTHE.get()
					|| itemstack.getItem() == IterRpgModItems.DIAMOND_SCYTHE.get() || itemstack.getItem() == IterRpgModItems.NETHERITE_SCYTHE.get()) {
				xstart = -1;
				zstart = -1;
				repeatamount = 3;
			}
			if (itemstack.getItem() == IterRpgModItems.HARVEST.get()) {
				xstart = -2;
				zstart = -2;
				repeatamount = 5;
			}
			xorig = xstart;
			for (int index0 = 0; index0 < (int) repeatamount; index0++) {
				for (int index1 = 0; index1 < (int) repeatamount; index1++) {
					if ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock() == Blocks.WHEAT
							&& ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip47
									? (world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getValue(_getip47)
									: -1) == 7) {
						{
							BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xstart + 0.5, y + 0.25, z + zstart + 0.5), null);
							world.destroyBlock(_pos, false);
						}
						if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.WHEAT_SEEDS)) : false) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Items.WHEAT_SEEDS);
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							world.setBlock(BlockPos.containing(x + xstart, y, z + zstart), Blocks.WHEAT.defaultBlockState(), 3);
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock() == Blocks.POTATOES
							&& ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip56
									? (world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getValue(_getip56)
									: -1) == 7) {
						{
							BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xstart + 0.5, y + 0.25, z + zstart + 0.5), null);
							world.destroyBlock(_pos, false);
						}
						if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.POTATO)) : false) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Items.POTATO);
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							world.setBlock(BlockPos.containing(x + xstart, y, z + zstart), Blocks.POTATOES.defaultBlockState(), 3);
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock() == Blocks.CARROTS
							&& ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip65
									? (world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getValue(_getip65)
									: -1) == 7) {
						{
							BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xstart + 0.5, y + 0.25, z + zstart + 0.5), null);
							world.destroyBlock(_pos, false);
						}
						if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.CARROT)) : false) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Items.CARROT);
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							world.setBlock(BlockPos.containing(x + xstart, y, z + zstart), Blocks.CARROTS.defaultBlockState(), 3);
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock() == Blocks.BEETROOTS
							&& ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip74
									? (world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getValue(_getip74)
									: -1) == 3) {
						{
							BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xstart + 0.5, y + 0.25, z + zstart + 0.5), null);
							world.destroyBlock(_pos, false);
						}
						if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.BEETROOT_SEEDS)) : false) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Items.BEETROOT_SEEDS);
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							world.setBlock(BlockPos.containing(x + xstart, y, z + zstart), Blocks.BEETROOTS.defaultBlockState(), 3);
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock() == Blocks.NETHER_WART
							&& ((world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip83
									? (world.getBlockState(BlockPos.containing(x + xstart, y, z + zstart))).getValue(_getip83)
									: -1) == 3) {
						{
							BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xstart + 0.5, y + 0.25, z + zstart + 0.5), null);
							world.destroyBlock(_pos, false);
						}
						if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.NETHER_WART)) : false) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Items.NETHER_WART);
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							world.setBlock(BlockPos.containing(x + xstart, y, z + zstart), Blocks.NETHER_WART.defaultBlockState(), 3);
							{
								int _value = 0;
								BlockPos _pos = BlockPos.containing(x + xstart, y, z + zstart);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
									world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
							}
						}
					}
					xstart = xstart + 1;
				}
				xstart = xorig;
				zstart = zstart + 1;
			}
		}
	}
}
