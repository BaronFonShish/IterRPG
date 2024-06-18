package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class RunicHivestoneHatchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		for (int index0 = 0; index0 < 64; index0++) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANT, (x + 0.5), (y + 0.5), (z + 0.5), 1, 0.25, 0.25, 0.25, 0);
			xpos = Mth.nextInt(RandomSource.create(), -6, 6);
			ypos = Mth.nextInt(RandomSource.create(), -3, 3);
			zpos = Mth.nextInt(RandomSource.create(), -6, 6);
			if ((world.getBlockState(BlockPos.containing(x + xpos, y + ypos, z + zpos))).getBlock() == IterRpgModBlocks.SPIDER_EGG.get()) {
				SpiderEggMagicHatchProcedure.execute(world, (x + xpos), (y + ypos), (z + zpos));
			}
		}
	}
}
