package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.entity.Entity;

public class AetherExhaustionBarReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String mana = "";
		double percentage = 0;
		double iter = 0;
		percentage = ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).AetherExhaustion
				/ (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).AetherExhaustionThreshold) * 10;
		iter = 0;
		mana = "";
		for (int index0 = 0; index0 < 10; index0++) {
			iter = iter + 1;
			if (percentage > iter) {
				mana = mana + "0";
			} else {
				mana = mana + "-";
			}
		}
		return mana;
	}
}
