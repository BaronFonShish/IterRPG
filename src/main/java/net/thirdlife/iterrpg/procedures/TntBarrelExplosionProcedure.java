package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class TntBarrelExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, (x + 0.5), (y + 0.5), (z + 0.5), 5, Level.ExplosionInteraction.TNT);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + 0.5), (y + 0.5), (z + 0.5), 64, 1.25, 1.25, 1.25, (Mth.nextDouble(RandomSource.create(), 0.1, 0.25)));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 0.5), (z + 0.5), 64, 1.25, 1.25, 1.25, (Mth.nextDouble(RandomSource.create(), 0.1, 0.25)));
	}
}
