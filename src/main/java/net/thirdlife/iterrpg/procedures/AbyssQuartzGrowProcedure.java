package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class AbyssQuartzGrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double direction = 0;
		Direction direct = Direction.NORTH;
		if (Math.random() >= 0.92) {
			if (((world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == Blocks.BEDROCK || (world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == Blocks.BEDROCK
					|| (world.getBlockState(BlockPos.containing(x + 0, y + 0, z + 1))).getBlock() == Blocks.BEDROCK || (world.getBlockState(BlockPos.containing(x + 0, y + 0, z - 1))).getBlock() == Blocks.BEDROCK
					|| (world.getBlockState(BlockPos.containing(x + 0, y + 1, z + 0))).getBlock() == Blocks.BEDROCK || (world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 0))).getBlock() == Blocks.BEDROCK)
					&& (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD && y <= -58) {
				direct = Direction.getRandom(RandomSource.create());
				if (world.isEmptyBlock(BlockPos.containing(x + direct.getStepX(), y + direct.getStepY(), z + direct.getStepZ()))) {
					world.setBlock(BlockPos.containing(x + direct.getStepX(), y + direct.getStepY(), z + direct.getStepZ()), IterRpgModBlocks.ABYSS_QUARTZ.get().defaultBlockState(), 3);
					{
						Direction _dir = direct;
						BlockPos _pos = BlockPos.containing(x + direct.getStepX(), y + direct.getStepY(), z + direct.getStepZ());
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else {
							_property = _bs.getBlock().getStateDefinition().getProperty("axis");
							if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
								world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				}
			}
		}
	}
}
