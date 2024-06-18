package net.thirdlife.iterrpg.common.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class ElementalFlightBehaviourProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double d = 0;
		double distance = 0;
		double xpos = 0;
		double zpos = 0;
		double ypos = 0;
		boolean flag = false;
		boolean far_above = false;
		boolean above = false;
		distance = 0;
		far_above = true;
		for (int index0 = 0; index0 < 4; index0++) {
			xpos = entity.getX() + Mth.nextDouble(RandomSource.create(), -1, 1);
			zpos = entity.getZ() + Mth.nextDouble(RandomSource.create(), -1, 1);
			ypos = entity.getY() - distance;
			if ((world.getBlockState(BlockPos.containing(xpos, ypos, zpos))).getBlock() instanceof LiquidBlock || world.getBlockState(BlockPos.containing(xpos, ypos, zpos)).isFaceSturdy(world, BlockPos.containing(xpos, ypos, zpos), Direction.UP)) {
				far_above = false;
			}
			distance = distance + 1;
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					if (entityiterator.getY() >= entity.getY() - 1) {
						above = true;
					}
				}
			}
		}
		if (!far_above || above) {
			entity.getPersistentData().putBoolean("flying", true);
			entity.setNoGravity(true);
		} else {
			entity.getPersistentData().putBoolean("flying", false);
			entity.setNoGravity(false);
			entity.setDeltaMovement(new Vec3(0, (-0.025), 0));
		}
	}
}
