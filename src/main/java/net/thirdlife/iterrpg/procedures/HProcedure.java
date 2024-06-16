package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class HProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double gobamount = 0;
		double hobgob = 0;
		double gob = 0;
		double gobwar = 0;
		double gobpoints = 0;
		double decide = 0;
		double xc = 0;
		double zc = 0;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("respawnTime", 14000);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
