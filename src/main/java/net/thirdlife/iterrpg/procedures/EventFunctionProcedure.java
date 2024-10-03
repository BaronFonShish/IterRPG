package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EventFunctionProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double decideEvent = 0;
		double decideworld = 0;
		if (world.dayTime() >= 24000 * 7) {
			if (world.dayTime() % 24000 == 0 && IterRpgModVariables.MapVariables.get(world).config_events) {
				if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
					if (IterRpgModVariables.MapVariables.get(world).OverworldEventChance - IterRpgModVariables.MapVariables.get(world).event_mintime >= Mth.nextInt(RandomSource.create(), 1,
							(int) IterRpgModVariables.MapVariables.get(world).event_maxtime)) {
						IterRpgModVariables.MapVariables.get(world).OverworldEventChance = 0;
						IterRpgModVariables.MapVariables.get(world).syncData(world);
						if (world.dayTime() >= 24000 * 90) {
							decideEvent = Mth.nextInt(RandomSource.create(), 1, 10);
						} else if (world.dayTime() >= 24000 * 30) {
							decideEvent = Mth.nextInt(RandomSource.create(), 1, 8);
						} else {
							decideEvent = Mth.nextInt(RandomSource.create(), 1, 6);
						}
						decideEvent = Mth.nextInt(RandomSource.create(), 1, 2);
						if (decideEvent == 1) {
							IterRpgModVariables.MapVariables.get(world).OverworldEvent = "iterpg.event.end_rift";
							IterRpgModVariables.MapVariables.get(world).syncData(world);
						} else if (decideEvent == 2) {
							IterRpgModVariables.MapVariables.get(world).OverworldEvent = "iterpg.event.insect_season";
							IterRpgModVariables.MapVariables.get(world).syncData(world);
						} else if (decideEvent == 3) {
							IterRpgModVariables.MapVariables.get(world).OverworldEvent = "iterpg.event.monsoon";
							IterRpgModVariables.MapVariables.get(world).syncData(world);
						} else if (decideEvent == 4) {
							IterRpgModVariables.MapVariables.get(world).OverworldEvent = "iterpg.event.slimy_soil";
							IterRpgModVariables.MapVariables.get(world).syncData(world);
						} else if (decideEvent == 5) {
							IterRpgModVariables.MapVariables.get(world).OverworldEvent = "iterpg.event.elemental_fury";
							IterRpgModVariables.MapVariables.get(world).syncData(world);
						} else if (decideEvent == 6) {
							IterRpgModVariables.MapVariables.get(world).OverworldEvent = "iterpg.event.grave_chill";
							IterRpgModVariables.MapVariables.get(world).syncData(world);
						} else if (decideEvent == 7) {
							IterRpgModVariables.MapVariables.get(world).OverworldEvent = "iterpg.event.hell_gates";
							IterRpgModVariables.MapVariables.get(world).syncData(world);
						} else if (decideEvent == 8) {
							IterRpgModVariables.MapVariables.get(world).OverworldEvent = "iterpg.event.etherstorm";
							IterRpgModVariables.MapVariables.get(world).syncData(world);
						}
						IterRpgModVariables.MapVariables.get(world).OverworldEventTimer = IterRpgModVariables.MapVariables.get(world).event_duration * 24000;
						IterRpgModVariables.MapVariables.get(world).syncData(world);
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("\u00A7d[Iter RPG]"), false);
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + Component.translatable("iterpg.event.notif").getString())), false);
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + Component.translatable(IterRpgModVariables.MapVariables.get(world).OverworldEvent).getString())), false);
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Component.translatable((IterRpgModVariables.MapVariables.get(world).OverworldEvent + ".desc")).getString())), false);
					} else {
						IterRpgModVariables.MapVariables.get(world).OverworldEventChance = IterRpgModVariables.MapVariables.get(world).OverworldEventChance + 1;
						IterRpgModVariables.MapVariables.get(world).syncData(world);
					}
				}
			}
		}
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
			if (!(IterRpgModVariables.MapVariables.get(world).OverworldEvent).equals("")) {
				if (IterRpgModVariables.MapVariables.get(world).OverworldEventTimer > 0) {
					IterRpgModVariables.MapVariables.get(world).OverworldEventTimer = IterRpgModVariables.MapVariables.get(world).OverworldEventTimer - 1;
					IterRpgModVariables.MapVariables.get(world).syncData(world);
				} else {
					IterRpgModVariables.MapVariables.get(world).OverworldEvent = "";
					IterRpgModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
	}
}
