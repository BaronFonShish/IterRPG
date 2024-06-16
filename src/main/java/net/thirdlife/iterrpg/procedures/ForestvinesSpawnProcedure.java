package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;

public class ForestvinesSpawnProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("lifetime", (Mth.nextInt(RandomSource.create(), 200, 300)));
		entity.getPersistentData().putDouble("ascend", 3.5);
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y - 1.3), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y - 1.3), z, _ent.getYRot(), _ent.getXRot());
		}
	}
}
