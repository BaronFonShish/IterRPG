package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class RandomVasePlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double decide = 0;
		double chance = 0;
		chance = Mth.nextDouble(RandomSource.create(), 1, 12);
		if (chance <= 12 && chance >= 9) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z), IterRpgModBlocks.BIG_VASE.get().defaultBlockState(), 3);
		} else if (chance <= 9 && chance >= 5) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z), IterRpgModBlocks.VASE.get().defaultBlockState(), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z), IterRpgModBlocks.SMALL_VASE.get().defaultBlockState(), 3);
		}
	}
}
