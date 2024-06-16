package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class ArcaneBlastHitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity, Entity sourceentity) {
		if (immediatesourceentity == null || sourceentity == null)
			return;
		double damage = 0;
		double distance = 0;
		double yspawn = 0;
		double ypos = 0;
		double zpos = 0;
		double xpos = 0;
		double attack = 0;
		boolean hit = false;
		boolean particle = false;
		boolean shouldtick = false;
		boolean shouldspawn = false;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ARCANE_PARTICLE.get()), x, y, z, 16, 0.75, 0.75, 0.75, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.ARCANE_PARTICLE.get()), x, y, z, 16, 0, 0, 0, 0.25);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 1, 0, 0, 0, 0);
		distance = 1;
		for (int index0 = 0; index0 < 4; index0++) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((distance * 1.75) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
							&& !(immediatesourceentity == entityiterator) && entityiterator instanceof LivingEntity) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("iter_rpg:arcane_damage"))), sourceentity),
								(float) ((5 - distance) / 2));
					}
				}
			}
			distance = distance + 0.75;
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}
}
