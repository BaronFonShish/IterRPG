package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class OverworldEventFunctionProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((world.dayTime() + ", " + world.getLevelData().getGameTime())), false);
	}
}
