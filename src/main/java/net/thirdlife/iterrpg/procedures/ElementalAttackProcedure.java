package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

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
			attackpower = 1;
			ScytheSplashDamageProcedure.execute(world, x, y, z, sourceentity, itemstack);
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:flail")))) {
			attackpower = 2;
			FlailPlaysoundProcedure.execute(world, x, y, z);
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:spear")))) {
			attackpower = 1;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:dagger")))) {
			attackpower = 0.6;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("forge:axe")))) {
			attackpower = 1.5;
		}
		repeat = 1;
		if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:earth_set")))) {
			type = 1;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:water_set")))) {
			type = 2;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:air_set")))) {
			type = 3;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:fire_set")))) {
			type = 4;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:void_set")))) {
			type = 5;
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("iter_rpg:elemental_set")))) {
			repeat = 2;
		}
		if (type == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.EARTH_SIGIL.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 5, 0.32, 0.32, 0.32, 0.05);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON, (int) (200 * attackpower), 0, false, true));
		}
		if (type == 2) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WATER_SIGIL.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 5, 0.32, 0.32, 0.32, 0.05);
			entity.setTicksFrozen((int) (entity.getTicksFrozen() + 125 * attackpower));
		}
		if (type == 3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.AIR_SIGIL.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 5, 0.32, 0.32, 0.32, 0.05);
			if (sourceentity.isShiftKeyDown()) {
				entity.setDeltaMovement(new Vec3((sourceentity.getLookAngle().x * attackpower * 1.16), 0.25, (sourceentity.getLookAngle().z * attackpower * 1.16)));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) (12 * attackpower), 0, false, true));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) (16 * attackpower), 0, false, true));
			}
		}
		if (type == 4) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.FIRE_SIGIL.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 5, 0.32, 0.32, 0.32, 0.05);
			entity.setSecondsOnFire((int) (7.5 * attackpower));
		}
		if (type == 5) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.VOID_SIGIL.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 5, 0.32, 0.32, 0.32, 0.05);
			if ((sourceentity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MeleeAttackCooldown <= 0) {
				{
					double _setval = 13;
					sourceentity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MeleeAttackCooldown = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.075 > 1.5 * attackpower) {
					damage = (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * 0.075;
				} else {
					damage = 1.5 * attackpower;
				}
				if (damage > 5 * attackpower) {
					damage = 5 * attackpower;
				}
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("iter_rpg:arcane_damage"))), sourceentity), (float) damage);
			}
		}
	}
}
