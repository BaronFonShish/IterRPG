package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MonolithDoorActivateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double i = 0;
		double j = 0;
		double k = 0;
		boolean earth = false;
		boolean water = false;
		boolean air = false;
		boolean fire = false;
		boolean elemvoid = false;
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 0) {
			earth = false;
			water = false;
			air = false;
			fire = false;
			elemvoid = false;
			i = -5;
			for (int index0 = 0; index0 < 11; index0++) {
				j = -5;
				for (int index1 = 0; index1 < 11; index1++) {
					k = -5;
					for (int index2 = 0; index2 < 11; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + i, y + j, z + k))) == (new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(IterRpgModBlocks.EARTH_RUNESTONE.get().defaultBlockState(), "blockstate", 1))) {
							earth = true;
						}
						if ((world.getBlockState(BlockPos.containing(x + i, y + j, z + k))) == (new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(IterRpgModBlocks.WATER_RUNESTONE.get().defaultBlockState(), "blockstate", 1))) {
							water = true;
						}
						if ((world.getBlockState(BlockPos.containing(x + i, y + j, z + k))) == (new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(IterRpgModBlocks.AIR_RUNESTONE.get().defaultBlockState(), "blockstate", 1))) {
							air = true;
						}
						if ((world.getBlockState(BlockPos.containing(x + i, y + j, z + k))) == (new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(IterRpgModBlocks.FIRE_RUNESTONE.get().defaultBlockState(), "blockstate", 1))) {
							fire = true;
						}
						if ((world.getBlockState(BlockPos.containing(x + i, y + j, z + k))) == (new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with(IterRpgModBlocks.VOID_RUNESTONE.get().defaultBlockState(), "blockstate", 1))) {
							elemvoid = true;
						}
						k = k + 1;
					}
					j = j + 1;
				}
				i = i + 1;
			}
			if (earth && water && air && fire && elemvoid) {
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
		}
	}
}
