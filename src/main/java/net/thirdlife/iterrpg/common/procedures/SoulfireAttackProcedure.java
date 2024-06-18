package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
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

public class SoulfireAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double offset = 0;
		boolean should = false;
		if (entity.getPersistentData().getDouble("attackTime") <= 50) {
			should = false;
			if (entity.getPersistentData().getDouble("AuraDelay") <= 0) {
				entity.getPersistentData().putDouble("attackTime", (entity.getPersistentData().getDouble("attackTime") + 1));
				{
					final Vec3 _center = new Vec3(x, (Mth.nextDouble(RandomSource.create(), y, y + entity.getPersistentData().getDouble("offset"))), z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners")))
								&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 6);
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_FIRE)), 1);
							entityiterator.setSecondsOnFire(10);
						}
					}
				}
				entity.getPersistentData().putDouble("offset", (entity.getPersistentData().getDouble("offset") + 0.16));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, (y + entity.getPersistentData().getDouble("offset") / 2), z, 6, 0.16, (entity.getPersistentData().getDouble("offset") / 4), 0.16, 0.032);
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
