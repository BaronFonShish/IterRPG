package net.thirdlife.iterrpg.common.procedures;

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
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class SoulfireAuraProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean should = false;
		double offset = 0;
		double distance = 0;
		if (entity.getPersistentData().getDouble("attackTime") >= 75) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			if (entity.getPersistentData().getDouble("attackTime") > 32) {
				offset = 0;
				for (int index0 = 0; index0 < 15; index0++) {
					{
						final Vec3 _center = new Vec3(x, (y + offset), z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners")))
									&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.IN_FIRE)), 4);
								entityiterator.setSecondsOnFire(10);
							}
						}
					}
					offset = offset + 0.5;
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, (y + 3), z, 2, 0.16, 2, 0.16, 0.002);
			}
			entity.getPersistentData().putDouble("attackTime", (entity.getPersistentData().getDouble("attackTime") + 1));
		}
	}
}
