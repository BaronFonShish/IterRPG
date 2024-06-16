package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class GrimLockerArrow4Procedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		ItemStack item = ItemStack.EMPTY;
		ItemStack fuel = ItemStack.EMPTY;
		ItemStack bottle = ItemStack.EMPTY;
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "tears") > 72 && new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "tears") <= 96) {
			return true;
		}
		return false;
	}
}
