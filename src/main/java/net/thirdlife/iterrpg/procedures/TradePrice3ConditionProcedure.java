package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.entity.Entity;

public class TradePrice3ConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).PlayerCoinAmount > (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new IterRpgModVariables.PlayerVariables())).price3) {
			return false;
		}
		return true;
	}
}
