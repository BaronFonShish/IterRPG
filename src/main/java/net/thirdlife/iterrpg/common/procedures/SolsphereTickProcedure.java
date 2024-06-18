package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.entity.SolsphereEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class SolsphereTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean doexplode = false;
		double rotation = 0;
		double distance = 0;
		double explosionpower = 0;
		double power = 0;
		entity.setNoGravity(true);
		doexplode = false;
		entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDouble("time") + 1));
		entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("xvec") * entity.getPersistentData().getDouble("speed")), (entity.getPersistentData().getDouble("yvec") * entity.getPersistentData().getDouble("speed")),
				(entity.getPersistentData().getDouble("zvec") * entity.getPersistentData().getDouble("speed"))));
		if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 1, (entity.getBbWidth() / 2), (entity.getBbHeight() / 2), (entity.getBbWidth() / 2), 0.05);
		} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LAVA, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 1, (entity.getBbWidth() / 2), (entity.getBbHeight() / 2), (entity.getBbWidth() / 2), 0.05);
		}
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
						&& !(entityiterator instanceof Player) && !(entityiterator instanceof SolsphereEntity) && entityiterator instanceof LivingEntity && !(entity == entityiterator)) {
					if (entityiterator.isAlive() && !entityiterator.fireImmune()) {
						if (!entityiterator.isOnFire()) {
							entityiterator.setSecondsOnFire(4);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FLAME, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 2, (entityiterator.getBbWidth() / 3),
									(entityiterator.getBbHeight() / 3), (entityiterator.getBbWidth() / 3), 0.05);
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE)), 2);
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 1, Level.ExplosionInteraction.NONE);
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
							&& !(entityiterator instanceof Player) && !(entityiterator instanceof SolsphereEntity) && entityiterator instanceof LivingEntity && !(entity == entityiterator)) {
						if (entityiterator.isAlive()) {
							entityiterator.invulnerableTime = 0;
							if (!entityiterator.isOnFire()) {
								entityiterator.setSecondsOnFire(16);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FLAME, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 2, (entityiterator.getBbWidth() / 3),
										(entityiterator.getBbHeight() / 3), (entityiterator.getBbWidth() / 3), 0.05);
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE)), 8);
						}
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 40, 0, 0, 0, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 10, 0, 0, 0, 0.15);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LAVA, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 12, (entity.getBbWidth() / 2), (entity.getBbHeight() / 2), (entity.getBbWidth() / 2), 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 1, 0, 0, 0, 0);
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity.getPersistentData().getDouble("time") >= entity.getPersistentData().getDouble("lifetime")) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), (float) 0.2, Level.ExplosionInteraction.NONE);
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
