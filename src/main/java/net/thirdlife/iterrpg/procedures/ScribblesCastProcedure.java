package net.thirdlife.iterrpg.procedures;

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
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class ScribblesCastProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double power = 0;
		double cooldown = 0;
		double mana = 0;
		double dist = 0;
		double xdir = 0;
		double ydir = 0;
		double zdir = 0;
		double xnew = 0;
		double ynew = 0;
		double znew = 0;
		double distance = 0;
		boolean hitcontinue = false;
		power = WandReturnPowerProcedure.execute(entity);
		dist = 0;
		xdir = entity.getLookAngle().x;
		ydir = entity.getLookAngle().y;
		zdir = entity.getLookAngle().z;
		xnew = entity.getX() + xdir * dist;
		ynew = entity.getY() + entity.getBbHeight() * 0.85 + ydir * dist;
		znew = entity.getZ() + zdir * dist;
		hitcontinue = true;
		for (int index0 = 0; index0 < Math.round(25 + power * 2); index0++) {
			if (hitcontinue) {
				xnew = xnew + xdir * dist;
				ynew = ynew + ydir * dist;
				znew = znew + zdir * dist;
				if (Math.random() < (1) / ((float) 2)) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WITCH, xnew, ynew, znew, 1, 0, 0, 0, 0);
				}
				{
					final Vec3 _center = new Vec3(xnew, ynew, znew);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
								&& !(entity == entityiterator) && entityiterator instanceof LivingEntity) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("iter_rpg:arcane_damage"))), entity),
									(float) (1.5 + Math.log(power + 1)));
							hitcontinue = false;
						}
					}
				}
				if (world.getBlockState(BlockPos.containing(xnew, ynew, znew)).canOcclude()) {
					hitcontinue = false;
				}
				dist = dist + 0.025;
			}
		}
	}
}
