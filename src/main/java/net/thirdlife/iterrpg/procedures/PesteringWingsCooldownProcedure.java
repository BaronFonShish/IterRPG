package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.entity.Entity;

public class PesteringWingsCooldownProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.onGround() && (entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).flaps_left == 0) {
			{
				double _setval = 1;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.flaps_left = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
