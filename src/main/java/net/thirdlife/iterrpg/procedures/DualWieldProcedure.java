package net.thirdlife.iterrpg.procedures;

import org.checkerframework.checker.units.qual.cd;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DualWieldProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		double offdamage = 0;
		double cd = 0;
	}
}
