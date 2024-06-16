package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MageStatusReturnProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static boolean execute(Entity entity) {
		return execute(null, entity);
	}

	private static boolean execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return false;
		boolean valid = false;
		ItemStack spell = ItemStack.EMPTY;
		ItemStack spellbook = ItemStack.EMPTY;
		double cooldown = 0;
		double slot = 0;
		if ((entity.getCapability(IterRpgModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new IterRpgModVariables.PlayerVariables())).MageStatus) {
			return true;
		}
		return false;
	}
}
