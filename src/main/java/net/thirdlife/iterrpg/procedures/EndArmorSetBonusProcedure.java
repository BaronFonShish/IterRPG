package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;
import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Monster;
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class EndArmorSetBonusProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean attack = false;
		boolean hit = false;
		boolean particle = false;
		double chance = 0;
		double generator_distance = 0;
		double previousRecipe = 0;
		double offset = 0;
		double dist = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double damage = 0;
		double distance = 0;
		double amount = 0;
		if (entity.isShiftKeyDown()) {
			offset = 1.85;
		} else {
			offset = 2.15;
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.VOID_EYE_PARTICLE.get()), x, (y + offset), z, 1, 0, 0, 0, 0);
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).ElementalArmorCooldown <= 1) {
			amount = 0;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (amount < 1 && entityiterator instanceof Monster && !(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage"))) && !(entity == entityiterator)) {
						amount = amount + 1;
						{
							double _setval = 65;
							entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ElementalArmorCooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						xdir = entityiterator.getX() - entity.getX();
						ydir = (entityiterator.getY() + entityiterator.getBbHeight() / 2) - (entity.getY() + offset);
						zdir = entityiterator.getZ() - entity.getZ();
						attack = true;
						dist = 0;
						for (int index0 = 0; index0 < 20; index0++) {
							if (world.getBlockState(BlockPos.containing(entity.getX() + dist * xdir, entity.getY() + offset + ydir * dist, entity.getZ() + dist * zdir)).canOcclude()) {
								attack = false;
							}
							dist = dist + 0.05;
						}
						if (attack) {
							dist = 0;
							for (int index1 = 0; index1 < 20; index1++) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.PORTAL_SPARK_PARTICLE.get()), (entity.getX() + dist * xdir), (entity.getY() + offset + ydir * dist), (entity.getZ() + dist * zdir), 1, 0, 0, 0, 0);
								dist = dist + 0.05;
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.PORTAL_SPARK_PARTICLE.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 16, 0, 0, 0, 0);
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 6);
							for (int index2 = 0; index2 < 16; index2++) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.DRAGON_BREATH, (entity.getX() + dist * xdir), (entity.getY() + offset + ydir * dist), (entity.getZ() + dist * zdir), 1, 0.1, 0.1, 0.1,
											(Mth.nextDouble(RandomSource.create(), 0.025, 0.1)));
							}
						}
					}
				}
			}
		}
		if (itemstack.getOrCreateTag().getDouble("voidcooldown") >= 1) {
			itemstack.getOrCreateTag().putDouble("voidcooldown", (itemstack.getOrCreateTag().getDouble("voidcooldown") - 1));
		}
		if (itemstack.getOrCreateTag().getDouble("voidcooldown") <= 1
				&& (y <= -65 && (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD || y <= 0 && !((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD))) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ELEMENTAL_VOID.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 16, 0.5, 1, 0.5, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ()), 16, 0.5, 1, 0.5, 0);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 400, 4, true, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0, true, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 700, 0, true, true));
			itemstack.getOrCreateTag().putDouble("voidcooldown", 6000);
		}
	}
}
