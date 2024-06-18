package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;
import net.thirdlife.iterrpg.common.entity.GrimaceEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class GrimaceSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double attacktype = 0;
		double distance = 0;
		double rotation = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double attachx = 0;
		double attachy = 0;
		double attachz = 0;
		double dist = 0;
		boolean doattack = false;
		boolean found = false;
		boolean entityhost = false;
		if (!((entity.getPersistentData().getString("latchtype")).equals("mob") || (entity.getPersistentData().getString("latchtype")).equals("block"))) {
			found = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!found && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:mourners"))) && !(entityiterator instanceof GrimaceEntity)) {
						found = true;
						entity.getPersistentData().putString("latchtype", "mob");
						entity.getPersistentData().putString("host", (entityiterator.getStringUUID()));
						entity.getPersistentData().putDouble("xlatch", (entityiterator.getX()));
						entity.getPersistentData().putDouble("ylatch", (entityiterator.getY() + entityiterator.getBbHeight() / 2));
						entity.getPersistentData().putDouble("zlatch", (entityiterator.getZ()));
					}
				}
			}
			sx = -3;
			if (!found) {
				for (int index0 = 0; index0 < 6; index0++) {
					sy = -3;
					for (int index1 = 0; index1 < 6; index1++) {
						sz = -3;
						for (int index2 = 0; index2 < 6; index2++) {
							if (!found) {
								if ((world.getBlockState(BlockPos.containing(Math.round(entity.getX()) + sx, Math.round(entity.getY()) + sy, Math.round(entity.getZ()) + sz))).getBlock() == IterRpgModBlocks.GRIMACE_TRAP.get()) {
									entity.getPersistentData().putDouble("xlatch", (Math.round(entity.getX()) + sx + 0.5));
									entity.getPersistentData().putDouble("ylatch", (Math.round(entity.getY()) + sy + 0.95));
									entity.getPersistentData().putDouble("zlatch", (Math.round(entity.getZ()) + sz + 0.5));
									entity.getPersistentData().putString("latchtype", "block");
									found = true;
								}
								sz = sz + 1;
							}
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			}
		}
	}
}
