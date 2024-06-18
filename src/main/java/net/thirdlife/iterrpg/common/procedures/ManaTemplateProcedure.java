package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.common.network.IterRpgModVariables;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;

public class ManaTemplateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double distance = 0;
		double damage = 0;
		double directionx = 0;
		double directionz = 0;
		BlockState directiony = Blocks.AIR.defaultBlockState();
		boolean hit = false;
		boolean particle = false;
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MagicCooldown < 10) {
			{
				double _setval = 10;
				entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MagicCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
