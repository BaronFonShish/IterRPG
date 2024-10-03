package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.network.IterRpgModVariables;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class EventSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double decide = 0;
		if (!(IterRpgModVariables.MapVariables.get(world).OverworldEvent).equals("") && (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
			if ((IterRpgModVariables.MapVariables.get(world).OverworldEvent).equals("iterpg.event.end_rift") && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				return true;
			}
			if ((IterRpgModVariables.MapVariables.get(world).OverworldEvent).equals("iterpg.event.insect_season") && world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f >= 0) {
				return true;
			}
			if ((IterRpgModVariables.MapVariables.get(world).OverworldEvent).equals("iterpg.event.grave_chill") && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("iter_rpg:grave_chill_blocks"))) && world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f <= 0) {
				return true;
			}
		}
		return false;
	}
}
