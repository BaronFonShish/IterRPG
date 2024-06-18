package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModGameRules;
import net.thirdlife.iterrpg.init.IterRpgModBlocks;
import net.thirdlife.iterrpg.IterRpgMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class SpiderEggMagicHatchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty() && !world.getLevelData().getGameRules().getBoolean(IterRpgModGameRules.BUILDINGDEBUG)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANT, (x + 0.5), (y + 1.5), (z + 0.5), 16, 0.3, 0.3, 0.3, 0);
			IterRpgMod.queueServerWork(Mth.nextInt(RandomSource.create(), 20, 30), () -> {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == IterRpgModBlocks.SPIDER_EGG.get()) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					CocoonExplodeProcedure.execute(world, x, y, z);
				}
			});
		}
	}
}
