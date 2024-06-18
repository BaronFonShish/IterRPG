package net.thirdlife.iterrpg.common.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class InsatiableSummonProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		boolean summon = false;
		boolean proceed = false;
		double chance = 0;
		double xrand = 0;
		double zrand = 0;
	}
}
