package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModMobEffects;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class StormcallerStrikeProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double attackpower = 0;
		double rotation = 0;
		double distance = 0;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double type = 0;
		double damage = 0;
		double repeat = 0;
		double mobamount = 0;
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY() + entity.getBbHeight() * 0.48), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
						&& !(sourceentity == entityiterator)) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 16, 2, false, true));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 8, 0, false, true));
				}
			}
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(IterRpgModMobEffects.IONIZED.get());
		if (entity.onGround()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(IterRpgModMobEffects.IONIZED.get(), 50, 1, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30, 2, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 2, false, true));
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(IterRpgModMobEffects.IONIZED.get(), 60, 5, false, true));
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.SLOW_FALLING);
			IterRpgMod.queueServerWork(5, () -> {
				entity.setDeltaMovement(new Vec3(0, 0.25, 0));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.AIR_SIGIL.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() * 0.48), (entity.getZ()), 8, (entity.getBbWidth() / 3), (entity.getBbHeight() / 4),
							(entity.getBbWidth() / 3), 0.05);
			});
			IterRpgMod.queueServerWork(15, () -> {
				entity.setDeltaMovement(new Vec3(0, (-1), 0));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() * 0.48), (entity.getZ()), 8, (entity.getBbWidth() / 3),
							(entity.getBbHeight() / 4), (entity.getBbWidth() / 3), 0.05);
				entity.fallDistance = 8;
			});
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY() + entity.getBbHeight() * 0.48), (entity.getZ()), 4, (entity.getBbWidth() / 3), (entity.getBbHeight() / 4), (entity.getBbWidth() / 3), 0.05);
	}
}
