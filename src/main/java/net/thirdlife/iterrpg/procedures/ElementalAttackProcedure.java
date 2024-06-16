package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class ElementalAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
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
		if (itemstack.is(ItemTags.create(new ResourceLocation("forge:sword")))) {
			attackpower = 1;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:scythe")))) {
			attackpower = 0.75;
			ScytheSplashDamageProcedure.execute(world, x, y, z, sourceentity, itemstack);
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:flail")))) {
			attackpower = 2;
			FlailPlaysoundProcedure.execute(world, x, y, z);
		}
		repeat = 1;
		if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:forest_set")))) {
			type = 1;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:ocean_set")))) {
			type = 2;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:sky_set")))) {
			type = 3;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:hell_set")))) {
			type = 4;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:end_set")))) {
			type = 5;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:elemental_set")))) {
			repeat = 2;
		}
		for (int index0 = 0; index0 < (int) repeat; index0++) {
			if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:elemental_set")))) {
				type = Mth.nextInt(RandomSource.create(), 1, 5);
			}
			if (type == 1) {
				distance = 0.25;
				for (int index1 = 0; index1 < Math.round(8 * attackpower); index1++) {
					xpos = distance * Mth.nextDouble(RandomSource.create(), -1, 1);
					ypos = distance * Mth.nextDouble(RandomSource.create(), -0.16, 0.16);
					zpos = distance * Mth.nextDouble(RandomSource.create(), -1, 1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_LEAF.get()), (entity.getX() + xpos), (entity.getY() + ypos + entity.getBbHeight() * 0.48), (entity.getZ() + zpos), 5, 0.32, 0.32, 0.32, 0.05);
					{
						final Vec3 _center = new Vec3((entity.getX() + xpos), (entity.getY() + ypos), (entity.getZ() + zpos));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((1.25 * attackpower) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
									&& !(sourceentity == entityiterator)) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.POISON, (int) (250 * attackpower), 0, false, true));
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) (1.2 * attackpower));
							}
						}
					}
					distance = distance + 0.32;
				}
			}
			if (type == 2) {
				distance = 0;
				mobamount = 1;
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (250 * attackpower), 0, false, true));
				{
					final Vec3 _center = new Vec3((entity.getX() + xpos), (entity.getY() + ypos), (entity.getZ() + zpos));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((5 * attackpower) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
								&& !(sourceentity == entityiterator) && (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString())
								&& mobamount <= Math.round(5 * attackpower)) {
							mobamount = mobamount + 1;
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (250 * attackpower), 0, false, true));
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) (2 * attackpower));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.BUBBLE_POP, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 5, (entityiterator.getBbWidth() / 3),
										(entityiterator.getBbHeight() / 3), (entityiterator.getBbWidth() / 3), 0.05);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.BUBBLE, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 5, (entityiterator.getBbWidth() / 3),
										(entityiterator.getBbHeight() / 3), (entityiterator.getBbWidth() / 3), 0.05);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SPLASH, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 5, (entityiterator.getBbWidth() / 3),
										(entityiterator.getBbHeight() / 3), (entityiterator.getBbWidth() / 3), 0.05);
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_DROPLET.get()), (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 5,
										(entityiterator.getBbWidth() / 3), (entityiterator.getBbHeight() / 3), (entityiterator.getBbWidth() / 3), 0.05);
						}
					}
				}
			}
			if (type == 3) {
				distance = 0.25;
				if (sourceentity.isShiftKeyDown()) {
					for (int index2 = 0; index2 < 4; index2++) {
						xpos = distance * Mth.nextDouble(RandomSource.create(), -1, 1);
						ypos = distance * Mth.nextDouble(RandomSource.create(), -0.16, 0.16);
						zpos = distance * Mth.nextDouble(RandomSource.create(), -1, 1);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.POOF, (entity.getX() + xpos), (entity.getY() + ypos + entity.getBbHeight() * 0.48), (entity.getZ() + zpos), 2, 0.32, 0.32, 0.32, 0.05);
					}
					entity.setDeltaMovement(new Vec3((sourceentity.getLookAngle().x * attackpower * 1.16), 0.25, (sourceentity.getLookAngle().z * attackpower * 1.16)));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) (12 * attackpower), 0, false, true));
				} else {
					for (int index3 = 0; index3 < Math.round(6 * attackpower); index3++) {
						xpos = distance * Mth.nextDouble(RandomSource.create(), -1, 1);
						ypos = distance * Mth.nextDouble(RandomSource.create(), -0.16, 0.16);
						zpos = distance * Mth.nextDouble(RandomSource.create(), -1, 1);
						{
							final Vec3 _center = new Vec3((entity.getX() + xpos), (entity.getY() + ypos), (entity.getZ() + zpos));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((1.2 * attackpower) / 2d), e -> true).stream()
									.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
										&& !(sourceentity == entityiterator)) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) (16 * attackpower), 0, false, true));
								}
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.POOF, (entity.getX() + xpos), (entity.getY() + ypos + entity.getBbHeight() * 0.48), (entity.getZ() + zpos), 4, 0.32, 0.32, 0.32, 0.05);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (entity.getX() + xpos), (entity.getY() + ypos + entity.getBbHeight() * 0.48), (entity.getZ() + zpos), 1, 0.32, 0.32, 0.32, 0.05);
						distance = distance + 0.32;
					}
				}
			}
			if (type == 4) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, (entity.getX()), (entity.getY() + entity.getBbHeight() / 1.5), (entity.getZ()), (float) 0.1, Level.ExplosionInteraction.NONE);
				entity.setSecondsOnFire((int) (6 * attackpower));
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((3 * attackpower) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
								&& !(sourceentity == entityiterator)) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_FIRE)), (float) (0.2 * attackpower));
							entityiterator.setSecondsOnFire((int) (6 * attackpower));
						}
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LAVA, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 6, (entity.getBbWidth() / 3), (entity.getBbHeight() / 3), (entity.getBbWidth() / 3), 0.05);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 6, (entity.getBbWidth() / 3), (entity.getBbHeight() / 3), (entity.getBbWidth() / 3), 0.05);
			}
			if (type == 5) {
				if ((sourceentity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MeleeAttackCooldown <= 0) {
					{
						double _setval = 13;
						sourceentity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MeleeAttackCooldown = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_VOID.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 8, (entity.getBbWidth() / 4), (entity.getBbHeight() / 4),
								(entity.getBbWidth() / 4), 0.05);
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.075 > 1.5 * attackpower) {
						damage = (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.075;
					} else {
						damage = 1.5 * attackpower;
					}
					if (damage > 5 * attackpower) {
						damage = 5 * attackpower;
					}
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - damage));
				}
			}
		}
	}
}
