package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

public class WardCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double power = 0;
		double cooldown = 0;
		double mana = 0;
		power = WandReturnPowerProcedure.execute(entity);
		if (entity.isAlive()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int) (600 * power), 0));
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ENCHANT, x, (y + entity.getBbHeight() / 2), z, 16, 0.3, 0.5, 0.3, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ARCANE_PARTICLE.get()), x, (y + entity.getBbHeight() / 2), z, 8, 0.3, 0.5, 0.3, 0);
	}
}
