package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class SpiderPlaceWebProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xplace = 0;
		double yplace = 0;
		double zplace = 0;
		double decideblock = 0;
		entity.getPersistentData().putDouble("tileplace", (entity.getPersistentData().getDouble("tileplace") + 1));
		entity.getPersistentData().putDouble("timer", (800 - entity.getPersistentData().getDouble("cocooncharge")));
		if (entity instanceof Spider _spider)
			_spider.setClimbing(true);
		if (entity.getPersistentData().getDouble("tileplace") >= entity.getPersistentData().getDouble("timer")) {
			xplace = Mth.nextInt(RandomSource.create(), -2, 2);
			yplace = Mth.nextInt(RandomSource.create(), -1, 0);
			zplace = Mth.nextInt(RandomSource.create(), -2, 2);
			if (world.isEmptyBlock(BlockPos.containing(x + xplace, y + yplace, z + zplace))) {
				if (!world.isEmptyBlock(BlockPos.containing(x + xplace, (y + yplace) - 1, z + zplace)) && entity.getPersistentData().getDouble("cocooncharge") >= 8) {
					decideblock = Mth.nextDouble(RandomSource.create(), 0, 12);
					if (decideblock > 0 && decideblock <= 3) {
						if (entity.getPersistentData().getDouble("cocooncharge") >= 1) {
							world.setBlock(BlockPos.containing(x + xplace, y + yplace, z + zplace), Blocks.TRIPWIRE.defaultBlockState(), 3);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + xplace), (y + yplace), (z + zplace), 8, 0.3, 0.3, 0.3, 0.025);
							entity.getPersistentData().putDouble("cocooncharge", (entity.getPersistentData().getDouble("cocooncharge") - 1));
						}
					}
					if (decideblock > 3 && decideblock <= 8) {
						if (entity.getPersistentData().getDouble("cocooncharge") >= 4) {
							world.setBlock(BlockPos.containing(x + xplace, y + yplace, z + zplace), Blocks.COBWEB.defaultBlockState(), 3);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + xplace), (y + yplace), (z + zplace), 12, 0.3, 0.3, 0.3, 0.025);
							entity.getPersistentData().putDouble("cocooncharge", (entity.getPersistentData().getDouble("cocooncharge") - 4));
						}
					}
					if (decideblock > 8 && decideblock <= 12) {
						if (entity.getPersistentData().getDouble("cocooncharge") >= 8) {
							world.setBlock(BlockPos.containing(x + xplace, y + yplace, z + zplace), IterRpgModBlocks.SPIDER_EGG.get().defaultBlockState(), 3);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x + xplace), (y + yplace), (z + zplace), 16, 0.3, 0.3, 0.3, 0.025);
							entity.getPersistentData().putDouble("cocooncharge", (entity.getPersistentData().getDouble("cocooncharge") - 8));
						}
					}
				}
			}
			entity.getPersistentData().putDouble("tileplace", 0);
			entity.getPersistentData().putDouble("cocooncharge", (entity.getPersistentData().getDouble("cocooncharge") + 0.05));
		}
	}
}
