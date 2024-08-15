package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

public class ChaosApparitionExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, (y + 0.25), z, 8, 0.2, 0.2, 0.2, 0.05);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEM_FLAME.get()), x, (y + 0.25), z, 8, 0.2, 0.2, 0.2, 0.05);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LAVA, x, (y + 0.25), z, 8, 0.2, 0.2, 0.2, 0.05);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.25), z, 12, 0.2, 0.2, 0.2, 0.05);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, (y + 0.25), z, (float) 0.1, Level.ExplosionInteraction.NONE);
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
