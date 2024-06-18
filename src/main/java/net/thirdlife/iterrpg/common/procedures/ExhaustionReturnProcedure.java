package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.network.IterRpgModVariables;

import net.minecraft.world.entity.Entity;

public class ExhaustionReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String mana = "";
		double percentage = 0;
		double iter = 0;
		return Math.round((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).AetherExhaustion) + "/"
				+ Math.round((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).AetherExhaustionThreshold);
	}
}
