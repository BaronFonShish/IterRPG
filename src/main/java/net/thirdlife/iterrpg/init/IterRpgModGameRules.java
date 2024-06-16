
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thirdlife.iterrpg.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IterRpgModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> FRAGILEBLOCKS = GameRules.register("fragileBlocks", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BUILDINGDEBUG = GameRules.register("buildingDebug", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
