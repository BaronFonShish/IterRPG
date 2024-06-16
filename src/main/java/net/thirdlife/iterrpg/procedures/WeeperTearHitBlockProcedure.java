package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class WeeperTearHitBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), (x + 0.5), (y + 1), (z + 0.5), 4, 0.1, 0.1, 0.1, 0.05);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.splash")), SoundSource.NEUTRAL, (float) 0.5, 2);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.splash")), SoundSource.NEUTRAL, (float) 0.5, 2, false);
			}
		}
		entity.clearFire();
	}
}
