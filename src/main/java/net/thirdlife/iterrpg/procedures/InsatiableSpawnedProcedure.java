package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.InsatiableEntity;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class InsatiableSpawnedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 5, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 5, false, false));
		if (entity instanceof InsatiableEntity) {
			((InsatiableEntity) entity).setAnimation("animation.insatiable.spawn");
		}
		entity.getPersistentData().putDouble("cooldown", 80);
		entity.getPersistentData().putDouble("decide", 0);
		IterRpgMod.queueServerWork(1, () -> {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 5, false, false));
			if (entity instanceof InsatiableEntity) {
				((InsatiableEntity) entity).setAnimation("animation.insatiable.spawn");
			}
			entity.getPersistentData().putDouble("cooldown", 80);
			entity.getPersistentData().putDouble("decide", 0);
		});
	}
}
