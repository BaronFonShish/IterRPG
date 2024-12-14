package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class DemonRegenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("demonregen") >= 50 && entity.isAlive()) {
			entity.getPersistentData().putDouble("demonregen", 0);
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (35 + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) / 500));
			}
		} else {
			entity.getPersistentData().putDouble("demonregen", (entity.getPersistentData().getDouble("demonregen") + 1));
		}
	}
}
