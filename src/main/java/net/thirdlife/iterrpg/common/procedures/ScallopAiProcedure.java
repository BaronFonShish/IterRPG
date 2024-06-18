package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModMobEffects;
import net.thirdlife.iterrpg.common.entity.SmallScallopEntity;
import net.thirdlife.iterrpg.common.entity.ScallopEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.List;
import java.util.Comparator;

public class ScallopAiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
		if (entity.getPersistentData().getBoolean("friendly")) {
			flag = true;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (flag && !(entityiterator instanceof ScallopEntity || entityiterator instanceof SmallScallopEntity) && entityiterator instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(IterRpgModMobEffects.WRATH_OF_THE_DEPTHS.get())) {
						flag = false;
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
				}
			}
			entity.getPersistentData().putDouble("lifetime", (entity.getPersistentData().getDouble("lifetime") + 1));
			if (entity.getPersistentData().getDouble("lifetime") >= ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) * 500
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 1) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		} else if (entity.getPersistentData().getBoolean("summoned")) {
			entity.getPersistentData().putDouble("lifetime", (entity.getPersistentData().getDouble("lifetime") + 1));
			if (entity.getPersistentData().getDouble("lifetime") >= ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) * 500
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 1) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
