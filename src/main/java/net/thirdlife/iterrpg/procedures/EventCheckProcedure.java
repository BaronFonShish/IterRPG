package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class EventCheckProcedure {
	public static void execute(LevelAccessor world) {
		double decideEvent = 0;
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((IterRpgModVariables.MapVariables.get(world).OverworldEventChance + ", " + world.dayTime() % 24000 + ", "
					+ IterRpgModVariables.MapVariables.get(world).OverworldEvent + ", " + IterRpgModVariables.MapVariables.get(world).OverworldEventTimer)), false);
	}
}
