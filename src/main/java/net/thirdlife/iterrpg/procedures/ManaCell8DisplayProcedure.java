package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.entity.Entity;

public class ManaCell8DisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		String mana = "";
		double percentage = 0;
		double iter = 0;
		percentage = ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).Mana
				/ (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MaxMana) * 10;
		iter = 8;
		if (percentage >= iter) {
			return true;
		}
		return false;
	}
}
