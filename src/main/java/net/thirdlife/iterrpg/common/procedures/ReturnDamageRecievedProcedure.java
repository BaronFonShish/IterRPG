package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.network.IterRpgModVariables;

import net.minecraft.world.entity.Entity;

public class ReturnDamageRecievedProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).LastDamageRecieved;
	}
}
