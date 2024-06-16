package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class FiendBehaviourProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		boolean targeting = false;
		if (entity.getPersistentData().getDouble("dashduration") > 0) {
			entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("xdsah")), (entity.getPersistentData().getDouble("ydash")), (entity.getPersistentData().getDouble("zdash"))));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CRIT, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, 0.5, 0.5, 0.5, 0.025);
			entity.getPersistentData().putDouble("dashduration", (entity.getPersistentData().getDouble("dashduration") - 1));
		}
		if (entity.getPersistentData().getDouble("charge") <= 30) {
			entity.getPersistentData().putDouble("charge", (entity.getPersistentData().getDouble("charge") + Mth.nextDouble(RandomSource.create(), 0.5, 0.75)));
		} else {
			targeting = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
						targeting = true;
					}
				}
			}
			if (targeting) {
				if (entity.getPersistentData().getDouble("charge") <= 60) {
					entity.getPersistentData().putDouble("charge", (entity.getPersistentData().getDouble("charge") + Mth.nextDouble(RandomSource.create(), 0.5, 0.75)));
				} else {
					entity.getPersistentData().putDouble("charge", 0);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CRIT, (entity.getX() + entity.getLookAngle().x * 0.5), (entity.getY() + 1 + entity.getLookAngle().y * 0.5), (entity.getZ() + entity.getLookAngle().z * 0.5), 8, 0.5, 0.5, 0.5, 0.025);
					entity.getPersistentData().putDouble("xdsah", (entity.getLookAngle().x * 0.4));
					entity.getPersistentData().putDouble("ydash", (entity.getLookAngle().y * 0.4));
					entity.getPersistentData().putDouble("zdash", (entity.getLookAngle().z * 0.4));
					entity.getPersistentData().putDouble("dashduration", 30);
					entity.getPersistentData().putDouble("attackType", (Mth.nextInt(RandomSource.create(), 0, 1)));
				}
			} else {
				entity.getPersistentData().putDouble("charge", 50);
			}
		}
	}
}
