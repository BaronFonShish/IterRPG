package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.entity.MournstoneEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class MournstoneAiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		double xdir = 0;
		double ydir = 0;
		double zdir = 0;
		double distance = 0;
		boolean aim = false;
		boolean sightline = false;
		MournersAiProcedure.execute(world, x, y, z, entity);
		if (entity.getPersistentData().getDouble("hook") <= 120) {
			entity.getPersistentData().putDouble("hook", (entity.getPersistentData().getDouble("hook") + 1));
		}
		if (entity.getPersistentData().getDouble("hook") >= Mth.nextInt(RandomSource.create(), 90, 120)) {
			aim = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) && (entityiterator != null ? entity.distanceTo(entityiterator) : -1) >= 6) {
						aim = true;
						xdir = entityiterator.getX() - entity.getX();
						ydir = (entityiterator.getY() + entityiterator.getBbHeight() / 2) - (entity.getY() + entity.getBbHeight() / 2);
						zdir = entityiterator.getZ() - entity.getZ();
					}
				}
			}
			if (aim) {
				entity.getPersistentData().putDouble("hook", 0);
				distance = 0;
				sightline = true;
				for (int index0 = 0; index0 < 20; index0++) {
					if (world.getBlockState(BlockPos.containing(entity.getX() + xdir * distance, entity.getY() + entity.getBbHeight() / 2 + ydir * distance, entity.getZ() + zdir * distance)).canOcclude()) {
						sightline = false;
					}
					distance = distance + 0.05;
				}
				if (sightline) {
					entity.getPersistentData().putDouble("hook", 0);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 20, false, false));
					if (world instanceof ServerLevel _serverLevel) {
						Entity entitytospawn = IterRpgModEntities.GRIMHOOK.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY() + entity.getBbHeight() / 2), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
						if (entitytospawn != null) {
							entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						}
						(entitytospawn).getPersistentData().putDouble("xdest", xdir);
						(entitytospawn).getPersistentData().putDouble("ydest", ydir);
						(entitytospawn).getPersistentData().putDouble("zdest", zdir);
						(entitytospawn).getPersistentData().putDouble("xinit", (entity.getX()));
						(entitytospawn).getPersistentData().putDouble("yinit", (entity.getY() + entity.getBbHeight() / 2));
						(entitytospawn).getPersistentData().putDouble("zinit", (entity.getZ()));
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof MournstoneEntity) {
								entityiterator.getPersistentData().putDouble("hook", (entityiterator.getPersistentData().getDouble("hook") - Mth.nextInt(RandomSource.create(), 30, 50)));
							}
						}
					}
				} else {
					entity.getPersistentData().putDouble("hook", 150);
				}
			} else {
				entity.getPersistentData().putDouble("hook", 100);
			}
		}
	}
}
