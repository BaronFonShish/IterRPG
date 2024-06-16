package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.GoblinWarriorEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import java.util.Comparator;

public class GoblinAiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(GoblinWarriorEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty()
				&& !(!world.getEntitiesOfClass(GoblinWarriorEntity.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty())) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(GoblinWarriorEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() + Mth.nextInt(RandomSource.create(), -4, 4)),
						(((Entity) world.getEntitiesOfClass(GoblinWarriorEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GoblinWarriorEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ() + Mth.nextInt(RandomSource.create(), -4, 4)), 1);
		}
		CoinTimerTickProcedure.execute(world, x, y, z, entity);
	}
}
