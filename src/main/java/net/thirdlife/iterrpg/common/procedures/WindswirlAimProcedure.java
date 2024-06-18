package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import java.util.Comparator;

public class WindswirlAimProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double k = 0;
		if ((entity.getPersistentData().getString("type")).equals("at_player")) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
				xpos = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() - entity.getX();
				ypos = (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY() + 1) - entity.getY();
				zpos = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ() - entity.getZ();
				k = Math.abs(ypos) + Math.abs(zpos) + Math.abs(xpos);
				xpos = xpos / k;
				ypos = ypos / k;
				zpos = zpos / k;
				entity.getPersistentData().putDouble("speed", 1.5);
				entity.getPersistentData().putDouble("deathtime", 320);
				entity.getPersistentData().putDouble("timer", 0);
				entity.getPersistentData().putDouble("xVector", xpos);
				entity.getPersistentData().putDouble("yVector", ypos);
				entity.getPersistentData().putDouble("zVector", zpos);
			} else {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		} else if ((entity.getPersistentData().getString("type")).equals("scatter")) {
			xpos = Mth.nextInt(RandomSource.create(), -4, 4);
			ypos = Mth.nextInt(RandomSource.create(), -4, 4);
			zpos = Mth.nextInt(RandomSource.create(), -4, 4);
			k = Math.abs(ypos) + Math.abs(zpos) + Math.abs(xpos);
			xpos = xpos / k;
			ypos = ypos / k;
			zpos = zpos / k;
			entity.getPersistentData().putDouble("speed", 2.5);
			entity.getPersistentData().putDouble("deathtime", 60);
			entity.getPersistentData().putDouble("timer", 0);
			entity.getPersistentData().putDouble("xVector", xpos);
			entity.getPersistentData().putDouble("yVector", ypos);
			entity.getPersistentData().putDouble("zVector", zpos);
		}
	}
}
