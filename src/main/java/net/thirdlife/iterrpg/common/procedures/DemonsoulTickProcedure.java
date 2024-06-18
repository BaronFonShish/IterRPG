package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class DemonsoulTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		if (entity.getPersistentData().getDouble("deathtimer") >= 666) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, (y + 0.25), z, 32, 0.5, 0.5, 0.5, 0.025);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, (y + 0.25), z, 24, 0.5, 0.5, 0.5, 0.025);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, (y + 0.25), z, 16, 0.5, 0.5, 0.5, 0.025);
			for (int index0 = 0; index0 < 16; index0++) {
				xpos = Mth.nextInt(RandomSource.create(), -6, 6);
				ypos = Mth.nextInt(RandomSource.create(), -6, 6);
				zpos = Mth.nextInt(RandomSource.create(), -6, 6);
				if ((world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos))).getBlock() == Blocks.NETHERRACK) {
					world.setBlock(BlockPos.containing(x + xpos, y + ypos, z + zpos), IterRpgModBlocks.MAGMANUM_ORE.get().defaultBlockState(), 3);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.getPersistentData().putDouble("deathtimer", (entity.getPersistentData().getDouble("deathtimer") + 1));
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, x, (y + 0.25), z, 1, 0.2, 0.2, 0.2, 0.025);
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.DEMONBLOOD.get()), x, (y + 0.25), z, 1, 0.2, 0.2, 0.2, 0.025);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.25), z, 1, 0.2, 0.2, 0.2, 0.025);
		}
	}
}
