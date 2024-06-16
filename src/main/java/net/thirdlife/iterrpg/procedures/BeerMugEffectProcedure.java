package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class BeerMugEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.getAbsorptionAmount() : 0) < 10) {
			if (entity instanceof LivingEntity _entity)
				_entity.setAbsorptionAmount((float) ((entity instanceof Player _plr ? _plr.getAbsorptionAmount() : 0) + 2));
		}
	}
}
