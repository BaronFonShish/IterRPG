package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class DemonspineSpawnProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("lifetime", 0);
		entity.getPersistentData().putDouble("ascend", 4);
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y - 1.6), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y - 1.6), z, _ent.getYRot(), _ent.getXRot());
		}
	}
}
