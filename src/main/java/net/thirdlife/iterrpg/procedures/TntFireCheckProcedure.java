package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class TntFireCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y + Mth.nextInt(RandomSource.create(), -1, 1), z + Mth.nextInt(RandomSource.create(), -1, 1)))).getBlock() == Blocks.SOUL_FIRE
				|| (world.getBlockState(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y + Mth.nextInt(RandomSource.create(), -1, 1), z + Mth.nextInt(RandomSource.create(), -1, 1)))).getBlock() == Blocks.FIRE) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("ignite", (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ignite") + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y + Mth.nextInt(RandomSource.create(), -1, 1), z + Mth.nextInt(RandomSource.create(), -1, 1)))).getBlock() == Blocks.WATER
				|| (world.getBlockState(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y + Mth.nextInt(RandomSource.create(), -1, 1), z + Mth.nextInt(RandomSource.create(), -1, 1)))).getBlock() == Blocks.WATER
				|| (world.getBlockState(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y + Mth.nextInt(RandomSource.create(), -1, 1), z + Mth.nextInt(RandomSource.create(), -1, 1)))).getBlock() == Blocks.WET_SPONGE
				|| (world.getBlockState(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y + Mth.nextInt(RandomSource.create(), -1, 1), z + Mth.nextInt(RandomSource.create(), -1, 1)))).getBlock() == Blocks.ICE) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("ignite", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ignite") > 0) {
			if (Mth.nextDouble(RandomSource.create(), 2, 32) < new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "ignite")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("ignite", (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "ignite") + 0.25));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ignite") >= 2) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, (x + 0.5), (y + 1.05), (z + 0.5), Mth.nextInt(RandomSource.create(), 1, 2), 0.15, 0.15, 0.15, 0.015);
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ignite") >= 4) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 0.5), (y + 1.05), (z + 0.5), Mth.nextInt(RandomSource.create(), 1, 2), 0.15, 0.15, 0.15, 0.015);
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ignite") >= 8) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + 0.5), (y + 1.05), (z + 0.5), Mth.nextInt(RandomSource.create(), 1, 2), 0.15, 0.15, 0.15, 0.015);
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ignite") >= 12) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 1.05), (z + 0.5), Mth.nextInt(RandomSource.create(), 1, 2), 0.25, 0.15, 0.25, 0.015);
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ignite") >= 16) {
			TntBarrelExplosionProcedure.execute(world, x, y, z);
		}
	}
}
