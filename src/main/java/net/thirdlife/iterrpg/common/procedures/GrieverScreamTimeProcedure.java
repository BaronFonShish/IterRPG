package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class GrieverScreamTimeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		MournersAiProcedure.execute(world, x, y, z, entity);
		if (entity.getPersistentData().getDouble("screamTime") >= 1250) {
			entity.getPersistentData().putDouble("screamTime", 1200);
		} else {
			entity.getPersistentData().putDouble("screamTime", (entity.getPersistentData().getDouble("screamTime") + 1));
		}
		if (entity.getPersistentData().getDouble("buffTime") >= 125) {
			entity.getPersistentData().putDouble("buffTime", 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WITCH, x, (y + entity.getBbHeight() / 2), z, 6, (entity.getBbWidth() / 2.5), (entity.getBbHeight() / 2.5), (entity.getBbWidth() / 2.5), 0.01);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners")))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120, 0, false, true));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0, false, true));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 6, (entityiterator.getBbWidth() / 2.5),
									(entityiterator.getBbHeight() / 2.5), (entityiterator.getBbWidth() / 2.5), 0.01);
					}
				}
			}
		} else {
			entity.getPersistentData().putDouble("buffTime", (entity.getPersistentData().getDouble("buffTime") + 1));
		}
	}
}
