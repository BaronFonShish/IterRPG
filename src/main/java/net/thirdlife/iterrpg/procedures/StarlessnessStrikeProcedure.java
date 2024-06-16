package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
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
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class StarlessnessStrikeProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity target = null;
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
		double chosen = 0;
		if ((sourceentity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MeleeAttackCooldown <= 0) {
			{
				double _setval = 8;
				sourceentity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MeleeAttackCooldown = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			mobamount = 0;
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
							&& entityiterator instanceof LivingEntity && !(sourceentity == entityiterator)) {
						mobamount = mobamount + 1;
					}
				}
			}
			chosen = Mth.nextInt(RandomSource.create(), 0, (int) mobamount);
			mobamount = 0;
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
							&& entityiterator instanceof LivingEntity && !(sourceentity == entityiterator)) {
						if (chosen == mobamount) {
							target = entityiterator;
						}
						mobamount = mobamount + 1;
					}
				}
			}
			IterRpgMod.queueServerWork(4, () -> {
				if (entity.isAlive()) {
					entity.invulnerableTime = 0;
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.REVERSE_PORTAL, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 2, (entity.getBbWidth() / 3), (entity.getBbHeight() / 3), (entity.getBbWidth() / 3), 0.025);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.VOID_SIGIL.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 2, (entity.getBbWidth() / 3), (entity.getBbHeight() / 3),
								(entity.getBbWidth() / 3), 0.025);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_VOID.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 2, (entity.getBbWidth() / 3), (entity.getBbHeight() / 3),
								(entity.getBbWidth() / 3), 0.025);
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.075 >= 5) {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 2.5);
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.075 < 2) {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
					} else {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.0375));
					}
					entity.invulnerableTime = 0;
				}
			});
			if (target.isAlive()) {
				target.invulnerableTime = 0;
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_VOID.get()), (target.getX()), (target.getY() + 2), (target.getZ()), 16, 0, 3, 0, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.REVERSE_PORTAL, (target.getX()), (target.getY() + target.getBbHeight() / 3), (target.getZ()), 12, (target.getBbWidth() / 3), (target.getBbHeight() / 3), (target.getBbWidth() / 3), 0.05);
				if ((target instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.075 >= 5) {
					target.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 2.5);
				} else if ((target instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.075 < 2) {
					target.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
				} else {
					target.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) ((target instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.0375));
				}
				target.invulnerableTime = 0;
			}
		}
	}
}
