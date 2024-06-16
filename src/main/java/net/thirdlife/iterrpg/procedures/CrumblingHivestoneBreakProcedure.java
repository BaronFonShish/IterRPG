package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class CrumblingHivestoneBreakProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xpos = 0;
		double zpos = 0;
		if (entity instanceof Player && !entity.isShiftKeyDown()) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			for (int index0 = 0; index0 < 8; index0++) {
				xpos = Mth.nextInt(RandomSource.create(), -1, 1);
				zpos = Mth.nextInt(RandomSource.create(), -1, 1);
				if ((world.getBlockState(BlockPos.containing(x + xpos, y, z + zpos))).getBlock() == IterRpgModBlocks.CRUMBLING_HIVESTONE.get()) {
					world.destroyBlock(BlockPos.containing(x + xpos, y, z + zpos), false);
					if (world instanceof Level _level)
						_level.updateNeighborsAt(BlockPos.containing(x + xpos, y, z + zpos), _level.getBlockState(BlockPos.containing(x + xpos, y, z + zpos)).getBlock());
				}
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		}
	}
}
