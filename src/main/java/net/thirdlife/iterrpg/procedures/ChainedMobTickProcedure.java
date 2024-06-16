package net.thirdlife.iterrpg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ChainedMobTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("chainedTime") > 1) {
			entity.getPersistentData().putDouble("chainedTime", (entity.getPersistentData().getDouble("chainedTime") - 1));
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getPersistentData().getDouble("brainX")), (entity.getPersistentData().getDouble("brainY")), (entity.getPersistentData().getDouble("brainZ")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("brainX")), (entity.getPersistentData().getDouble("brainY")), (entity.getPersistentData().getDouble("brainZ")), _ent.getYRot(), _ent.getXRot());
			}
			entity.fallDistance = 0;
		}
	}
}
