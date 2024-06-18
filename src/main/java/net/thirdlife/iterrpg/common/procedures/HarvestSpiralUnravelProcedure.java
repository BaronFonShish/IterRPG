package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.entity.HarvestSpiralEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class HarvestSpiralUnravelProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		double rotation = 0;
		double distance = 0;
		double mobamount = 0;
		double chosen = 0;
		double splashdmg = 0;
		if (entity.getPersistentData().getDouble("time") >= 24) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.setDeltaMovement(new Vec3(0, 0, 0));
			entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDouble("time") + 1));
			entity.getPersistentData().putDouble("scale", (entity.getPersistentData().getDouble("time")));
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((1.75 + entity.getPersistentData().getDouble("time") / 4.5) / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
							&& !(entityiterator instanceof Player) && !(entityiterator instanceof HarvestSpiralEntity) && entityiterator instanceof LivingEntity && !(entity == entityiterator)
							&& Math.abs((entityiterator.getY() + entityiterator.getBbHeight() / 2) - (entity.getY() + entity.getBbHeight() / 2)) <= 1 + entity.getPersistentData().getDouble("time") / 10) {
						if (entityiterator.isAlive() && entityiterator.invulnerableTime == 0) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) entity.getPersistentData().getDouble("damage"));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 4), (entityiterator.getZ()), 1, 0, 0, 0, 0);
							if (!(entityiterator instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(MobEffects.POISON))) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 250, 0, false, true));
							}
						}
					}
				}
			}
		}
	}
}
