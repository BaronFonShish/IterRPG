package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class ThunderclapCastProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean hitcontinue = false;
		double distance = 0;
		double dirx = 0;
		double diry = 0;
		double dirz = 0;
		double xnew = 0;
		double dist = 0;
		double power = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double ynew = 0;
		double znew = 0;
		double maxdist = 0;
		double maxdistiter = 0;
		power = WandReturnPowerProcedure.execute(entity);
		dist = 0;
		xdir = entity.getLookAngle().x;
		ydir = entity.getLookAngle().y;
		zdir = entity.getLookAngle().z;
		xnew = entity.getX() + xdir * dist;
		ynew = entity.getY() + entity.getBbHeight() * 0.85 + ydir * dist;
		znew = entity.getZ() + zdir * dist;
		hitcontinue = true;
		for (int index0 = 0; index0 < (int) (50 + Math.round(20 * power)); index0++) {
			if (hitcontinue) {
				xnew = xnew + xdir * dist + Mth.nextDouble(RandomSource.create(), -0.4, 0.4) * dist;
				ynew = ynew + ydir * dist + Mth.nextDouble(RandomSource.create(), -0.4, 0.4) * dist;
				znew = znew + zdir * dist + Mth.nextDouble(RandomSource.create(), -0.4, 0.4) * dist;
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, xnew, ynew, znew, 1, 0, 0, 0, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), xnew, ynew, znew, 1, 0, 0, 0, 0);
				{
					final Vec3 _center = new Vec3(xnew, ynew, znew);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
								&& !(entity == entityiterator) && entityiterator instanceof LivingEntity) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("iter_rpg:arcane_damage"))), entity),
									(float) (8 * power));
							hitcontinue = false;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), xnew, ynew, znew, (int) (8 + Math.log(power + 1)), 0.05, 0.05, 0.05, 0.05);
						}
					}
				}
				if (world.getBlockState(BlockPos.containing(xnew, ynew, znew)).canOcclude()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.END_ROD, xnew, ynew, znew, (int) (8 + Math.log(power + 1)), 0.15, 0.15, 0.15, 0.05);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), xnew, ynew, znew, (int) (8 + Math.log(power + 1)), 0.05, 0.05, 0.05, 0.05);
					hitcontinue = false;
				}
				dist = dist + 0.025;
			}
		}
		maxdist = (50 + Math.round(20 * power)) * 0.025;
		maxdistiter = 0;
		for (int index1 = 0; index1 < 4; index1++) {
			distance = maxdistiter;
			xdir = entity.getLookAngle().x;
			ydir = entity.getLookAngle().y;
			zdir = entity.getLookAngle().z;
			xnew = entity.getX() + xdir * dist;
			ynew = entity.getY() + entity.getBbHeight() * 0.85 + ydir * dist;
			znew = entity.getZ() + zdir * dist;
			hitcontinue = true;
			for (int index2 = 0; index2 < (int) (25 + Math.round(10 * power)); index2++) {
				if (hitcontinue) {
					xnew = xnew + xdir * dist + Mth.nextDouble(RandomSource.create(), -0.4, 0.4) * dist;
					ynew = ynew + ydir * dist + Mth.nextDouble(RandomSource.create(), -0.4, 0.4) * dist;
					znew = znew + zdir * dist + Mth.nextDouble(RandomSource.create(), -0.4, 0.4) * dist;
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.END_ROD, xnew, ynew, znew, 1, 0, 0, 0, 0);
					{
						final Vec3 _center = new Vec3(xnew, ynew, znew);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
									&& !(entity == entityiterator) && entityiterator instanceof LivingEntity) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("iter_rpg:arcane_damage"))), entity),
										(float) (3 * power));
								hitcontinue = false;
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), xnew, ynew, znew, (int) (8 + Math.log(power + 1)), 0.05, 0.05, 0.05, 0.05);
							}
						}
					}
					if (world.getBlockState(BlockPos.containing(xnew, ynew, znew)).canOcclude()) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), xnew, ynew, znew, (int) (8 + Math.log(power + 1)), 0.05, 0.05, 0.05, 0.05);
						hitcontinue = false;
					}
					dist = dist + 0.025;
				}
			}
			maxdistiter = maxdistiter + maxdist / 5;
		}
	}
}
