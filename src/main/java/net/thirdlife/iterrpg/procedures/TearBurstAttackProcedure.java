package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.List;
import java.util.Comparator;

public class TearBurstAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double offset = 0;
		if (entity.getPersistentData().getDouble("attackTime") <= 24) {
			if (entity.getPersistentData().getDouble("AuraDelay") <= 0) {
				entity.getPersistentData().putDouble("attackTime", (entity.getPersistentData().getDouble("attackTime") + 1));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), x, (y + 0.25), z, 4, 0.25, 0.25, 0.25, 0.025);
				entity.getPersistentData().putDouble("speed", (entity.getPersistentData().getDouble("speed") - 0.01));
				entity.getPersistentData().putDouble("spread", (entity.getPersistentData().getDouble("spread") + 0.2));
				if (entity.getPersistentData().getDouble("attackTime") >= 20) {
					{
						final Vec3 _center = new Vec3(x, (y + 1.5), z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners")))
									&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 8);
							}
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.WEEPER_TEAR_PARTICLE.get()), x, (y + 0.5), z, 16, 0.4, 0.4, 0.4, 0.16);
				}
			} else {
				entity.getPersistentData().putDouble("AuraDelay", (entity.getPersistentData().getDouble("AuraDelay") - 1));
				offset = 0;
			}
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
