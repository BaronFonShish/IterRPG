package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.network.IterRpgModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class OceanArmorSetBonusProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double chance = 0;
		if (entity instanceof Player) {
			if (entity.isUnderWater() && !entity.isSwimming() && (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).ElementalArmorCooldown <= 1
					&& entity.getAirSupply() < 290) {
				entity.setAirSupply((int) (entity.getAirSupply() + 10));
				{
					double _setval = 8;
					entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ElementalArmorCooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.BUBBLE, x, (y + 1), z, 8, 0.5, 1, 0.5, 0.025);
			}
			if (entity.isUnderWater() && entity.isSwimming()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2, 0, false, true));
			}
		}
	}
}
