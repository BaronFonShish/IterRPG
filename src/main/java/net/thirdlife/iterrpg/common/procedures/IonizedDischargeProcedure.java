package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModMobEffects;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

public class IonizedDischargeProcedure {
	public static void execute(LevelAccessor world, Entity entity, double amplifier) {
		if (entity == null)
			return;
		Entity target = null;
		double mobamount = 0;
		double chosen = 0;
		double distance = 0;
		entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LIGHTNING_BOLT)), (float) (2.5 * (amplifier + 1)));
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() * 0.48), (entity.getZ()), 16, (entity.getBbWidth() / 3), (entity.getBbHeight() / 4),
					(entity.getBbWidth() / 3), 0.05);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(IterRpgModMobEffects.IONIZED.get());
	}
}
