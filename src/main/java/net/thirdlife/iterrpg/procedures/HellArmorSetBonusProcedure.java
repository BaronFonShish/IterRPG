package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class HellArmorSetBonusProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double chance = 0;
		double generator_distance = 0;
		double previousRecipe = 0;
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).ElementalArmorCooldown <= 1 && entity.onGround() && entity.isShiftKeyDown() && entity.isSprinting()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12, 2, true, true));
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().putDouble("dash", 12);
			{
				double _setval = 64;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ElementalArmorCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (!(entity.isInLava() || entity.isOnFire())) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 64, 0, true, false));
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 5) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 16, 0, true, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 16, 0, true, true));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("dash") > 0) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("dash") == 1) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies"))) && !(entityiterator == entity)) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.25, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, (float) 0.25, 1, false);
								}
							}
							entityiterator.setSecondsOnFire(8);
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE)), 6);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.EXPLOSION, (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 2, 0.16, 0.16, 0.16, 0);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.LAVA, (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 8, 0.16, 0.16, 0.16, 0);
							entityiterator.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.64, 0.64)), 0.64, (Mth.nextDouble(RandomSource.create(), -0.64, 0.64))));
						}
					}
				}
			}
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().putDouble("dash",
					((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("dash") - 1));
			entity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (-0.32), (entity.getLookAngle().z)));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, y, z, 8, 0.16, 0, 0.16, 0);
			for (int index0 = 0; index0 < 8; index0++) {
				world.addParticle(ParticleTypes.FLAME, (entity.getX() + Mth.nextDouble(RandomSource.create(), entity.getBbWidth() * (-1), entity.getBbWidth())),
						(entity.getY() + Mth.nextDouble(RandomSource.create(), entity.getBbHeight() * (-1), entity.getBbHeight())), (entity.getZ() + Mth.nextDouble(RandomSource.create(), entity.getBbWidth() * (-1), entity.getBbWidth())),
						(entity.getLookAngle().x * (-0.32)), 0, (entity.getLookAngle().z * (-0.32)));
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:player_allies"))) && !(entityiterator == entity)) {
						entityiterator.setSecondsOnFire(6);
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE)), 4);
						entityiterator.setDeltaMovement(new Vec3((Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0.32, (Mth.nextDouble(RandomSource.create(), -0.5, 0.5))));
					}
				}
			}
		}
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).ElementalArmorPassiveCooldown <= 1) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entity) {
						entityiterator.setSecondsOnFire(1);
						{
							double _setval = 20;
							entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ElementalArmorPassiveCooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).ElementalArmorPassiveCooldown > 1) {
			world.addParticle(ParticleTypes.FLAME, (x + Mth.nextDouble(RandomSource.create(), entity.getBbWidth() / (-1.75), entity.getBbWidth() / 1.75)), (y + Mth.nextDouble(RandomSource.create(), 0, entity.getBbHeight() / 1.75)),
					(z + Mth.nextDouble(RandomSource.create(), entity.getBbWidth() / (-1.75), entity.getBbWidth() / 1.75)), 0, (Mth.nextDouble(RandomSource.create(), 0.04, 0.1)), 0);
		}
	}
}
