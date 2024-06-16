package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class GrimKeyPassProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == IterRpgModBlocks.GRIM_KEYHOLE.get()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.VOID_AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 32, 0.25, 0.25, 0.25, 0.025);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == IterRpgModBlocks.CHARGED_GRIMSTONE_BRICKS.get()) {
			world.setBlock(BlockPos.containing(x, y, z), IterRpgModBlocks.GRIMSTONE_BRICKS.get().defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 32, 0.25, 0.25, 0.25, 0.025);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == IterRpgModBlocks.GRIM_SOULTRAP.get()) {
			world.setBlock(BlockPos.containing(x, y, z), IterRpgModBlocks.POLISHED_GRIMSTONE.get().defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 32, 0.25, 0.25, 0.25, 0.025);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == IterRpgModBlocks.BARRIER_PROJECTOR.get()) {
			world.setBlock(BlockPos.containing(x, y, z), IterRpgModBlocks.POLISHED_GRIMSTONE.get().defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 32, 0.25, 0.25, 0.25, 0.025);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == IterRpgModBlocks.GRIMACE_TRAP.get()) {
			world.setBlock(BlockPos.containing(x, y, z), IterRpgModBlocks.POLISHED_GRIMSTONE.get().defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 32, 0.25, 0.25, 0.25, 0.025);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == IterRpgModBlocks.SPIRE_SPAWNER.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == IterRpgModBlocks.GRAND_SPIRE_SPAWNER.get()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 32, 0.25, 0.25, 0.25, 0.025);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.BLOCKS, 1, (float) 0.5, false);
				}
			}
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		}
	}
}
