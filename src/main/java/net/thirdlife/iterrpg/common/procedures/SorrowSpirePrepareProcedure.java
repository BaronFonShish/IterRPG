package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SorrowSpirePrepareProcedure {
	public static void execute(LevelAccessor world, double x, double z) {
		world.setBlock(BlockPos.containing(x, 35, z), IterRpgModBlocks.SORROW_SPIRE_GEN_BLOCK.get().defaultBlockState(), 3);
		world.scheduleTick(BlockPos.containing(x, 35, z), world.getBlockState(BlockPos.containing(x, 35, z)).getBlock(), 20);
	}
}
