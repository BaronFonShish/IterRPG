package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.common.entity.GrimaceEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class GrieverSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double mobcount = 0;
		boolean doattack = false;
		entity.getPersistentData().putDouble("screamTime", 1200);
		mobcount = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof GrimaceEntity && (entityiterator.getPersistentData().getString("host")).equals(entity.getStringUUID())) {
					mobcount = mobcount + 1;
				}
			}
		}
		if (mobcount == 0) {
			for (int index0 = 0; index0 < 2; index0++) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = IterRpgModEntities.GRIMACE.get().spawn(_serverLevel, BlockPos.containing(x, (y + 1), z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					(entitytospawn).getPersistentData().putString("latchtype", "mob");
					(entitytospawn).getPersistentData().putString("host", (entity.getStringUUID()));
				}
			}
		}
	}
}
