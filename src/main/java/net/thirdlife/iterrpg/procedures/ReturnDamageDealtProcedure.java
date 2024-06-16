package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.entity.Entity;

public class ReturnDamageDealtProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).LastDamageDealt;
	}
}
